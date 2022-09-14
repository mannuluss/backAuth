FROM openjdk:20-slim-buster
COPY "./target/TurismoAppPro-0.0.1-SNAPSHOT.jar" "app-turismo-auth.jar"
ENTRYPOINT ["java", "-jar", "app-turismo-auth.jar"]
EXPOSE 8081