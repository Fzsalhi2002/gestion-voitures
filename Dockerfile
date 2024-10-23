# Utiliser une image de base Java
FROM openjdk:17-jdk-alpine

# Copier le fichier JAR de l'application Spring Boot dans l'image Docker
COPY target/SpringDataRest-0.0.1-SNAPSHOT.jar app.jar

# Exposer le port 8080
EXPOSE 8080

# Commande pour lancer l'application
ENTRYPOINT ["java", "-jar", "/app.jar"]
