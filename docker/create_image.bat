cd ../SPA-app

:: Copy generated resources on static
del /Q ..\Backend\src\main\resources\static\new\*
copy /Y dist\SPA-app\* ..\Backend\src\main\resources\static\new

cd ../Backend

:: Create jar
docker run -it --rm -v "%cd%":/usr/src/project -w /usr/src/project maven mvn clean package -DskipTests

:: Copy jar and images
copy target\swapit_server-0.0.1-SNAPSHOT.jar ..\docker\
copy images\products ..\docker\build\images\products\
cd ../docker

FOR /f "tokens=*" %%i IN ('docker ps -aq') DO docker stop %%i
FOR /f "tokens=*" %%i IN ('docker ps -aq') DO docker rm %%i
docker rmi -f app

:: Build app image
docker build -t app .