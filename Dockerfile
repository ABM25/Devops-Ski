FROM openjdk:11 
EXPOSE 8089

ADD http://192.168.1.198:8081/repository/maven-snapshots/tn/esprit/spring/gestion-station-ski/1.0-SNAPSHOT/gestion-station-ski-1.0-20231104.133526-1.jar /gestion-station-ski-1.0-20231104.133526-1.jar
ENTRYPOINT ["java", "-jar", "/gestion-station-ski-1.0-20231104.133526-1.jar"]
