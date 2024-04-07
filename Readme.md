Spring Boot Demo.

## Build the application and install dependencies

Run the tests with maven and build with all needed dependencies:

```bash
mvn wrapper:wrapper
./mvnw test -Dtest=SpringControllerTest
mvn clean install
```

## Run the application

Run demo on port `8081`:

```bash
java -Dserver.port=8081 -jar target/spring-0.0.1-SNAPSHOT.jar
```

## Run the application with Docker

Build the Docker image:

```bash
socat TCP-LISTEN:2375,reuseaddr,fork UNIX-CONNECT:/var/run/docker.sock &
docker-compose build --no-cache && docker-compose --project-name springboot up -d && docker image prune -fa
```