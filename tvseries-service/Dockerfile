FROM openjdk:17
LABEL MAINTAINER="MIU"
LABEL APPLICATION="tvseries-service"

COPY target/tvseries-service.jar tvseries-service.jar
ENTRYPOINT ["java","-jar","tvseries-service.jar"]
