# TP Spring Boot API REST
#24091,24083,24270

## Partie 8 : Questions de réflexion

### 1. Différence entre @RestController et @Controller ?
- `@Controller` : retourne des vues HTML (MVC).
- `@RestController` : retourne des données JSON directement.

### 2. Pourquoi utiliser un DTO ?
- Séparer la couche de présentation de la base de données.
- Contrôler les données envoyées au client.

### 3. Quel est le rôle de @Transactional ?
- Garantit que toutes les opérations s'exécutent dans une seule transaction.
- En cas d'erreur, toutes les modifications sont annulées (rollback).

### 4. Différence entre findById() et getById() ?
- `findById()` : retourne un `Optional<T>`, gère le cas où l'objet n'existe pas.
- `getById()` : retourne directement l'objet, lance une exception si non trouvé.

### 5. Pourquoi utiliser @Valid ?
- Vérifier automatiquement les données reçues.
- Éviter d'enregistrer des données invalides dans la base de données.