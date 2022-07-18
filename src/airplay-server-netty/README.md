# java-airplay-server

Forked from:

* git repo: [java-airplay-server](https://github.com/serezhka/java-airplay-server)
  - tag: [1.0.5](https://github.com/serezhka/java-airplay-server/releases/tag/1.0.5)
  - date: Jun 09, 2022
  - commit: [022e9a3427cc60ce43139af2e8ab1cee9ca7e071](https://github.com/serezhka/java-airplay-server/tree/022e9a3427cc60ce43139af2e8ab1cee9ca7e071)
  - author: [Sergio Fedorini](https://github.com/serezhka)
  - license: [MIT](https://github.com/serezhka/java-airplay-server/blob/1.0.5/LICENSE)

- - - -

This is example of [java-airplay-lib](https://github.com/serezhka/java-airplay-lib) usage.

It's under development.

## How to use?

* Add java-airplay-server [dependency](https://jitpack.io/#serezhka/java-airplay-server) to your project

* Implement AirplayDataConsumer and start AirPlayServer, for example:
```java
FileChannel videoFileChannel = FileChannel.open(Paths.get("video.h264"), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.WRITE);
FileChannel audioFileChannel = FileChannel.open(Paths.get("audio.pcm"), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.WRITE);

AirplayDataConsumer dumper = new AirplayDataConsumer() {
    
    @Override
    public void onVideo(byte[] video) {
        videoFileChannel.write(ByteBuffer.wrap(video));
    }

    
    @Override
    public void onAudio(byte[] audio) {
        if (FdkAacLib.isInitialized()) {
            byte[] audioDecoded = new byte[480 * 4];
            FdkAacLib.decodeFrame(audio, audioDecoded);
            audioFileChannel.write(ByteBuffer.wrap(audioDecoded));
        }
    }
};

String serverName = "AirPlayServer";
int airPlayPort = 15614;
int airTunesPort = 5001;
new AirPlayServer(serverName, airPlayPort, airTunesPort, dumper).start();
```

## More examples

see repo [java-airplay-server-examples](https://github.com/serezhka/java-airplay-server-examples)

<img src="https://github.com/serezhka/java-airplay-server-examples/blob/media/gstreamer_playback.gif" width="600">
