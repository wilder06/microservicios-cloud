FROM openjdk:11
VOLUME /tmp
EXPOSE 9411
ADD ./target/zipkin-server-2.23.18-exec.jar zipkin-server.jar
ENTRYPOINT ["java","-jar","/zipkin-server.jar"]