# Use uma imagem base oficial do OpenJDK com uma versão compatível com sua aplicação (Java 21, por exemplo).
# Como seu log menciona Java 24, é bom usar uma imagem que suporte isso, como 'eclipse-temurin:21-jdk-alpine'
# ou 'openjdk:21-jdk-slim'. Se Java 24 ainda não tem imagens Alpine estáveis, considere uma mais comum.
# Para este exemplo, vamos com Java 21, mas ajuste conforme sua necessidade.
FROM openjdk:24-jdk-slim

# Define o diretório de trabalho dentro do container
WORKDIR /app

# Copia o JAR compilado da sua aplicação para o diretório de trabalho.
# Presume que você já construiu seu projeto Maven/Gradle e o JAR está em 'target/seu-app.jar'.
# Adapte 'seu-app.jar' para o nome real do seu arquivo JAR.
# Você pode fazer um 'mvn clean install' antes de construir a imagem Docker.
COPY target/fonar-0.0.1-SNAPSHOT.jar app.jar

# Expõe a porta que sua aplicação Spring Boot usa (padrão é 8080)
EXPOSE 8080

# Comando para rodar a aplicação quando o container iniciar
ENTRYPOINT ["java", "-jar", "app.jar"]

# Se você estiver usando o Spring Boot Devtools e quiser que ele funcione no Docker
# adicione o seguinte ANTES do ENTRYPOINT, e remova a linha SPRING_DEVTOOLS_RESTART_ENABLED
# no docker-compose.yml se você quiser que ele tente reiniciar:
# ENTRYPOINT ["java", "-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5005", "-jar", "app.jar"]