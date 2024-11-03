
### Objectif du projet
L'objectif de ce projet est de manipuler une collection d'objets de type `Produit` à l'aide d'une interface définissant les opérations possibles sur cette collection. L'application offre un menu permettant à l'utilisateur d'interagir avec la liste de produits de manière simple et intuitive.

### Structure du code

#### 1. Classe `Produit`
La classe `Produit` représente un produit avec plusieurs attributs :
- `id` : Identifiant unique du produit.
- `nom` : Nom du produit.
- `marque` : Marque du produit.
- `prix` : Prix du produit.
- `description` : Description du produit.
- `nbrStock` : Nombre d'unités disponibles en stock.

Cette classe inclut un constructeur pour initialiser ces attributs, ainsi que des getters et setters pour accéder et modifier les valeurs. La méthode `toString()` est redéfinie pour fournir une représentation lisible d'un produit.

#### 2. Interface `IMetierProduit`
L'interface `IMetierProduit` déclare les méthodes qui doivent être implémentées pour gérer les produits. Les méthodes définies incluent :
- `add(Produit p)` : Ajoute un produit à la liste.
- `getAll()` : Récupère tous les produits.
- `findByNom(String motCle)` : Recherche des produits dont le nom contient un mot clé.
- `findById(long id)` : Récupère un produit par son identifiant.
- `delete(long id)` : Supprime un produit par son identifiant.

#### 3. Classe `MetierProduitImpl`
La classe `MetierProduitImpl` implémente l'interface `IMetierProduit` et contient une liste de produits. Elle fournit les implémentations concrètes pour les méthodes déclarées dans l'interface :
- **add** : Ajoute un produit à la liste.
- **getAll** : Retourne la liste de tous les produits.
- **findByNom** : Parcourt la liste des produits et retourne ceux dont le nom contient le mot clé.
- **findById** : Recherche un produit par son identifiant.
- **delete** : Supprime un produit en utilisant une expression lambda pour filtrer la liste.

#### 4. Classe `Main`
La classe `Main` contient la méthode `main()` qui propose un menu interactif à l'utilisateur. Les options incluent :
1. Afficher la liste des produits.
2. Rechercher des produits par mot clé.
3. Ajouter un nouveau produit.
4. Récupérer un produit par ID.
5. Supprimer un produit par ID.
6. Quitter le programme.

Dans un `while (true)`, un menu est affiché, et l'utilisateur peut entrer son choix. Les actions correspondantes sont exécutées en fonction du choix :
- Affichage de la liste des produits en utilisant `getAll()`.
- Recherche de produits via `findByNom()`.
- Ajout d'un produit en créant une instance de `Produit` et en l'ajoutant à la liste.
- Recherche d'un produit par ID et affichage de ses informations.
- Suppression d'un produit par ID en appelant `delete()`.


### Conclusion
Ce projet est un bon exercice de mise en pratique des concepts de la programmation orientée objet, comme les interfaces, l'encapsulation, et la manipulation de collections en Java. Il fournit une base solide pour une application de gestion de produits, avec une interface utilisateur simple pour interagir avec les données.
