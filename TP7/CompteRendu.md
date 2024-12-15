### **Compte rendu sur les exercices de programmation multi-threads en Java**

---

#### **Exercice 1 : Création d'une application multi-threading avec la classe Talkative**

##### **Objectifs :**
1. Créer une classe `Talkative` qui contient un attribut entier.
2. Modifier cette classe pour qu’elle implémente l’interface `Runnable`.
3. Redéfinir la méthode `run` pour afficher 100 fois la valeur de l'attribut.
4. Créer 10 instances de `Thread`, chacune prenant en paramètre une instance de `Talkative` avec un entier unique.
5. Lancer chaque thread en appelant la méthode `start`.

##### **Analyse du code :**
La classe `Talkative` implémente l'interface `Runnable` et possède un constructeur qui prend un entier en paramètre, qui est ensuite stocké dans un attribut `value`. La méthode `run` est redéfinie pour afficher 100 fois la valeur de cet attribut. Ensuite, dans la classe `Main`, 10 threads sont créés, chacun prenant une instance de `Talkative` avec un entier unique allant de 0 à 9.

**Code :**

```java
public class Talkative implements Runnable {
    private int value;

    // Constructeur
    public Talkative(int value) {
        this.value = value;
    }

    // Redéfinition de la méthode run
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("Value: " + value);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(new Talkative(i));
        }
        for (Thread thread : threads) {
            thread.start();
        }
    }
}
```

##### **Observations :**
Lors de l'exécution, les 10 threads sont lancés simultanément. Chacun des threads affiche 100 fois la valeur qui lui a été assignée, soit les valeurs de 0 à 9. Ce comportement montre comment plusieurs threads peuvent s'exécuter en parallèle, ce qui est un comportement classique en programmation multi-threads.

##### **Problème observé :**
L’ordre des affichages est non déterminé. En effet, les threads s'exécutent de manière concurrente, ce qui peut entraîner un mélange des sorties des différents threads. Chaque thread est exécuté indépendamment, et l'affichage de ses valeurs peut être entrecoupé par celles des autres threads.

---

#### **Exercice 2 : Utilisation d'un pool de threads pour calculer la somme d'un tableau de manière parallèle**

##### **Objectifs :**
1. Créer une classe `Sommeur` qui implémente `Runnable` pour calculer la somme d'une plage d'éléments dans un tableau.
2. Diviser un tableau en plusieurs plages et créer un pool de threads pour calculer la somme de manière parallèle.
3. Attendre la fin des threads et afficher la somme totale.

##### **Analyse du code :**
La classe `Sommeur` prend en paramètre un tableau d’entiers et deux indices `debut` et `fin`, correspondant à une plage d'indices du tableau. La méthode `run` calcule la somme des éléments dans cette plage. Dans la classe `Main`, le tableau est divisé en plusieurs plages, et un thread est créé pour chaque plage. Ensuite, les threads sont lancés, et après leur exécution, la somme totale est calculée en additionnant les résultats des différents threads.

**Code :**

```java
public class Sommeur implements Runnable {
    private List<Integer> table;
    private int debut;
    private int fin;
    private int somme;

    // Constructeur
    public Sommeur(int debut, int fin, List<Integer> table) {
        this.debut = debut;
        this.fin = fin;
        this.table = table;
    }

    public int getSomme() {
        return somme;
    }

    @Override
    public void run() {
        for (int i = debut; i < fin; i++) {
            somme += table.get(i);
        }
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        int nbrPlages = 5;
        int range = list.size() / nbrPlages;

        Sommeur[] sommeurs = new Sommeur[nbrPlages];
        Thread[] threads = new Thread[nbrPlages];

        for (int i = 0; i < nbrPlages; i++) {
            int start = i * range;
            int end = (i == nbrPlages - 1) ? list.size() : (i + 1) * range;
            sommeurs[i] = new Sommeur(start, end, list);
            threads[i] = new Thread(sommeurs[i]);
        }

        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        int totalSum = 0;
        for (Sommeur sommeur : sommeurs) {
            totalSum += sommeur.getSomme();
        }

        System.out.println("Total sum: " + totalSum);
    }
}
```

##### **Observations :**
- **Division des tâches :** Le tableau est divisé en 5 plages égales, chaque plage étant traitée par un thread différent.
- **Somme calculée en parallèle :** Chaque thread calcule la somme des éléments dans sa plage respective. Une fois tous les threads terminés, la somme totale est calculée en additionnant les sommes partielles obtenues par chaque thread.
- **Exécution concurrente :** L'utilisation des threads permet d'effectuer les calculs de manière parallèle, réduisant ainsi le temps global d'exécution pour de grands tableaux.

##### **Problème observé :**
Aucun problème majeur n’a été observé dans cet exercice. Le code fonctionne comme prévu, mais l'efficacité pourrait être améliorée en ajustant le nombre de threads en fonction de la taille du tableau.

---

### **Conclusion générale :**
Les deux exercices mettent en évidence des concepts importants de la programmation multi-threads en Java. Dans le premier exercice, on apprend à créer des threads pour exécuter des tâches simultanément. Dans le second exercice, on utilise un pool de threads pour effectuer des calculs en parallèle, ce qui est utile pour traiter des données volumineuses de manière plus rapide. Ces exercices montrent l'efficacité de l'exécution concurrente tout en mettant en lumière les défis de la gestion des threads et de la synchronisation.
