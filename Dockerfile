FROM amazoncorretto:17-alpine-jdk
EXPOSE 8080
ADD ./VictoryStationAPI-0.0.1 VictoryStationAPI-0.0.1
ENTRYPOINT ["java","-jar","-Dspring.profiles.active=dev","/VictoryStationAPI-0.0.1"]
