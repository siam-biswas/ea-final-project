FROM openjdk:17
LABEL MAINTAINER="MIU"
LABEL APPLICATION="config-service"

COPY target/config-service.jar config-service.jar
ENTRYPOINT ["java","-jar","config-service.jar"]
EXPOSE 8888