# Stage 1: Use Maven-based image for building the application
FROM maven:3.8.7-eclipse-temurin-17-alpine AS build

# Set working directory inside the container
WORKDIR /app

# Copy Maven configuration to leverage caching
COPY pom.xml .

# Pre-download dependencies to leverage Docker cache
RUN mvn dependency:go-offline -B

# Copy the source code into the container
COPY src ./src

# Build the application
RUN mvn clean package -Dmaven.test.skip=true

# Stage 2: Use a JRE-based image to run the application
FROM eclipse-temurin:17-jre-alpine

# Set working directory inside the container
WORKDIR /app

# Copy the built JAR file from the previous build stage
COPY --from=build /app/target/*.jar app.jar

# Expose the application port
EXPOSE 8080

# Run the application
CMD ["java", "-jar", "app.jar"]