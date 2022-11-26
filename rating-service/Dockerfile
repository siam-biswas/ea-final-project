FROM openjdk:17
LABEL MAINTAINER="MIU"
LABEL APPLICATION="rating-service"

COPY target/rating-service.jar rating-service.jar
ENTRYPOINT ["java","-jar","rating-service.jar"]
