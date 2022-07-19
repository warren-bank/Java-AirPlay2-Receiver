package com.github.serezhka.jap2lib;

/*
 * -----------------------------------------------------------------------------
 * Based on:
 *   https://github.com/openairplay/AirPlayAuth/blob/master/src/main/java/eu/airaudio/airplay/auth/AuthUtils.java
 *   https://github.com/openairplay/AirPlayAuth/blob/master/src/main/java/eu/airaudio/airplay/auth/crypt/srp6/ServerEvidenceRoutineImpl.java
 * Created by:
 *   Martin on 24.05.2017
 * -----------------------------------------------------------------------------
 * Also:
 *   https://github.com/Fi5t/NimbusSRP-Android/blob/master/nimbusds/src/main/java/com/nimbusds/srp6/BigIntegerUtils.java
 * -----------------------------------------------------------------------------
 */

import com.dd.plist.NSDictionary;
import com.dd.plist.PropertyListParser;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Map;

public class AuthUtils {

    public static NSDictionary parsePostData(InputStream request) throws Exception {
        try (ByteArrayOutputStream postData = new ByteArrayOutputStream();) {
            byte[] buffer = new byte[0xFFFF];

            for (int len; (len = request.read(buffer)) != -1; ) {
                postData.write(buffer, 0, len);
            }

            postData.flush();

            return (NSDictionary) PropertyListParser.parse(postData.toByteArray());
        }
    }

    public static byte[] createPList(Map<String, ? extends Object> properties) throws IOException {
        ByteArrayOutputStream plistOutputStream = new ByteArrayOutputStream();
        NSDictionary root = new NSDictionary();
        for (Map.Entry<String, ? extends Object> property : properties.entrySet()) {
            root.put(property.getKey(), property.getValue());
        }
        PropertyListParser.saveAsBinary(root, plistOutputStream);
        return plistOutputStream.toByteArray();
    }

    public static byte[] computeM2(byte[] salt, byte[] clientPk, byte[] clientProof) throws Exception {
        MessageDigest digest;

        digest = MessageDigest.getInstance("SHA-1");
        digest.update(salt);
        digest.update(new byte[]{0, 0, 0, 0});
        byte[] K1 = digest.digest();
        digest.update(salt);
        digest.update(new byte[]{0, 0, 0, 1});
        byte[] K2 = digest.digest();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        outputStream.write(K1);
        outputStream.write(K2);
        byte[] sessionKeyHash = outputStream.toByteArray();

        digest = MessageDigest.getInstance("SHA-1");
        digest.update(clientPk);
        digest.update(clientProof);
        digest.update(sessionKeyHash);
        BigInteger computedM2 = new BigInteger(1, digest.digest());
        return bigIntegerToBytes(computedM2);
    }

    public static byte[] bigIntegerToBytes(final BigInteger bigInteger) {
        byte[] bytes = bigInteger.toByteArray();
        return (bytes[0] == 0)
            ? Arrays.copyOfRange(bytes, 1, bytes.length)
            : bytes;
    }
}
