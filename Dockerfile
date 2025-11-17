FROM eclipse-temurin:21-jdk

WORKDIR /app

# Gradle 기준: build/libs 안에 만들어진 실행 가능한 JAR 복사
COPY ./build/libs/*SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "/app/app.jar"]
