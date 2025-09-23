# --- Stage 1: The Build Stage ---
FROM eclipse-temurin:21-jdk-jammy as builder

WORKDIR /app

# First, copy just the files needed for dependency resolution
COPY gradlew ./
COPY gradle ./gradle
COPY build.gradle settings.gradle ./

# Download dependencies first. This step is cached and only re-runs
# if the build.gradle file changes.
RUN ./gradlew dependencies --no-daemon

# Now, copy the actual source code
COPY src ./src

# Finally, run the build. This will be much faster as dependencies are cached.
RUN ./gradlew build --no-daemon


# --- Stage 2: The Final Image Stage ---
FROM eclipse-temurin:21-jre-jammy

WORKDIR /app

# Copy ONLY the built JAR file from the "builder" stage into our final image.
# NOTE: The path might need a slight adjustment depending on your build.gradle's `version`.
COPY --from=builder /app/build/libs/FeedbackClassifier-0.0.1-SNAPSHOT.jar app.jar

# Expose the port that our Spring Boot application will run on.
EXPOSE 8080

# The command to run when the container starts.
CMD ["java", "-jar", "app.jar"]