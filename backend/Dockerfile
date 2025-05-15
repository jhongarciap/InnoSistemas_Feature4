# Imagen base con JDK 21 y Maven
FROM maven:3.9.4-eclipse-temurin-21 AS build

# Crea un directorio de trabajo
WORKDIR /app

# Copia pom.xml y descarga dependencias
COPY pom.xml .
RUN mvn dependency:go-offline

# Copia el resto del código fuente
COPY . .

# Construye el jar
RUN mvn clean package -DskipTests

# Imagen final minimalista con solo JDK
FROM eclipse-temurin:21-jdk-jammy

WORKDIR /app

# Copia el jar desde la imagen anterior
COPY --from=build /app/target/Feature_4-0.0.1-SNAPSHOT.jar app.jar

# Expone el puerto
EXPOSE 8080

# Comando para ejecutar la app
CMD ["sh", "-c", "java -jar app.jar --server.port=${PORT:-8080}"]
