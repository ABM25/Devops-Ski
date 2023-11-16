FROM openjdk:11
ADD 	http://192.168.1.115:8081/repository/maven-snapshots/tn/esprit/spring/gestion-station-ski/1.0-SNAPSHOT/gestion-station-ski-1.0-20231116.010301-1.jar /gestion-station-ski-1.0-20231116.010301-1.jar
EXPOSE 8089
ENTRYPOINT ["java","-jar","/gestion-station-ski-1.0-20231116.010301-1.jar"]