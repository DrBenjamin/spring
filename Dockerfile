# Build stage
FROM openjdk:17-jdk-slim AS build
RUN apt-get update && apt-get install -y maven
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

# Package stage
FROM openjdk:17-jdk-slim
COPY --from=build /home/app/target/spring-0.0.1-SNAPSHOT.jar /usr/local/lib/spring.jar
EXPOSE 8081
ENTRYPOINT ["java", "-Dserver.port=8081", "-jar", "/usr/local/lib/spring.jar"]