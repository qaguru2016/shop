# Use official JDK 21 image
FROM eclipse-temurin:21-jdk-alpine

# Set the working directory
WORKDIR /app

# Copy the fat jar
COPY target/shop-1.0.jar app.jar

# Expose the port your Spring Boot app runs on
EXPOSE 8080

# Run the jar
ENTRYPOINT ["java", "-jar", "/app/app.jar"]

# Optionally hard-code the active profile (not needed if using Render env vars)
ENV SPRING_PROFILES_ACTIVE=prod