# 1단계: 빌드 단계 (Gradle + JDK)
FROM gradle:8.10.2-jdk21 AS builder

WORKDIR /workspace

# Gradle 캐시 활용을 위해 먼저 빌드 스크립트만 복사
COPY build.gradle settings.gradle gradlew ./
COPY gradle ./gradle

# gradlew 실행 권한 부여 (혹시 권한 안 올라간 경우 대비)
RUN chmod +x gradlew

# 의존성만 먼저 받아두기 (옵션)
RUN ./gradlew dependencies --no-daemon || true

# 실제 소스 복사
COPY src ./src

# Spring Boot 실행 JAR 빌드
RUN ./gradlew clean bootJar --no-daemon

# 2단계: 런타임 단계 (가벼운 JDK/JRE 이미지)
FROM eclipse-temurin:21-jdk

WORKDIR /app

# 빌드 결과 JAR 파일만 복사
COPY --from=builder /workspace/build/libs/*.jar app.jar

# 애플리케이션 실행
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
