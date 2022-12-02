FROM openjdk:11
COPY target/achat.1.0.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
