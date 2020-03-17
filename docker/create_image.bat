cd ../Backend

:: Create jar
docker run -it --rm -v "%cd%":/usr/src/project -w /usr/src/project maven mvn clean package -DskipTests

:: Copy jar and images
copy target\swapit_server-0.0.1-SNAPSHOT.jar ..\docker\build\
copy images\products ..\docker\build\images\products\
cd ../docker

FOR /f "tokens=*" %%i IN ('docker ps -aq') DO docker stop %%i
FOR /f "tokens=*" %%i IN ('docker ps -aq') DO docker rm %%i
docker rmi -f app

:: Build app image
docker build -t app .