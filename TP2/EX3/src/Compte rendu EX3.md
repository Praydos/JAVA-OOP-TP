

Ce projet a pour objectif de concevoir et de réaliser une application Java permettant de gérer les commandes des clients d'une entreprise de vente d'ordinateurs. L'application est structurée autour de plusieurs classes représentant les différentes entités du système, notamment les ordinateurs, les catégories, les commandes, les lignes de commande et les clients.

La première classe, `Ordinateur`, est créée pour représenter un ordinateur avec des attributs tels que `nom`, `marque`, `prix`, `description` et `nombre en stock`. Cette classe inclut également une méthode `calculerPrix(int nbrDonne)` qui permet de calculer le prix total d'un certain nombre d'ordinateurs.

Ensuite, la classe `Categorie` est introduite pour gérer les catégories d'ordinateurs. Elle possède des attributs pour le `nom`, la `description` et une liste d'ordinateurs. Cette classe offre des méthodes telles que `addOrdinateurs(Ordinateur ordinateur)` pour ajouter un nouvel ordinateur à la liste, en vérifiant au préalable s'il existe déjà, et `removeOrdinateurs(Ordinateur ordinateur)` pour supprimer un ordinateur de la liste. La méthode `findOrdinateur(double prix)` permet de rechercher un ordinateur par son prix dans la liste.

La classe `Commande` représente une commande passée par un client. Elle contient des attributs pour la `référence`, le `client`, la `date de commande` et l'`état` de la commande. 

La classe `LigneCommande` est conçue pour représenter une ligne de commande, associant une `quantité`, une `commande` et un `ordinateur` spécifique.

Pour gérer les clients, la classe `Client` est créée avec des attributs pour le `nom`, le `prénom`, l'`adresse`, le `téléphone`, l'`email` et une liste de commandes effectuées. La méthode `addCommandes(Commande commande)` permet d'ajouter une nouvelle commande à la liste, tout en vérifiant qu'elle n'existe pas déjà, et `removeCommandes(Commande commande)` permet de supprimer une commande.

Chaque classe est accompagnée de constructeurs avec et sans paramètres, de getters et setters pour l'accès aux attributs, et d'une méthode `toString()` pour fournir une représentation textuelle de chaque objet.

Dans la classe principale `Main`, une méthode `main()` est mise en place pour tester les différentes classes. Dans cette méthode, nous déclarons et instancions trois ordinateurs, puis une catégorie qui contient ces ordinateurs. Un client est également instancié, suivi d'une commande associée à ce client. Trois lignes de commande sont ensuite créées pour représenter les ordinateurs commandés. 

Enfin, les informations de la commande peuvent être affichées en appelant les méthodes `toString()` des objets concernés, permettant ainsi de visualiser toutes les informations relatives à la commande, y compris les détails des ordinateurs commandés et du client.

Ce projet illustre l'application des concepts de la programmation orientée objet, notamment l'encapsulation, l'héritage et l'association, pour modéliser une application commerciale complète.
