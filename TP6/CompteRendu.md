

## **Exercice 1 : Gestion des produits et clients**

### **Objectif :**
Créer un système de gestion des produits et clients qui permet d'ajouter, supprimer, rechercher et sauvegarder des entités tout en assurant la persistance des données dans des fichiers.

### **Mise en œuvre :**

1. **Définition des classes de base (`Produit` et `Client`)** :
   - Chaque classe contient des attributs propres (nom, marque, prix pour `Produit`; nom, prénom, adresse pour `Client`) et implémente l'interface `Serializable` pour assurer leur sérialisation.

**Extrait de code :**
```java
import java.io.Serializable;

public class Produit implements Serializable {
    private String nom;
    private String marque;
    private double prix;
    private String description;
    private int stock;

    public Produit(String nom, String marque, double prix, String description, int stock) {
        this.nom = nom;
        this.marque = marque;
        this.prix = prix;
        this.description = description;
        this.stock = stock;
    }

    @Override
    public String toString() {
        return nom + " (" + marque + ") - Prix: " + prix + " - Stock: " + stock;
    }
}
```

2. **Interface générique `IMetier` :**
   - Définit les méthodes standard pour la gestion des entités : ajout, recherche, suppression, sauvegarde, etc.

**Extrait de code :**
```java
import java.util.List;

public interface IMetier<T> {
    T add(T o);
    List<T> getAll();
    T findByNom(String nom);
    void delete(String nom);
    void saveAll();
}
```

3.### **Explication détaillée de `MetierProduitImpl`**

La classe **`MetierProduitImpl`** est conçue pour gérer une collection d’objets `Produit`. Elle implémente l’interface générique `IMetier<Produit>` et fournit des fonctionnalités telles que l’ajout, la récupération, la suppression, la recherche et la persistance des données des produits. Cette classe encapsule toute la logique métier liée à la gestion des produits.

---

### **Attributs**
1. **`List<Produit> produits`:**  
   - Une liste dynamique qui contient tous les objets `Produit` en mémoire.
   - Sert de structure principale pour effectuer des opérations comme l’ajout, la suppression et la recherche.

2. **`String fileName`:**  
   - Nom du fichier utilisé pour sauvegarder les objets `Produit` (par exemple, `produits.dat`).
   - Permet d'assurer la persistance des données entre les exécutions du programme.

---

### **Méthodes**

#### 1. **`add(Produit produit)`**
   - Ajoute un objet `Produit` à la liste `produits`.
   - Retourne l’objet `Produit` ajouté.

**Points clés :**
   - Permet d’enrichir dynamiquement la liste des produits.
   - Les modifications sont apportées uniquement en mémoire et nécessitent un appel à `saveAll()` pour persister.

**Exemple de code :**
```java
@Override
public Produit add(Produit produit) {
    produits.add(produit);
    return produit;
}
```

---

#### 2. **`getAll()`**
   - Charge tous les objets `Produit` stockés dans le fichier spécifié par `fileName`.
   - Désérialise les données pour remplir la liste `produits`.
   - Si le fichier est introuvable ou vide, initialise une liste vide.

**Points clés :**
   - Cette méthode est appelée au démarrage de l’application pour récupérer les données persistantes.
   - Utilise des exceptions pour gérer les erreurs de fichier ou de désérialisation.

**Exemple de code :**
```java
@Override
public List<Produit> getAll() {
    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
        produits = (List<Produit>) ois.readObject();
    } catch (Exception e) {
        produits = new ArrayList<>();
    }
    return produits;
}
```

---

#### 3. **`findByNom(String nom)`**
   - Cherche dans la liste le premier objet `Produit` ayant un nom correspondant au paramètre `nom`.
   - Effectue une comparaison insensible à la casse pour plus de flexibilité.

**Points clés :**
   - Retourne l’objet `Produit` trouvé ou `null` si aucun objet ne correspond.

**Exemple de code :**
```java
@Override
public Produit findByNom(String nom) {
    for (Produit produit : produits) {
        if (produit.getNom().equalsIgnoreCase(nom)) {
            return produit;
        }
    }
    return null;
}
```

---

#### 4. **`delete(String nom)`**
   - Supprime tous les objets `Produit` ayant un nom correspondant dans la liste.
   - Utilise la méthode `removeIf` pour identifier et supprimer les correspondances.

