# Entorno de ejecución para aplicaciones java basado en OpenJDK 17
FROM azul/zulu-openjdk:17-latest
# Copia el archivo .jar de la aplicación al directorio raíz del contenedor
# y le cambia el nombre a app.jar
COPY build/libs/Spring3DPastor-0.0.1-SNAPSHOT.jar app.jar
# Cuando se inicia el contenedor ejecutará el comando java -jar app.jar
# para iniciar la aplicación
ENTRYPOINT ["java", "-jar", "/app.jar"]
# Indica que el contenedor escuchará el puerto 8080
EXPOSE 8080