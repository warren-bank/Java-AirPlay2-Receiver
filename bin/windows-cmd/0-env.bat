@echo off

rem :: =================================
rem :: version:
rem ::   https://redirector.gvt1.com/edgedl/android/studio/ide-zips/2020.3.1.25/android-studio-2020.3.1.25-windows.zip
rem :: =================================
set JDK_HOME=C:\Android\android-studio\jre
set PATH=%JDK_HOME%\bin;%PATH%

rem :: =================================
rem :: version:
rem ::   https://services.gradle.org/distributions/gradle-7.3-all.zip
rem :: =================================
set GRADLE_HOME=%USERPROFILE%\.gradle\wrapper\dists\gradle-7.3-all\dfe0rb4hnplvqkibhoc45how8\gradle-7.3
set PATH=%GRADLE_HOME%\bin;%PATH%

rem :: =================================
rem :: airplay-server-netty-examples:
rem ::   vlcj-player
rem :: =================================
rem :: version:
rem ::   http://download.videolan.org/pub/videolan/vlc/3.0.17.4/win64/vlc-3.0.17.4-win64.7z
rem :: =================================
set VLC_HOME=C:\PortableApps\VLC\3.0.17.4-win64
set PATH=%VLC_HOME%;%PATH%

rem :: =================================
rem :: directory to save log files
rem :: =================================
set LOG_DIR=%~dp0.\out
if not exist "%LOG_DIR%" mkdir "%LOG_DIR%"

rem :: =================================
rem :: constants
rem :: =================================
set RELEASE_VERSION=1.0.6
