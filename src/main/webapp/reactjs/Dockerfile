# Utiliser une image de base Node.js pour construire l'application
FROM node:18-alpine AS build

# Créer un répertoire de travail pour l'application
WORKDIR /app

# Copier les fichiers package.json et package-lock.json
COPY package*.json ./

# Installer les dépendances
RUN npm install

# Copier le reste des fichiers de l'application
COPY . .

# Construire l'application front-end
RUN npm run build

# Utiliser une image de base pour servir le front-end
FROM nginx:alpine

# Copier les fichiers construits vers le répertoire par défaut de Nginx
COPY --from=build /app/build /usr/share/nginx/html

# Exposer le port 3001
EXPOSE 80

# Commande par défaut pour lancer Nginx
CMD ["nginx", "-g", "daemon off;"]
