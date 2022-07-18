@echo off

call "%~dp0.\0-env.bat"

set LOG="%LOG_DIR%\%~n0.log"

cd "%~dp0..\..\src\airplay-server-netty-examples"

call gradle build >%LOG% 2>&1
