# Stage 1: Build Stage
FROM maven:3.8.3-openjdk-17 AS builder

# Set working directory inside container
WORKDIR /ticket

# Copy project files
COPY pom.xml .
COPY src ./src

# Build the Maven project (skip tests)
ARG PROFILE=dev
RUN mvn clean package -DskipTests -P$PROFILE

# Stage 2: Run Stage
FROM eclipse-temurin:17-jdk-alpine

# Set working directory
WORKDIR /app

# Copy the built JAR from build stage
ARG PROFILE=dev
COPY --from=builder /ticket/target/ticket-${PROFILE}.jar app.jar

# Optional: memory/env variables
ENV MIN_MEMORY=512
ENV MAX_MEMORY=1024
ENV PROFILE=$PROFILE
ENV MIGRATION=true

# Expose Spring Boot port
EXPOSE 8080

# Run the Spring Boot application
ENTRYPOINT ["sh", "-c", "java -Xms${MIN_MEMORY}m -Xmx${MAX_MEMORY}m -jar -Dspring.profiles.active=${PROFILE} -Dmigration.enabled=${MIGRATION} -Dfile.encoding=UTF8 app.jar"]
