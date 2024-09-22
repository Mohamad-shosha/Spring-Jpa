FROM maven:3.9.9-eclipse-temurin-17
LABEL authors="shosha"

# Set the working directory
WORKDIR /app

# Copy the pom.xml and download dependencies (go offline)
COPY pom.xml /app
RUN mvn dependency:go-offline

# Copy the source code into the image
COPY src /app/src

# Build the application (without running tests)
RUN mvn package -DskipTests

# Expose the application port
EXPOSE 8080

# Start the application (assuming a JAR, update if WAR)
CMD ["java", "-jar", "target/spring-jpa-1.0-SNAPSHOT.war"]
