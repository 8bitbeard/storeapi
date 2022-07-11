FROM adoptopenjdk:11-jre-hotspot
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} storeapi.jar
ENTRYPOINT ["java", "-jar", "storeapi.jar"]
EXPOSE 8080