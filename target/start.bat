@echo off

setlocal enabledelayedexpansion
set JAVA=D:\"Program Files"\Genuitec\Common\binary\com.sun.java.jdk.win32.x86_1.6.0.013\bin\java
set OPTS=-Xms512M -Xmx512M -Xss128k -XX:+AggressiveOpts -XX:+UseParallelGC -XX:NewSize=64M
set LIBPATH=lib\
set CONFIG=config\
set ENGINE=jar\app.jar
set CP=%CONFIG%;%ENGINE%;
set MAIN=com.app.main.Startup

for /f %%i in ('dir /b %LIBPATH%\*.jar') do (
   set CP=!CP!%LIBPATH%\%%i;
)

echo ===============================================================================
echo.
echo   Engine Startup Environment
echo.
echo   JAVA: %JAVA%
echo.
echo   CONFIG: %CONFIG%
echo.
echo   JAVA_OPTS: %OPTS%
echo.
echo   CLASSPATH: %CP%
echo.
echo ===============================================================================
echo.

%JAVA% %OPTS% -cp %CP% %MAIN%
