# Barapp - Backend (Spring Boot)

## Prérequis

- Java 17 ou supérieur
- Maven 3.6+ (ou utiliser le wrapper fourni : `mvnw`/`mvnw.cmd`)
- PostgreSQL

## Installation

1. **Cloner le projet**
   ```sh
   git clone <https://github.com/cloeDec/BarAppBack.git>
   cd barapp
   ```
2. **Configurer la base de données**
   - Modifier le fichier `src/main/resources/application.properties` selon vos paramètres (URL, utilisateur, mot de passe, etc.)

## Démarrage du serveur

### Sous Windows

```sh
mvnw.cmd spring-boot:run
```

Le backend sera accessible par défaut sur :

```
http://localhost:8080
```

## Structure du projet

- `src/main/java` : code source principal (contrôleurs, services, modèles...)
- `src/test/java` : tests unitaires (JUnit)
- `src/main/resources` : configuration Spring Boot

## Endpoints principaux

- `/cocktails` : gestion des cocktails (CRUD)
- Voir les autres contrôleurs pour plus de fonctionnalités

---
