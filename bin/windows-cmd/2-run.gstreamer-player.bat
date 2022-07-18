@echo off

call "%~dp0.\0-env.bat"

set PROJECT_NAME=gstreamer-player
set PROJECT_JAR="%~dp0..\..\src\airplay-server-netty-examples\%PROJECT_NAME%\build\libs\%PROJECT_NAME%-%RELEASE_VERSION%.jar"

if not exist %PROJECT_JAR% (
  echo JAR file not found.
  echo First, build the example apps. Then, run.
  exit /b 1
)

cd "%LOG_DIR%"

java -jar %PROJECT_JAR%