**Points clés :**
   - Modifie directement la liste en mémoire.
   - Nécessite un appel à `saveAll()` pour persister les changements.

**Exemple de code :**
```java
@Override
public void delete(String nom) {
    produits.removeIf(produit -> produit.getNom().equalsIgnoreCase(nom));
}
```

---

#### 5. **`saveAll()`**
   - Sérialise la liste `produits` et la sauvegarde dans le fichier spécifié par `fileName`.
   - Garantit la persistance des données après des modifications.

**Points clés :**
   - Utilise un bloc `try-with-resources` pour assurer la fermeture automatique du flux.
   - Gère les exceptions d'entrée/sortie (IOException).

**Exemple de code :**
```java
@Override
public void saveAll() {
    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
        oos.writeObject(produits);
    } catch (IOException e) {
        e.printStackTrace();
    }
}
```

---

### **Fonctionnement global**
1. **Initialisation :**
   - Au lancement du programme, `getAll()` est appelée pour charger la liste des produits à partir du fichier `produits.dat`.
   - Si le fichier n’existe pas, une liste vide est initialisée.

2. **Ajout et suppression :**
   - L’ajout de produits est effectué avec `add()` et la suppression avec `delete()`. Ces modifications s’appliquent directement à la liste en mémoire.

3. **Persistance :**
   - Après toute modification, `saveAll()` doit être appelée pour sauvegarder les données dans le fichier.

---

### **Avantages**
1. **Modularité :**
   - La logique métier est centralisée dans une classe unique, facilitant la maintenance et les mises à jour.

2. **Persistance des données :**
   - Les produits sont sauvegardés dans un fichier et restaurés automatiquement lors de l’exécution suivante.

3. **Extensibilité :**
   - La classe peut être facilement enrichie avec de nouvelles méthodes ou attributs pour répondre à des besoins futurs.

---

### **Exemple d’utilisation**

**Ajout et sauvegarde d’un produit :**
```java
MetierProduitImpl metierProduit = new MetierProduitImpl();

// Charger les produits existants
metierProduit.getAll();

// Ajouter un nouveau produit
Produit nouveauProduit = new Produit("Laptop", "Dell", 1500.0, "Ordinateur portable performant", 10);
metierProduit.add(nouveauProduit);

// Sauvegarder les changements
metierProduit.saveAll();
System.out.println("Produit ajouté et sauvegardé.");
```

**Recherche d’un produit :**
```java
Produit produitTrouve = metierProduit.findByNom("Laptop");
if (produitTrouve != null) {
    System.out.println("Produit trouvé : " + produitTrouve);
} else {
    System.out.println("Aucun produit trouvé avec ce nom.");
}
```

**Suppression d’un produit :**
```java
metierProduit.delete("Laptop");
metierProduit.saveAll();
System.out.println("Produit supprimé et données sauvegardées.");
```

---

### **Conclusion**
La classe **`MetierProduitImpl`** offre une solution robuste pour la gestion des produits. Elle gère efficacement les données en mémoire et les sauvegarde de manière persistante grâce à la sérialisation. Son architecture modulaire et orientée objet en fait une base solide pour des applications commerciales ou des systèmes de gestion de stock.

### *Implémentation de la logique métier `MetierClientImpl`**

La classe **`MetierClientImpl`** gère une collection d'objets `Client`. Elle implémente l’interface générique `IMetier<Client>` pour offrir des fonctionnalités comme l’ajout, la recherche, la suppression et la persistance des données des clients. Voici une explication détaillée de sa structure et de ses fonctionnalités.

---

### **Attributs**
1. **`List<Client> clients`:**  
   - Une liste dynamique qui stocke tous les objets `Client` en mémoire.  
   - Cette structure de données est utilisée pour effectuer des opérations comme la recherche, l’ajout et la suppression.

2. **`String fileName`:**  
   - Contient le nom du fichier (`clients.dat`) utilisé pour sauvegarder la liste des clients.  
   - Garantit la persistance des données entre les exécutions du programme.

---

### **Méthodes**

#### 1. **`add(Client client)`**
   - Ajoute un objet `Client` à la liste `clients`.
   - Retourne l’objet `Client` ajouté.

**Points clés :**
   - Cette méthode met uniquement à jour la liste en mémoire. La persistance doit être effectuée via un appel explicite à `saveAll()`.

**Exemple de code :**
```java
@Override
public Client add(Client client) {
    clients.add(client);
    return client;
}
```

