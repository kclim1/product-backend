# Use official JDK runtime as base
FROM eclipse-temurin:17-jdk AS build

WORKDIR /app

# Copy Gradle build files and source code
COPY build.gradle settings.gradle gradlew ./
COPY gradle ./gradle
COPY src ./src

# Ensure gradlew is executable
RUN chmod +x gradlew

# Build the JAR
RUN ./gradlew clean bootJar --no-daemon

# ---- Run stage ----
FROM eclipse-temurin:17-jdk

WORKDIR /app

# Copy the jar from the build stage
COPY --from=build /app/build/libs/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
