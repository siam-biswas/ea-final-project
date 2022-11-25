FROM openjdk:17
LABEL MAINTAINER="MIU"
LABEL APPLICATION="movie-service"

COPY target/movie-service.jar movie-service.jar
ENTRYPOINT ["java","-jar","movie-service.jar"]
EXPOSE 8093