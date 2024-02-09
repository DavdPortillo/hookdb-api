FROM amazoncorretto:17-alpine-jdk
EXPOSE 8080
ADD ./target/VictoryStationAPI-0.0.1.jar VictoryStationAPI-0.0.1.jar
ENTRYPOINT ["java","-jar","-Dspring.profiles.active=dev","/VictoryStationAPI-0.0.1.jar"]
