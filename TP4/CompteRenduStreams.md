### Compte-rendu des deux exercices des Streams

---

### **Exercice 1 : Manipulation d'une liste de mots avec les Streams Java**

Nous avons effectué plusieurs opérations sur une liste de mots en utilisant les **Streams Java 8**. Voici les détails de chaque question, avec les extraits de code associés.

---

#### **1. Filtrer les mots qui contiennent la lettre "a"**

Pour cette opération, nous avons utilisé la méthode `filter()` pour sélectionner les mots qui contiennent la lettre "a".

```java
List<String> filteredWordsWithA = words.stream()
        .filter(word -> word.contains("a"))
        .collect(Collectors.toList());
System.out.println("Mots contenant la lettre 'a': " + filteredWordsWithA);
```

**Résultat attendu :**

```
Mots contenant la lettre 'a': [apple, banana, grape, orange]
```

---

#### **2. Filtrer les mots ayant une longueur supérieure à 3 et transformer chaque mot en son inverse**

Ici, on filtre les mots dont la longueur est supérieure à 3 et on les inverse avec `StringBuilder`.

```java
List<String> invertedLongWords = words.stream()
        .filter(word -> word.length() > 3)
        .map(word -> new StringBuilder(word).reverse().toString())
        .collect(Collectors.toList());
System.out.println("Mots inversés de longueur > 3: " + invertedLongWords);
```

**Résultat attendu :**

```
Mots inversés de longueur > 3: [elppa, ananab, pear, eparg, egnaro]
```

---

#### **3. Filtrer les chaînes contenant la lettre "e" et aplatir chaque chaîne en une liste de ses caractères**

On filtre les mots contenant "e", puis on les transforme en liste de caractères avec `flatMap()`.

```java
List<Character> flattenedCharsWithE = words.stream()
        .filter(word -> word.contains("e"))
        .flatMap(word -> word.chars().mapToObj(c -> (char) c))
        .collect(Collectors.toList());
System.out.println("Caractères des mots contenant 'e': " + flattenedCharsWithE);
```

**Résultat attendu :**

```
Caractères des mots contenant 'e': [a, p, p, l, e, p, e, a, r, g, r, a, p, e, o, r, a, n, g, e]
```

---

#### **4. Transformer chaque chaîne en sa version en majuscules**

Cette opération consiste à transformer chaque mot en majuscules avec `map()`.

```java
List<String> uppercasedWords = words.stream()
        .map(String::toUpperCase)
        .collect(Collectors.toList());
System.out.println("Mots en majuscules: " + uppercasedWords);
```

**Résultat attendu :**

```
Mots en majuscules: [APPLE, BANANA, PEAR, GRAPE, ORANGE, KIWI]
```

---

#### **5. Convertir chaque chaîne en sa longueur**

Ici, on transforme chaque mot en sa longueur avec `map()`.

```java
List<Integer> wordLengths = words.stream()
        .map(String::length)
        .collect(Collectors.toList());
System.out.println("Longueurs des mots: " + wordLengths);
```

**Résultat attendu :**

```
Longueurs des mots: [5, 6, 4, 5, 6, 4]
```

---

#### **6. Transformer chaque chaîne en une liste de ses caractères, puis aplatir toutes les listes en une seule liste de caractères**

Nous avons aplati toutes les listes de caractères de chaque mot avec `flatMap()`.

```java
List<Character> allCharacters = words.stream()
        .flatMap(word -> word.chars().mapToObj(c -> (char) c))
        .collect(Collectors.toList());
System.out.println("Liste aplatie de tous les caractères: " + allCharacters);
```

**Résultat attendu :**

```
Liste aplatie de tous les caractères: [a, p, p, l, e, b, a, n, a, n, a, p, e, a, r, g, r, a, p, e, o, r, a, n, g, e, k, i, w, i]
```

---

#### **7. À partir d'une liste de mots, transformer chaque nom en une chaîne de la forme "Nom - Index" où l'index représente la position du nom dans la liste**

Pour cette tâche, nous avons utilisé `IntStream.range()` pour obtenir l'index de chaque élément et l'ajouter au nom.

```java
List<String> indexedWords = IntStream.range(0, words.size())
        .mapToObj(index -> words.get(index) + " - " + index)
        .collect(Collectors.toList());
System.out.println("Mots avec index: " + indexedWords);
```

