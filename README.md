## Task notes

<br/>[Requirements](requirements.pdf)

### Modules:

- UAA
    - port: 8081
- apikey-auth-provider
    - port: 8082
- ResourceServer
    - port: 8083

<br> Modules have OpenApi documentation by path: &lt;hostname/ip>:&lt;port>/swagger-ui/index.html
<br> For example: http://localhost:8083/swagger-ui/index.html 

## Build and install

For build use gradle:

```
gradle build
```

Or use gradle wrapper:

```
gradlew build
```

Out files: &lt;moduleDir>/build/libs
<br>
<br>
Then you can run all modules in docker containers:

```
docker-compose up -d --build
```
