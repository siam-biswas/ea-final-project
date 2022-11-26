FROM openjdk:17
LABEL MAINTAINER="miu"
LABEL APPLICATION="movie-service"

COPY target/movie-service.jar movie-service.jar
ENTRYPOINT ["java","-jar","movie-service.jar"]
