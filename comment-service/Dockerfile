FROM openjdk:19
LABEL MAINTAINER="MIU"
LABEL APPLICATION="comment-service"
WORKDIR ./
COPY target/user-0.0.1-SNAPSHOT.jar user-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","user-0.0.1-SNAPSHOT.jar"]
EXPOSE 8082