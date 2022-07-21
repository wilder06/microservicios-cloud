FROM openjdk:11
VOLUME /tmp
ADD ./target/car-service-0.0.1-SNAPSHOT.jar car-service.jar
ENTRYPOINT ["java","-jar","/car-service.jar"]