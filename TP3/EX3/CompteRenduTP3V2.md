Voici un compte rendu détaillé des trois exercices, avec des explications pour chaque classe et des extraits de code pour illustrer les concepts abordés.

---

### Exercice 1 : Gestion de la vitesse d'un véhicule

**Classe `TropViteException`**

- **Description :** Cette classe hérite de la classe `Exception` et représente une exception spécifique qui se produit lorsqu'un véhicule dépasse une vitesse acceptable.
- **Constructeur :** Le constructeur prend un entier représentant la vitesse et appelle le constructeur de la classe parente avec un message formaté incluant la vitesse.

**Extrait de code :**

```java
public class TropViteException extends Exception {
    public TropViteException(int vitesse) {
        super("C'est une exception de type TropViteException. Vitesse en cause : " + vitesse);
    }
}
```

---

**Classe `Vehicule`**

- **Description :** Cette classe représente un véhicule simple, sans attributs. Elle contient une méthode qui teste la vitesse fournie.
- **Méthode `testVitesse(int vitesse)` :** Cette méthode prend un entier comme paramètre et lance une `TropViteException` si la vitesse est supérieure à 90 km/h.

**Extrait de code :**

```java
public class Vehicule {
    public void testVitesse(int vitesse) throws TropViteException {
        if (vitesse > 90) {
            throw new TropViteException(vitesse);
        }
    }
}
```

---

**Classe `Main`**

- **Description :** Cette classe contient la méthode `main`, point d'entrée du programme.
- **Fonctionnalité :** Elle crée une instance de `Vehicule` et appelle la méthode `testVitesse()` avec des valeurs différentes pour illustrer les deux cas : une vitesse excessive et une vitesse acceptable. Un bloc `try-catch` est utilisé pour gérer l'exception.

**Extrait de code :**

```java
public class Main {
    public static void main(String[] args) {
        Vehicule vehicule = new Vehicule();
        try {
            vehicule.testVitesse(900); // Déclenche une exception
        } catch (TropViteException e) {
            e.printStackTrace(); // Affiche la pile d'appels de l'exception
        }
    }
}
```

---

### Exercice 2 : Validation de la racine carrée

**Classe `RacineCarreeException`**

- **Description :** Cette classe hérite également de `Exception` et est utilisée pour signaler les erreurs lors du calcul de racines carrées de nombres négatifs.
- **Constructeur :** Le constructeur prend un entier et passe un message explicatif à la classe parente.

**Extrait de code :**

```java
public class RacineCarreeException extends Exception {
    public RacineCarreeException(int entier) {
        super("C'est une exception de type RacineCarreeException. Nombre négatif : " + entier);
    }
}
```

---

**Classe `Calculateur`**

- **Description :** Cette classe ne contient pas d'attributs et propose une méthode pour vérifier si une entrée est valide pour le calcul d'une racine carrée.
- **Méthode `testRacineCarree(int entier)` :** Si l'entier est négatif, elle lance une `RacineCarreeException`.

**Extrait de code :**

```java
public class Calculateur {
    public void testRacineCarree(int entier) throws RacineCarreeException {
        if (entier < 0) {
            throw new RacineCarreeException(entier);
        }
    }
}
```

---

**Classe `Main`**

- **Description :** Cette classe contient la méthode `main` pour exécuter le programme.
- **Fonctionnalité :** Elle crée une instance de `Calculateur` et teste la méthode `testRacineCarree()` avec des valeurs, gérant les exceptions avec un bloc `try-catch`.

**Extrait de code :**

```java
public class Main {
    public static void main(String[] args) {
        Calculateur calc = new Calculateur();
        try {
            calc.testRacineCarree(-5); // Déclenche une exception
        } catch (RacineCarreeException e) {
            System.out.println(e.getMessage()); // Affiche le message d'erreur
        }
    }
}
```

---

### Exercice 3 : Validation des notes

**Classe `NoteInvalideException`**

- **Description :** Cette classe hérite de `Exception` et est utilisée pour signaler les erreurs lors de la validation des notes qui ne respectent pas les critères spécifiés.
- **Constructeur :** Il prend un entier représentant une note invalide et envoie un message explicatif à la classe parente.

**Extrait de code :**

```java
public class NoteInvalideException extends Exception {
    public NoteInvalideException(int note) {
        super("Exception de type NoteInvalideException. Note invalide : " + note);
    }
}
```

---

**Classe `Evaluateur`**

- **Description :** Cette classe ne contient pas d'attributs et propose une méthode pour vérifier la validité d'une note.
- **Méthode `verifierNote(int note)` :** Si la note est inférieure à 0 ou supérieure à 20, elle lance une `NoteInvalideException`.

**Extrait de code :**

```java
public class Evaluateur {
    public void verifierNote(int note) throws NoteInvalideException {
        if (note < 0 || note > 20) {
            throw new NoteInvalideException(note);
        }
    }
}
```

---

**Classe `Main`**

- **Description :** Cette classe inclut la méthode `main` pour exécuter le programme.
- **Fonctionnalité :** Elle crée une instance de `Evaluateur` et teste la méthode `verifierNote()` avec des valeurs valides et invalides, gérant les exceptions avec un bloc `try-catch`.

**Extrait de code :**

```java
public class Main {
    public static void main(String[] args) {
        Evaluateur eval = new Evaluateur();
        try {
            eval.verifierNote(15); // Note valide
            eval.verifierNote(25); // Déclenche une exception
        } catch (NoteInvalideException e) {
            System.out.println(e.getMessage()); // Affiche le message d'erreur
        }
    }
}
```

---

### Conclusion générale

Ces trois exercices illustrent comment créer et gérer des exceptions personnalisées en Java, en répondant à des scénarios spécifiques comme la vitesse d'un véhicule, le calcul de racines carrées, et la validation des notes. Chaque classe est soigneusement conçue pour encapsuler les comportements associés aux exceptions, permettant une gestion des erreurs claire et efficace. Cela renforce la robustesse des applications et améliore l'expérience utilisateur en fournissant des messages d'erreur explicites en cas de saisie incorrecte.
