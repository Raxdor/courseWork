FROM openjdk:11-jdk
VOLUME /tmp
COPY target/pricing-service-0.0.1-SNAPSHOT.jar pric-ser.jar
ENTRYPOINT ["java","jar","/pric-ser.jar"]