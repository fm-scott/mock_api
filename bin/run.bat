
@echo off

echo [��Ϣ] ����Web���̡�
echo.

cd %~dp0/..
cd ../mock_api/target

set JAVA_OPTS=-Xms256m -Xmx1024m -XX:MetaspaceSize=128m -XX:MaxMetaspaceSize=512m

java -jar %JAVA_OPTS% mock_api.jar

cd bin
pause