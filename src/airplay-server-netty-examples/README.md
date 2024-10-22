# java-airplay-server-examples

Forked from:

* git repo: [java-airplay-server-examples](https://github.com/serezhka/java-airplay-server-examples)
  - date: Jun 12, 2022
  - commit: [640ded43d97f5528345ed58cb91834db960f3de7](https://github.com/serezhka/java-airplay-server-examples/tree/640ded43d97f5528345ed58cb91834db960f3de7)
  - license: [MIT](https://github.com/serezhka/java-airplay-server-examples/blob/640ded43d97f5528345ed58cb91834db960f3de7/LICENSE)

- - - -

All examples were tested with iPhone X (iOS 14.0.1)

## gstreamer-player

09.06.2022 supports both video and audio (alac + aac_eld)

Gstreamer installation required (see https://github.com/gstreamer-java/gst1-java-core)

<details>
  <summary>video demo</summary>

https://user-images.githubusercontent.com/476359/173236828-204a64c0-54da-4020-93c7-2987c4f9301c.mp4
</details>


TODO description

## tcp-forwarder

Forwards video and audio data to TCP

Play it with [GStreamer](https://gstreamer.freedesktop.org/) or [FFmpeg](https://www.ffmpeg.org/)

```Shell
cd tcp-forwarder/

gradle bootRun

gst-launch-1.0 -v tcpclientsrc port=5002 ! h264parse ! avdec_h264 ! autovideosink

or 

ffplay -f h264 -codec:v h264 -i tcp://localhost:5002 -v debug

ffplay -autoexit -f s16le -ar 44100 -ac 2 tcp://localhost:5003
```

You need to compile [lib-fdk-aac](https://github.com/serezhka/fdk-aac-jni) for aac-eld decoding

<details>
  <summary>gif demo</summary>

<img src="https://github.com/serezhka/java-airplay-server-examples/blob/media/gstreamer_playback.gif" width="600">
</details>


## h264-dump

Saves video data stream to .h264 file, decoded audio to .pcm file

```Shell
cd h264-dump/

gradle bootRun

ffplay -autoexit -f s16le -ar 44100 -ac 2 dump.pcm
```

You need to compile [lib-fdk-aac](https://github.com/serezhka/fdk-aac-jni) for aac-eld decoding

## vlcj-player

Playback screen mirroring in embedded vlc\
Install VLC (https://github.com/caprica/vlcj)

```Shell
cd vlcj-player/

gradle bootRun
```

<details>
  <summary>gif demo</summary>

<img src="https://github.com/serezhka/java-airplay-server/blob/media/vlcj_player_demo.gif" width="600">
</details>


## jmuxer-player

Playback screen mirroring with [jmuxer](https://github.com/samirkumardas/jmuxer)

```Shell
cd vlcj-player/

gradle bootRun
```

open index-h264.html in browser

<details>
  <summary>gif demo</summary>

<img src="https://github.com/serezhka/java-airplay-server/blob/media/jmuxer_player_demo.gif" width="600">
</details>
