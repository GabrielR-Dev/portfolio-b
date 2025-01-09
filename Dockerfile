# Usa una imagen base de OpenJDK
FROM amazoncorretto:17-alpine-jdk

# Copia el archivo JAR de tu aplicación al contenedor
COPY target/demo-0.0.1-SNAPSHOT.jar app.jar

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]
