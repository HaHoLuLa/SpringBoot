FROM openjdk:21-jdk

WORKDIR /app

COPY ./build/libs/*SNAPSHOT.jar app.jar

ENTRYPOINT [ "java", "-jar", "/app/app.jar" ]