## Task notes

<br/>[Requirements](requirements.pdf)

### Tech Stack:
- Java 17
- Spring Boot
- Lombok
- OpenApi
- Docker
- JUnit

### Modules:
- UAA
  - port: 8081
- apikey-auth-provider
  - port: 8082
- ResourceServer
  - port: 8083

<br> Modules have OpenApi documentation by path: /swagger-ui/index.html

## Build and install
For build use gradle:
```
gradle build
```
Or use gradle wrapper:
```
gradlew build
```
Out files: {moduleDir}/build/libs
<br>
<br>
Then you can run all modules in docker containers:
```
docker-compose up -d --build
```

