FROM openjdk:17-jdk-slim

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} app_eureka.jar

ENTRYPOINT [ "java", "-jar", "app_eureka.jar" ]
