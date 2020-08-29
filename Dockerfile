FROM openjdk:8-jdk-alpine
COPY target/filmeflix-*.jar filmeflix.jar
ENTRYPOINT ["java", "-jar", "/filmeflix.jar"]