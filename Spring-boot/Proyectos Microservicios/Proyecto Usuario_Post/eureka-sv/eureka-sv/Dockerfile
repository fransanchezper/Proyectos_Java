FROM openjdk:17-jdk-slim

ARG JAR_FILE=target/*.jar   
#eureka-sv-0.0.1.jar es lo mismo que lo de arriba con el * pero prefiere esta opcion por si cambia de version
COPY ${JAR_FILE} app_eureka.jar

ENTRYPOINT [ "java", "-jar", "app_eureka.jar" ]

