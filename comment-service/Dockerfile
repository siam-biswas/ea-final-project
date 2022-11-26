FROM openjdk:17
LABEL MAINTAINER="miu"
LABEL APPLICATION="comment-service"
COPY target/comment-service.jar comment-service.jar
ENTRYPOINT ["java","-jar","comment-service.jar"]
