FROM openjdk:8-jdk-alpine
EXPOSE 5256

ADD http://192.168.1.24:8081/repository/maven-snapshots/tn/esprit/spring/gestion-station-ski/1.0-SNAPSHOT/gestion-station-ski-1.0-20231116.112907-40.jar /gestion-station-ski-1.0-20231116.112907-40.jar
ENTRYPOINT ["java", "-jar", "/gestion-station-ski-1.0-20231116.112907-40.jar"]