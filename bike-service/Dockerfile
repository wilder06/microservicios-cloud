FROM openjdk:11
VOLUME /tmp
ADD ./target/bike-service-0.0.1-SNAPSHOT.jar bike-service.jar
ENTRYPOINT ["java","-jar","/bike-service.jar"]