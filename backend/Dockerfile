# Imagen base con JDK 21
FROM eclipse-temurin:21-jdk-jammy

# Directorio dentro del contenedor
WORKDIR /app

# Copia el JAR compilado al contenedor
COPY target/Feature_4-0.0.1-SNAPSHOT.jar app.jar

# Expone el puerto (Render usa variable PORT)
EXPOSE 8080

# Ejecuta el JAR, tomando el puerto desde la variable de entorno PORT
ENTRYPOINT ["sh", "-c", "java -jar app.jar --server.port=${PORT:-8080}"]