**Résultat attendu :**

```
Mots avec index: [apple - 0, banana - 1, pear - 2, grape - 3, orange - 4, kiwi - 5]
```

---

### **Exercice 2 : Gestion d'une liste d'employés avec Streams**

Cet exercice explore les Streams avec des objets complexes (employés). Voici les étapes avec les extraits de code correspondants.

---

#### **1. Utiliser `mapToDouble` et `sum` pour calculer la somme totale des salaires de tous les employés**

On utilise `mapToDouble()` pour extraire les salaires et `sum()` pour les additionner.

```java
double totalSalary = employees.stream()
        .mapToDouble(Employee::getSalary)
        .sum();
System.out.println("Somme totale des salaires : " + totalSalary);
```

**Résultat attendu :**

```
Somme totale des salaires : 295000.0
```

---

#### **2. Utiliser `sorted` pour trier la liste des employés par ordre alphabétique du nom**

Le tri est effectué en utilisant `Comparator.comparing()` sur le nom des employés.

```java
List<Employee> sortedEmployees = employees.stream()
        .sorted(Comparator.comparing(Employee::getName))
        .collect(Collectors.toList());
System.out.println("Employés triés par nom : " + sortedEmployees);
```

**Résultat attendu :**

```
Employés triés par nom : [Alice, Bob, Charlie, Diana, Eve]
```

---

#### **3. Utiliser `min` pour trouver l'employé avec le salaire le plus bas**

`min()` est utilisé pour obtenir l'employé ayant le salaire le plus bas.

```java
Optional<Employee> lowestPaidEmployee = employees.stream()
        .min(Comparator.comparingDouble(Employee::getSalary));
lowestPaidEmployee.ifPresent(e -> System.out.println("Employé avec le salaire le plus bas : " + e));
```

**Résultat attendu :**

```
Employé avec le salaire le plus bas : Employee{name='Eve', department='HR', salary=45000.0}
```

---

#### **4. Utiliser `filter` pour obtenir la liste des employés ayant un salaire supérieur à une valeur donnée**

On filtre les employés ayant un salaire supérieur à un seuil spécifié (par exemple, 50000).

```java
double threshold = 50000;
List<Employee> filteredEmployees = employees.stream()
        .filter(e -> e.getSalary() > threshold)
        .collect(Collectors.toList());
System.out.println("Employés avec un salaire supérieur à " + threshold + " : " + filteredEmployees);
```

**Résultat attendu :**

```
Employés avec un salaire supérieur à 50000 : [Employee{name='Bob', department='Finance', salary=55000.0}, Employee{name='Charlie', department='Engineering', salary=70000.0}, Employee{name='Diana', department='Engineering', salary=75000.0}]
```

---

#### **5. Utiliser `reduce` pour trouver l'employé avec le salaire le plus élevé dans l'ensemble de l'entreprise**

On utilise `reduce()` pour comparer les salaires et obtenir l'employé avec le salaire le plus élevé.

```java
Optional<Employee> highestPaidEmployee = employees.stream()
        .reduce((e1, e2) -> e1.getSalary() > e2.getSalary() ? e1 : e2);
highestPaidEmployee.ifPresent(e -> System.out.println("Employé avec le salaire le plus élevé : " + e));
```

**Résultat attendu :**

```
Employé avec le salaire le plus élevé : Employee{name='Diana', department='Engineering', salary=75000.0}
```

---

#### **6. Utiliser `reduce` pour concaténer les noms de tous les employés**

`reduce()` est utilisé pour concaténer les noms des employés dans une seule chaîne.

```java
String concatenatedNames = employees.stream()
        .map(Employee::getName)
        .reduce("", (name1, name2) -> name1 + (name1.isEmpty() ? "" : ", ") + name2);
System.out.println("Noms concaténés de tous les employés : " + concatenatedNames);
```

**Résultat attendu :**

```
Noms concaténés de tous les employés : Alice, Bob, Charlie, Diana, Eve
```

---

### **Conclusion et comparaison entre les deux exercices**

Les deux exercices montrent l’utilisation des **Streams** en Java pour traiter des collections de données, que ce soit des chaînes de caractères ou des objets complexes. 

