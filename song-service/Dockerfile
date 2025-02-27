# Use Maven-based image for the build stage
FROM maven:3.8.7-eclipse-temurin-17-alpine AS build

# Set working directory
WORKDIR /app

# Copy Maven configuration to leverage caching
COPY pom.xml . 

# Pre-download dependencies to leverage Docker cache
RUN mvn dependency:go-offline -B 

# Copy the source code
COPY src ./src

# Build the application
RUN mvn clean package -Dmaven.test.skip=true

# Use a lightweight JRE-based image for runtime
FROM eclipse-temurin:17-jre-alpine

# Set working directory
WORKDIR /app

# Copy the built JAR file from the build stage
COPY --from=build /app/target/*.jar app.jar

# Expose the application port
EXPOSE 8082-8083

# Run the application
CMD ["java", "-jar", "app.jar"]
