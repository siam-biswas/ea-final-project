FROM openjdk:17
LABEL MAINTAINER="MIU"
LABEL APPLICATION="comment-service"
WORKDIR ./
ADD target/comment-service.jar comment-service.jar
ENTRYPOINT ["java","-jar","comment-service.jar"]
EXPOSE 8092