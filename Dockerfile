# Use Maven with JDK 21 to build
FROM maven:3.9.6-eclipse-temurin-21 AS build

WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline

COPY src ./src
RUN mvn clean package -DskipTests

# Use JDK 21 for runtime
FROM eclipse-temurin:21-jdk

WORKDIR /app
COPY --from=build /app/target/*.jar demo.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "demo.jar"]
