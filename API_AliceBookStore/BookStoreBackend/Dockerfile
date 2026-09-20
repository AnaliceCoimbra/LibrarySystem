# Estágio 1: Build da aplicação com Gradle e Java 21
FROM eclipse-temurin:21-jdk AS build
WORKDIR /app

# Copia os arquivos do projeto
COPY . .

# Dá permissão de execução ao wrapper do Gradle e compila o JAR da aplicação
RUN chmod +x gradlew
RUN ./gradlew bootJar -x test

# Estágio 2: Imagem leve para rodar a aplicação em produção
FROM eclipse-temurin:21-jre
WORKDIR /app

# Copia o JAR gerado no primeiro estágio
COPY --from=build /app/build/libs/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]