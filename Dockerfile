FROM openjdk:21

VOLUME /tmp

ARG JAR_FILE=target/project-service-0.0.1-SNAPSHOT.jar

ADD ${JAR_FILE} app.jar

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]