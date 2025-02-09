# Etapa de construcción
FROM maven:3.9.6-eclipse-temurin-21-alpine AS build
WORKDIR /workspace/app

# Copiar archivos del proyecto
COPY pom.xml .
COPY src src

# Construir la aplicación
RUN mvn clean package -DskipTests

# Etapa de ejecución
FROM eclipse-temurin:21-jre-alpine
COPY --from=build /workspace/app/target/*.jar app.jar
ENTRYPOINT ["java", "-Dspring.profiles.active=prod", "-jar", "/app.jar"] 