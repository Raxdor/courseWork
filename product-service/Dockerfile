FROM openjdk:11-jdk
VOLUME /tmp
COPY target/product-service-0.0.1-SNAPSHOT.jar prod-ser.jar
ENTRYPOINT ["java","-jar","/prod-ser.jar"]