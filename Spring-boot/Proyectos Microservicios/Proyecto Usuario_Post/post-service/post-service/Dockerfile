FROM openjdk:17-jdk-slim

ARG JAR_FILE=target/post-service-0.0.1.jar

COPY ${JAR_FILE} app_post-service.jar

ENTRYPOINT [ "java", "-jar", "app_post-service.jar"]


