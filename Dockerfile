FROM openjdk:17-jdk-alpine
EXPOSE 8080
ADD ./api.jar api.jar
ENTRYPOINT ["java","-jar","-Dspring.profiles.active=dev","/api.jar"]
