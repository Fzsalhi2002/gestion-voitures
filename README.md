
# Application de gestion de voitures

## Description

Ce dépôt contient une application web full-stack pour la gestion de compagnies, construite avec un backend en Spring Boot, un frontend en ReactJS, et une base de données PostgreSQL. Le projet inclut également Prometheus et Grafana pour le monitoring.

## Prérequis

Avant de lancer l'application, assurez-vous d'avoir les éléments suivants installés sur votre système :

-  [Docker](https://docs.docker.com/get-docker/) and [Docker Compose](https://docs.docker.com/compose/install/)

## Démarrage

Pour démarrer avec l'application, suivez les instructions ci-dessous.

### Étape 1 : Cloner le dépôt

```bash
git clone https://github.com/Fzsalhi2002/gestion-voitures.git
cd gestion-voitures
```

### Étape 2 : Construire les images Docker

Si les images Docker ne sont pas encore disponibles, vous pouvez les construire à partir des Dockerfiles de ce projet.

#### 2.1 Construire l'image du frontend

```bash
docker build -t my-frontend-app ./src/main/webapp/reactjs
```

#### 2.2 Construire l'image du backend

```bash
docker build -t my-backend-app .
```

#### 2.3 Vérifier les images créées

Vous pouvez vérifier que les images ont été créées avec succès en listant les images disponibles :

```bash
docker images
```

### Étape 3 : Lancer l'application avec Docker Compose

Une fois les images prêtes (ou téléchargées), suivez ces étapes pour lancer l'application avec Docker Compose.

1. Assurez-vous d'être dans le répertoire contenant le fichier docker-compose.yml.
2. Exécutez la commande suivante pour démarrer les conteneurs :

```bash
docker-compose up -d
```

### Étape 4 : Accéder à l'application

- **Frontend**: Ouvrez un navigateur et allez à http://localhost:3001
- **Backend**: Vous pouvez accéder au backend via http://localhost:8080
- 
### Étape 5 : Monitoring avec Prometheus et Grafana

#### 5.1 Accéder à Prometheus
Prometheus sera disponible à http://localhost:9090.

5.2 Accéder à Grafana

Grafana sera disponible à http://localhost:3000. Les identifiants par défaut pour Grafana sont :

- **Nom d'utilisateur**: admin
- **Mot de passe**: admin
- 
Dans Grafana, configurez un tableau de bord pour surveiller l'application en ajoutant Prometheus comme source de données.

### Étape 6 : Arrêter les conteneurs

Pour arrêter et supprimer tous les conteneurs associés à l'application, utilisez la commande suivante :

```bash
docker-compose down
```
