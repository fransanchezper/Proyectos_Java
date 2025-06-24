FROM openjdk:17-jdk-slim

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} app_users-service.jar

ENTRYPOINT [ "java", "-jar", "app_users-service.jar"]

