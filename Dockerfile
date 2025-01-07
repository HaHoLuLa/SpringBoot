FROM openjdk:21-jdk

WORKDIR /app

RUN ./gradlew clean build

COPY ./build/libs/*SNAPSHOT.jar app.jar

ENTRYPOINT [ "java", "-jar", "/app/app.jar" ]