---

#### 2. **`getAll()`**
   - Charge la liste des clients à partir du fichier spécifié par `fileName`.
   - Désérialise les données du fichier et les ajoute à la liste `clients`.
   - Si le fichier n’existe pas ou est vide, la liste est initialisée comme une liste vide.

**Points clés :**
   - Permet de récupérer les données sauvegardées lors de précédentes exécutions.
   - Gère les erreurs de fichier ou de désérialisation.

**Exemple de code :**
```java
@Override
public List<Client> getAll() {
    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
        clients = (List<Client>) ois.readObject();
    } catch (Exception e) {
        // Si le fichier est introuvable, on initialise une liste vide
        clients = new ArrayList<>();
    }
    return clients;
}
```

---

#### 3. **`findByNom(String nom)`**
   - Recherche dans la liste le premier client correspondant au nom (`nom`) fourni.
   - La comparaison est insensible à la casse (case-insensitive).

**Points clés :**
   - Retourne le premier client trouvé ou `null` si aucun client ne correspond.

**Exemple de code :**
```java
@Override
public Client findByNom(String nom) {
    for (Client client : clients) {
        if (client.getNom().equalsIgnoreCase(nom)) {
            return client;
        }
    }
    return null; // Aucun client correspondant trouvé
}
```

---

#### 4. **`delete(String nom)`**
   - Supprime tous les clients de la liste ayant un nom correspondant à celui fourni.
   - Utilise une fonction lambda avec `removeIf` pour simplifier la suppression.

**Points clés :**
   - Modifie la liste en mémoire. Les changements doivent être sauvegardés avec `saveAll()`.

**Exemple de code :**
```java
@Override
public void delete(String nom) {
    clients.removeIf(client -> client.getNom().equalsIgnoreCase(nom));
}
```

---

#### 5. **`saveAll()`**
   - Sérialise la liste `clients` et l’écrit dans le fichier spécifié par `fileName`.
   - Assure que toutes les modifications apportées à la liste sont enregistrées de manière persistante.

**Points clés :**
   - Utilise un bloc `try-with-resources` pour garantir la fermeture correcte du flux.
   - Gère les éventuelles exceptions liées à l’écriture dans le fichier.

**Exemple de code :**
```java
@Override
public void saveAll() {
    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
        oos.writeObject(clients);
    } catch (IOException e) {
        e.printStackTrace();
    }
}
```

---

### **Comment les éléments fonctionnent ensemble**
1. **Initialisation :**
   - Lors du démarrage du programme, la méthode `getAll()` charge les clients depuis le fichier `clients.dat` pour les ajouter à la liste en mémoire.
   - Si le fichier n’existe pas, une nouvelle liste vide est créée.

2. **Opérations :**
   - Les utilisateurs peuvent effectuer des opérations comme l’ajout (`add()`), la suppression (`delete()`) ou la recherche (`findByNom()`). Ces actions modifient uniquement la liste en mémoire.

3. **Persistance :**
   - La méthode `saveAll()` doit être appelée explicitement après des modifications pour sauvegarder les données dans le fichier.

---

### **Avantages**
1. **Séparation des responsabilités :**
   - La classe se concentre uniquement sur la logique métier et la gestion de la persistance, laissant l’interface utilisateur à une autre classe.
   
2. **Persistance des données :**
   - Grâce à la sérialisation, les données des clients sont sauvegardées et restaurées automatiquement.

3. **Flexibilité et extensibilité :**
   - La classe peut être facilement modifiée pour ajouter des fonctionnalités ou des champs supplémentaires.

---

### **Exemple d’utilisation**

**Ajout et sauvegarde d’un client :**
```java
MetierClientImpl metierClient = new MetierClientImpl();

// Charger les clients existants
metierClient.getAll();

// Ajouter un nouveau client
Client nouveauClient = new Client("Durand", "Marie", "Lyon", "0654321987", "marie.durand@example.com");
metierClient.add(nouveauClient);

// Sauvegarder les changements
metierClient.saveAll();
System.out.println("Client ajouté et sauvegardé.");
```

**Recherche d’un client :**
```java
Client clientTrouve = metierClient.findByNom("Durand");
if (clientTrouve != null) {
    System.out.println("Client trouvé : " + clientTrouve);
} else {
    System.out.println("Aucun client trouvé avec ce nom.");
}
```

