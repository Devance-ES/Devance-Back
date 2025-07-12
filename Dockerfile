### Etapa 1: Build com Maven (usando Java 24)
FROM openjdk:24-jdk-slim AS build
WORKDIR /app
# Instala Maven
RUN apt-get update && apt-get install -y maven && rm -rf /var/lib/apt/lists/*
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

### Etapa 2: Imagem final para rodar o app (Java 24)
FROM openjdk:24-jdk-slim
WORKDIR /app
COPY --from=build /app/target/fonar-0.0.1-SNAPSHOT.jar app.jar
COPY server-test.sh /app/server-test.sh
RUN chmod +x /app/server-test.sh
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]