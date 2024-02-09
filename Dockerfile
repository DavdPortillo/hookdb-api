FROM amazoncorretto:17-alpine-jdk
EXPOSE 8080
ADD ./api.jar api.jar
ENTRYPOINT ["java","-jar","-Dspring.profiles.active=dev","/api.jar"]
