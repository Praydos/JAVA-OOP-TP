### Compte rendu de l'Exercice 1 : Les listes

L'exercice consiste à créer une application pour manipuler une liste d'objets de type *Produit* en Java. Le programme utilise une classe `Produit` pour représenter un produit, et une classe `GestionProduitsApp` pour gérer les produits dans une `ArrayList`.

#### 1. Classe `Produit` :
La classe `Produit` contient trois attributs :
- `id` (de type `long`), 
- `nom` (de type `String`), 
- `prix` (de type `double`).

Les méthodes de cette classe incluent des getters et setters pour accéder et modifier ces attributs. Le constructeur permet d'initialiser ces attributs lors de la création d'un objet `Produit`.

```java
public class Produit {
    long id;
    String nom;
    double prix;

    public Produit(long id, String nom, double prix) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
    }

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public double getPrix() { return prix; }
    public void setPrix(double prix) { this.prix = prix; }
}
```

#### 2. Classe `GestionProduitsApp` :
Cette classe contient la méthode `main` où la gestion des produits est effectuée. Voici les principales opérations réalisées :

- **Création d'une liste de produits** : Une `ArrayList<Produit>` est utilisée pour stocker les produits. Trois produits sont ajoutés à la liste avec des informations de base (ID, nom, prix).
  
- **Affichage des produits** : Les produits de la liste sont affichés à l'aide d'une boucle `for-each`, où chaque produit est imprimé avec son ID, nom et prix.

```java
for (Produit p : produits) {
    System.out.println(p.getId());
    System.out.println(p.getNom());
    System.out.println(p.getPrix());
    System.out.println("");
}
```

- **Suppression d'un produit par indice** : Un indice est choisi (ici `0` pour le premier produit), et le produit correspondant est supprimé de la liste à l'aide de la méthode `remove(index)`.

- **Modification d'un produit par indice** : Le produit à l'indice spécifié est modifié en modifiant son nom, son ID et son prix.

```java
produits.get(indice).setNom("mouse");
produits.get(indice).setId(12778);
produits.get(indice).setPrix(100.00);
```

- **Recherche d'un produit par nom** : Un utilisateur entre un nom de produit, et la liste est parcourue pour afficher les détails du produit si le nom correspond à celui entré.

```java
Scanner sc = new Scanner(System.in);
System.out.println("nom :");
String nom = sc.nextLine();

for (Produit p : produits) {
    if (p.getNom().equals(nom)) {
        System.out.println(p.getId());
        System.out.println(p.getNom());
        System.out.println(p.getPrix());
    }
}
```

#### Points à noter :
- Le programme demande un nom de produit à l'utilisateur et recherche tous les produits correspondants.
- Il pourrait être utile de gérer les cas où un produit n'est pas trouvé (ajouter un message pour informer l'utilisateur qu'aucun produit ne correspond au nom).
- Pour une meilleure gestion des erreurs, il serait judicieux d'ajouter des validations pour s'assurer que les indices utilisés pour supprimer ou modifier des produits sont valides.

#### Conclusion :
Ce programme permet de réaliser plusieurs opérations de base sur une liste d'objets en Java. Il illustre bien l'utilisation des `ArrayList`, des méthodes de recherche, de suppression et de modification, ainsi que des interactions avec l'utilisateur via `Scanner`.

---
### Compte rendu de l'Exercice 2 : Les Maps

L'exercice consiste à manipuler une collection de données à l'aide de la classe `HashMap` en Java. Ce type de collection permet de stocker des paires clé-valeur, où la clé est un nom d'étudiant (de type `String`) et la valeur est sa note (de type `double`). Voici le détail de l'implémentation de chaque étape.

#### 1. Création du `HashMap`
Un `HashMap<String, Double>` est créé pour stocker les notes des étudiants. La clé est le nom de l'étudiant, et la valeur est la note (un nombre à virgule flottante).

```java
HashMap<String, Double> map = new HashMap<>();
```

#### 2. Insertion des notes des étudiants
Les notes de trois étudiants sont insérées dans la map avec la méthode `put`, en associant chaque nom d'étudiant à sa note.

```java
map.put("dadas", 20.0);
map.put("chafik", 15.0);
map.put("boba", 18.0);
```

#### 3. Augmenter la note d’un étudiant
La note de l'étudiant nommé "boba" est augmentée de 1.0 si elle est inférieure à 20. Cela est effectué en vérifiant d'abord si la clé "boba" existe dans la map, puis en modifiant sa valeur en utilisant la méthode `put` pour insérer la nouvelle note.

```java
if (map.containsKey("boba")) {
    double note = map.get("boba");
    if (note < 20)
        map.put("boba", note + 1.0);
}
```

#### 4. Suppression de la note d’un étudiant
Bien que l'exercice demande de supprimer un étudiant, cette opération n'est pas explicitement incluse dans le code que vous avez fourni. Il serait possible de la réaliser avec la méthode `remove` de la manière suivante :
```java
map.remove("boba");  // Cela supprimerait l'entrée pour "boba".
```

