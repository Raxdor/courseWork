FROM openjdk:11-jdk
VOLUME /tmp
COPY target/inventory-service-0.0.1-SNAPSHOT.jar inv-ser.jar
ENTRYPOINT ["java","-jar","/inv-ser.jar"]