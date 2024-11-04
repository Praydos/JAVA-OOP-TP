les details de chaque exercie est en fichier readme avec chaque dossier des er=xercice

Les quatre exercices présentés consistent à concevoir et à développer des applications Java en utilisant des concepts de programmation orientée objet (POO). Voici un résumé des principales caractéristiques et objectifs de chaque exercice :

1. **Gestion des Salaires des Employés** : 
   Dans cet exercice, une application Java est créée pour gérer les salaires des employés d'une entreprise de développement informatique. Une classe abstraite `Employe` est définie avec des attributs tels que nom, prénom, email, téléphone et salaire, ainsi qu'une méthode abstraite `calculerSalaire()`. Deux classes dérivées, `Ingenieur` et `Manager`, implémentent cette méthode avec des logiques spécifiques pour calculer les salaires, respectivement avec une augmentation de 15 % pour les ingénieurs et 20 % pour les managers. Une classe `Main` est également fournie pour instancier des objets de ces classes et afficher leurs informations.

2. **Gestion des Commandes de Clients** : 
   Ce deuxième exercice vise à créer une application qui gère les ordinateurs, les catégories et les commandes d'une entreprise de vente d'ordinateurs. La classe `Ordinateur` représente les ordinateurs avec des attributs tels que nom, marque, prix et nombre en stock. La classe `Categorie` gère une liste d'ordinateurs, avec des méthodes pour ajouter, supprimer et rechercher des ordinateurs par prix. La classe `Commande` contient des informations sur les commandes, et la classe `LigneCommande` gère les détails des articles commandés. Une classe `Client` représente les clients avec une liste de commandes. Une méthode `main()` est incluse pour tester l'application.

3. **Gestion des Produits avec Interface** : 
   Le troisième exercice se concentre sur la manipulation d'une collection d'objets de type `Produit` à l'aide d'une interface et de listes. La classe `Produit` contient des attributs tels que id, nom, marque, prix, description et nombre en stock. L'interface `IMetierProduit` déclare des méthodes pour ajouter, récupérer, rechercher et supprimer des produits. La classe `MetierProduitImpl` implémente cette interface, gérant une liste de produits et fournissant les implémentations des méthodes. Une classe `Main` propose un menu interactif permettant à l'utilisateur d'effectuer diverses opérations sur les produits.

4. **Application Complète** : 
   Le quatrième exercice résume l'application complète, combinant les différents éléments de gestion des employés, des commandes, et des produits. Les concepts de classes, d'héritage, d'interfaces, et de listes sont intégrés pour créer une application robuste et fonctionnelle.

Dans l'ensemble, ces exercices mettent en évidence les principes fondamentaux de la POO en Java, comme l'encapsulation, l'héritage, l'abstraction, et l'utilisation d'interfaces pour créer des applications modulaires et faciles à maintenir. Ils démontrent également l'importance de la structuration des données et de la logique pour gérer des systèmes d'information complexes.
