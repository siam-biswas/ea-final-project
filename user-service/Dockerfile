FROM openjdk:17
LABEL MAINTAINER="MIU"
LABEL APPLICATION="user-service"

COPY target/user-service.jar user-service.jar
ENTRYPOINT ["java","-jar","user-service.jar"]
EXPOSE 8091