#### 5. Affichage de la taille du `Map`
La méthode `size()` est utilisée pour afficher la taille actuelle du `HashMap`, c'est-à-dire le nombre d'étudiants présents dans la map.

```java
System.out.println("La taille du map est : " + map.size());
```

#### 6. Affichage de la note moyenne, maximum et minimum
Pour calculer la moyenne des notes, ainsi que la note maximale et minimale, une boucle `for` parcourt toutes les entrées du `HashMap`. Les valeurs sont ajoutées pour obtenir la moyenne, et la fonction `Math.max()` et `Math.min()` sont utilisées pour calculer respectivement la note maximale et minimale.

```java
double noteMoy = 0;
double noteMax = 0;
double noteMin = 0;
for (Map.Entry<String, Double> entry : map.entrySet()) {
    noteMoy += entry.getValue();
    noteMax = Math.max(noteMax, entry.getValue());
    noteMin = Math.min(noteMin, entry.getValue());
}
noteMoy = noteMoy / map.size();
```

#### 7. Vérification s'il existe une note égale à 20
La méthode `containsValue()` est utilisée pour vérifier si une note de 20 existe dans le `HashMap`. Un message est affiché en conséquence.

```java
if (map.containsValue(20.0)) {
    System.out.println("La note 20 existe");
} else {
    System.out.println("La note 20 n'existe pas");
}
```

#### 8. Affichage après chaque opération
À chaque étape importante, les données sont affichées à l'aide de la méthode `forEach` et d'une expression lambda, qui permet de parcourir le `HashMap` et d'afficher chaque étudiant avec sa note.

```java
map.forEach((key, value) -> {
    System.out.println("Nom : " + key + ", Note : " + value);
});
```

#### Conclusion :
Ce programme met en pratique la gestion des données dans une structure de type `HashMap` en Java. Il permet d'effectuer plusieurs opérations courantes, telles que l'insertion, la mise à jour, et la suppression des éléments, ainsi que des calculs simples comme la moyenne, la note maximale et minimale. L'utilisation des expressions lambda avec `forEach` permet de parcourir facilement le `Map` et d'afficher les résultats.

---
### Compte rendu de l'Exercice 3 : Les Sets

L'exercice consiste à manipuler des ensembles (`Set`) en Java, en utilisant la classe `HashSet`. Cette classe permet de stocker des éléments uniques sans ordre spécifique. Voici l'implémentation détaillée de chaque étape demandée.

#### 1. Création de deux `HashSet` :
Deux ensembles `HashSet<String>` sont créés pour représenter les étudiants des groupes A et B. Chaque ensemble contiendra les noms des étudiants des groupes respectifs.

```java
HashSet<String> groupA = new HashSet<>();
HashSet<String> groupB = new HashSet<>();
```

#### 2. Ajout de noms d'étudiants dans chaque `HashSet` :
Les noms des étudiants sont ajoutés à chaque ensemble à l'aide de la méthode `add()`. Notez que `HashSet` ne permet pas d'ajouter des doublons, donc si un étudiant est ajouté deux fois, il ne sera stocké qu'une seule fois.

```java
groupA.add("anas");
groupA.add("dadas");
groupB.add("boba");
groupB.add("dadas");
```

#### 3. Affichage de l'intersection des deux `HashSet` :
L'intersection de deux ensembles contient les éléments qui sont présents dans les deux ensembles. Cette opération est réalisée avec la méthode `retainAll()`, qui modifie l'ensemble sur lequel elle est appelée pour ne garder que les éléments qui sont également dans l'autre ensemble.

```java
HashSet<String> intersection = new HashSet<>(groupA);
intersection.retainAll(groupB);
System.out.println("Intersection : " + intersection);
```

Dans ce cas, l'intersection des deux groupes est l'ensemble des étudiants qui apparaissent à la fois dans le groupe A et dans le groupe B. Ici, il s'agit de "dadas".

#### 4. Affichage de l'union des deux `HashSet` :
L'union de deux ensembles contient tous les éléments des deux ensembles sans doublons. Cette opération est réalisée avec la méthode `addAll()`, qui ajoute tous les éléments de l'autre ensemble à l'ensemble sur lequel elle est appelée.

```java
HashSet<String> union = new HashSet<>(groupA);
union.addAll(groupB);
System.out.println("Union : " + union);
```

Dans cet exemple, l'union des deux groupes contient "anas", "dadas", "boba", c'est-à-dire tous les étudiants des deux groupes.

#### Résumé du comportement :
- **Intersection** : Affiche les étudiants présents dans les deux groupes. Dans ce cas, seul "dadas" est commun aux deux groupes.
- **Union** : Affiche tous les étudiants des deux groupes sans doublons. Ici, l'union contient "anas", "dadas", et "boba".

#### Conclusion :
Ce programme montre comment utiliser des ensembles (`HashSet`) en Java pour effectuer des opérations de base sur les collections, telles que l'intersection et l'union. Ces opérations sont simples et efficaces grâce aux méthodes `retainAll()` pour l'intersection et `addAll()` pour l'union. L'utilisation de `HashSet` garantit que chaque élément est unique dans chaque groupe.
