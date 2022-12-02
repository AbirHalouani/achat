FROM openjdk:11
COPY achat-1.0.0.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
