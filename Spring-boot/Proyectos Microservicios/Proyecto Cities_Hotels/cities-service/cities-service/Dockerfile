FROM openjdk:17-jdk-slim

ARG JAR_FILE=target/cities-service-0.0.1.jar

COPY ${JAR_FILE} app_cities-service.jar

ENTRYPOINT [ "java", "-jar", "app_cities-service.jar"]