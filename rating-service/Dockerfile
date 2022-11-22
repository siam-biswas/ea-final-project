FROM openjdk:19
LABEL MAINTAINER="MIU"
LABEL APPLICATION="rating-service"
WORKDIR ./
COPY target/rating-0.0.1-SNAPSHOT.jar rating-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","rating-0.0.1-SNAPSHOT.jar"]
EXPOSE 8080