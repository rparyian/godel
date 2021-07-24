FROM openjdk:8-jdk-alpine
MAINTAINER baeldung.com
COPY target/godel-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]