**Suppression d’un client :**
```java
metierClient.delete("Durand");
metierClient.saveAll();
System.out.println("Client supprimé et données sauvegardées.");
```

---

### **Conclusion**
La classe **`MetierClientImpl`** est une implémentation robuste et efficace pour la gestion des clients. Grâce à son approche modulaire et orientée objet, elle permet de manipuler les données de manière flexible tout en garantissant leur persistance via la sérialisation.

4. **Application principale :**
   - Fournit un menu pour gérer les produits.

**Extrait de code :**
```java
public class Application {
    public static void main(String[] args) {
        MetierProduitImpl metier = new MetierProduitImpl();
        metier.getAll(); // Charger les produits existants

        // Exemple : Ajouter un produit
        Produit p1 = new Produit("Ordinateur", "Dell", 1200.0, "PC portable", 10);
        metier.add(p1);

        // Sauvegarder les modifications
        metier.saveAll();
        System.out.println("Produit ajouté et sauvegardé.");
    }
}
```

### **Points forts :**
- Modularité grâce à l'interface générique `IMetier`.
- Persistance des données dans des fichiers binaires.
- Gestion indépendante des produits et des clients.

---

## **Exercice 2 : Annuaire téléphonique**

### **Objectif :**
Créer un programme permettant de gérer un répertoire téléphonique avec des fonctionnalités d’ajout, suppression, recherche et modification, tout en sauvegardant les données dans un fichier.

### **Mise en œuvre :**

1. **Définition de la classe `DossierContact` :**
   - Stocke les contacts dans une `HashMap`, avec des noms comme clés et des numéros comme valeurs.

**Extrait de code :**
```java
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class DossierContact implements Serializable {
    private Map<String, String> contacts = new HashMap<>();

    public void ajouterContact(String nom, String numero) {
        contacts.put(nom, numero);
    }

    public String rechercherContact(String nom) {
        return contacts.get(nom);
    }

    public void sauvegarderDansFichier(String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(contacts);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

2. **Application principale :**
   - Fournit un menu pour interagir avec le répertoire.

**Extrait de code :**
```java
public class Main {
    public static void main(String[] args) {
        DossierContact dossier = new DossierContact();
        dossier.ajouterContact("Alice", "123456789");
        dossier.sauvegarderDansFichier("contacts.dat");
        System.out.println("Contact sauvegardé.");
    }
}
```

---

## **Exercice 3 : Simuler la commande `ls`**

### **Objectif :**
Développer un programme Java pour lister les fichiers et répertoires, leurs types, et leurs permissions en explorant récursivement les sous-répertoires.

### **Mise en œuvre :**

1. **Méthode pour lister les fichiers :**
   - Utilise la classe `File` pour accéder aux fichiers et répertoires.

**Extrait de code :**
```java
public class SimulerLS {
    public static void listerRepertoire(File repertoire) {
        File[] fichiers = repertoire.listFiles();
        if (fichiers != null) {
            for (File fichier : fichiers) {
                String type = fichier.isDirectory() ? "<DIR>" : "<FILE>";
                String permissions = (fichier.canRead() ? "r" : "-") +
                                     (fichier.canWrite() ? "w" : "-") +
                                     (fichier.isHidden() ? "h" : "-");
                System.out.println(fichier.getAbsolutePath() + " " + type + " " + permissions);
                if (fichier.isDirectory()) {
                    listerRepertoire(fichier);
                }
            }
        }
    }
}
```

2. **Application principale :**
   - Demande le chemin du répertoire à explorer.

**Extrait de code :**
```java
public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Entrez le chemin du répertoire : ");
    String chemin = scanner.nextLine();
    File repertoire = new File(chemin);

    if (repertoire.exists() && repertoire.isDirectory()) {
        listerRepertoire(repertoire);
    } else {
        System.out.println("Le chemin spécifié n'est pas un répertoire valide.");
    }
}
```

### **Points forts :**
- Exploration récursive des répertoires.
- Affichage des permissions (`r`, `w`, `h`) et type (`<DIR>`, `<FILE>`).
- Programme simple et fonctionnel.

---

## **Conclusion :**
Ces exercices couvrent des concepts clés en Java, comme la sérialisation, la gestion des fichiers, et les structures de données, tout en mettant en œuvre des fonctionnalités pratiques. Ces solutions offrent un excellent cadre pour apprendre et appliquer la POO, la gestion de fichiers et les interactions utilisateur en Java.
