FROM openjdk:8-jdk-alpine
EXPOSE 8089
#ADD target/gestion-station-ski-1.0.jar gestion-station-ski.jar
ADD http://192.168.1.19:8081/repository/maven-snapshots/tn/esprit/spring/gestion-station-ski/1.0-SNAPSHOT/gestion-station-ski-1.0-20231104.132507-1.jar /gestion-station-ski-1.0-20231104.132507-1.jar
ENTRYPOINT ["java","-jar","gestion-station-ski-1.0-20231104.132507-1.jar" ]