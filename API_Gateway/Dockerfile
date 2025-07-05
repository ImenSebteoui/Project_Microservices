# Étape 1 : Build avec Maven
FROM maven:3.9.0-eclipse-temurin-17 AS builder
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Étape 2 : Image finale avec JDK
FROM eclipse-temurin:17-jdk-jammy
WORKDIR /app
COPY --from=builder /app/target/api-gateway-0.0.1-SNAPSHOT.jar api-gateway.jar
EXPOSE 8088
ENTRYPOINT ["java", "-jar", "api-gateway.jar"]