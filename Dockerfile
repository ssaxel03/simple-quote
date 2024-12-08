# Use a base image with Java 17 (or the version your app uses)
FROM openjdk:17-jdk-slim AS build

# Set the working directory in the container
WORKDIR /app

# Copy the Maven wrapper files
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

# Copy the source code into the container
COPY src ./src

# Make the mvnw script executable
RUN chmod +x mvnw

# Build the application using Maven Wrapper
RUN ./mvnw clean package -DskipTests

# Use a minimal JDK image for the runtime
FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the JAR file from the build stage
COPY --from=build /app/target/simple-quote-0.0.1-SNAPSHOT.jar simple-quote.jar

# Expose the port the app will run on
EXPOSE 8080

# Command to run the application
ENTRYPOINT ["java", "-jar", "simple-quote.jar"]
