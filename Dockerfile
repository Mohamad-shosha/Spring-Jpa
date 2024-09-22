FROM maven:3.9.9-eclipse-temurin-17
LABEL authors="shosha"

WORKDIR /app

COPY pom.xml /app
RUN mvn dependency:go-offline

COPY src /app/src

RUN mvn package -DskipTests

EXPOSE 8080

CMD ["java", "-jar", "target/spring-jpa-1.0-SNAPSHOT.war"]
