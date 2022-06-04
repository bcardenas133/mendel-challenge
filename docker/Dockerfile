FROM openjdk:17
ARG JAR_FILE=*.jar
ADD app-0.0.1-SNAPSHOT.jar application.jar
ENTRYPOINT ["java", "-jar", "application.jar"]
EXPOSE 8080