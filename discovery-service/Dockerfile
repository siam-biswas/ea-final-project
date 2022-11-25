FROM openjdk:17
LABEL MAINTAINER="MIU"
LABEL APPLICATION="service-discovery"

COPY target/service-discovery.jar service-discovery.jar
ENTRYPOINT ["java","-jar","service-discovery.jar"]
EXPOSE 8761