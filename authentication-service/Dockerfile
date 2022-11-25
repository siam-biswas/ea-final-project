FROM openjdk:17
LABEL MAINTAINER="MIU"
LABEL APPLICATION="authentication-service"

COPY target/authentication-service.jar authentication-service.jar
ENTRYPOINT ["java","-jar","authentication-service.jar"]
EXPOSE 9080