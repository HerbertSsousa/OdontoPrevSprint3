FROM openjdk:17-jdk-alpine
ADD target/Sprint1Odonto-0.0.1-SNAPSHOT.jar Sprint1Odonto-0.0.1-SNAPSHOT.jar
expose 8080
ENTRYPOINT ["java","-jar","/Sprint1Odonto-0.0.1-SNAPSHOT.jar"]