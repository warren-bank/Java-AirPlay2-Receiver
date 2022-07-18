#### [Java AirPlay2 Receiver](https://github.com/warren-bank/Java-AirPlay2-Receiver)

Fork of the work done by [Sergio Fedorini](https://github.com/serezhka) to implement an AirPlay2 Receiver in Java.

- - - -

#### Changes:

* 1.0.5
  - all code is identical to the upstream projects
  - all projects have been combined into a monorepo
  - gradle build scripts have been updated to reference the libraries within the monorepo
  - shell scripts have been added to simplify building and running the server examples
* 1.0.6 (_TBA_)
  - implements the initial 3-step pairing handshake

- - - -

#### Credits:

* developer: [Sergio Fedorini](https://github.com/serezhka)
  - projects:
    * [java-airplay-lib](https://github.com/serezhka/java-airplay-lib)
      - summary:
        * a low-level library written in Java to handle inbound requests from an AirPlay2 client
        * cleverly, it does not implement an actual server
          - left as an exercise for the app that uses the library
          - does not commit the app to any particular HTTP library or framework
      - license: [MIT](https://github.com/serezhka/java-airplay-lib/blob/1.0.5/LICENSE)
    * [java-airplay-server](https://github.com/serezhka/java-airplay-server)
      - summary:
        * a higher-level library written in Java that uses `java-airplay-lib` and [Netty](https://github.com/netty/netty)
        * implements a minimal HTTP server
        * provides [an API](https://github.com/serezhka/java-airplay-server/blob/1.0.5/src/main/java/com/github/serezhka/jap2server/AirplayDataConsumer.java) for the app that uses the library to easily access the raw data sent by a client
      - license: [MIT](https://github.com/serezhka/java-airplay-server/blob/1.0.5/LICENSE)
    * [java-airplay-server-examples](https://github.com/serezhka/java-airplay-server-examples)
      - summary:
        * a collection of demo apps
          - all of which uses `java-airplay-server`
        * my personal favorites:
          - [vlcj player](https://github.com/serezhka/java-airplay-server-examples/tree/master/vlcj-player)
            * uses [vlcj](https://github.com/caprica/vlcj) to provide a bridge between the Java app and VLC
              - VLC must be found on _PATH_
              - VLC must be the same architecture (ie: 32-bit vs. 64-bit) as the Java runtime used to run the app
          - [h264-dump](https://github.com/serezhka/java-airplay-server-examples/tree/master/h264-dump)
            * great for debugging
            * produces the following output files:
              - _dump.h264_
                * contains all video data received from a client
              - _dump.alac_
                * contains all audio data received from a client
              - _log_
                * contains all log messages produced by the app during its execution
      - license: [MIT](https://github.com/serezhka/java-airplay-server-examples/blob/master/LICENSE)
* developer: [Martin](https://github.com/funtax)
  - projects:
    * [AirPlayAuth](https://github.com/funtax/AirPlayAuth)
      - ownership of repo has since been transferred to: [_openairplay_](https://github.com/openairplay/AirPlayAuth)
      - summary:
        * a low-level library written in Java to implement an AirPlay2 client
      - observations:
        * implements the initial 3-step pairing handshake that `java-airplay-lib` and `java-airplay-server` [do not](https://github.com/serezhka/java-airplay-server/issues/5)
        * being able to inspect the client side of this handshake is very helpful to implement it on the server side
      - license: [MIT](https://github.com/openairplay/AirPlayAuth/blob/master/LICENSE)

- - - -

#### Legal:

* with respect to new code contributions:
  - copyright: [Warren Bank](https://github.com/warren-bank)
  - license: [GPL-2.0](https://www.gnu.org/licenses/old-licenses/gpl-2.0.txt)
