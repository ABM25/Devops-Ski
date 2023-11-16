FROM openjdk:8-jdk-alpine
COPY target/*.jar /
EXPOSE 5256
ENTRYPOINT ["java","-jar","/gestion-station-ski-1.0-SNAPSHOT.jar"]
