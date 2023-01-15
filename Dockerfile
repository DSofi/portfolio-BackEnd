FROM amazoncorretto:19
MAINTAINER dsofi
COPY target/segunda-0.0.1-SNAPSHOT.jar app.jar
COPY .env /app/.env
ENV $(cat .env | xargs)
ENTRYPOINT ["java","-jar","/app.jar"]