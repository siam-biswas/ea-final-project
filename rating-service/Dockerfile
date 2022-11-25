FROM openjdk:17
LABEL MAINTAINER="MIU"
LABEL APPLICATION="rating-service"
WORKDIR ./
COPY target/rating-service.jar rating-service.jar
ENTRYPOINT ["java","-jar","rating-service.jar"]
EXPOSE 8090