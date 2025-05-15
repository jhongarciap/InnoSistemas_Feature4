# Imagen base con Java 21
FROM eclipse-temurin:21-jre

# Crear directorio de trabajo
WORKDIR /app

# Copiar el archivo JAR generado
COPY target/Feature_4-0.0.1-SNAPSHOT.jar app.jar

# Exponer el puerto (ajústalo si tu app usa otro)
EXPOSE 8080

# Comando para ejecutar el JAR
ENTRYPOINT ["java", "-jar", "app.jar"]
