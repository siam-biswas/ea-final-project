FROM openjdk:17
LABEL MAINTAINER="MIU"
LABEL APPLICATION="tvseries-service"
WORKDIR ./
COPY target/tvseries-service.jar tvseries-service.jar
ENTRYPOINT ["java","-jar","tvseries-service.jar"]
EXPOSE 8094