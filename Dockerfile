FROM openjdk:11
COPY target/achat.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
