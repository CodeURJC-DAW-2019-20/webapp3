
FROM openjdk:8-jdk-alpine

COPY build/swapit_server-0.0.1-SNAPSHOT.jar  swapit_server-0.0.1-SNAPSHOT.jar
COPY /build/images /images
EXPOSE 8443
CMD ["java","-jar","swapit_server-0.0.1-SNAPSHOT.jar"]