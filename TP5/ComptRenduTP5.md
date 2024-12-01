### **Compte Rendu : Travaux Pratiques - Gestion des Professeurs et Départements**

---

#### **Contexte et Objectif**
Le but principal de ce travail pratique est de concevoir et de développer une application de gestion des professeurs et des départements, en utilisant **JavaFX** pour l'interface utilisateur et **MySQL** pour la gestion des données. Ce projet intègre les concepts suivants :
- Programmation Orientée Objet (POO).
- Connexion et manipulation de bases de données relationnelles.
- Création d'une interface utilisateur graphique intuitive avec **JavaFX**.
- Implémentation des opérations CRUD (**Créer, Lire, Mettre à jour, Supprimer**) pour les entités **Professeur** et **Departement**.

---

### **1. Analyse et Modélisation**

#### **Entités et leurs Attributs**
1. **Professeur** :
   - **Attributs** :
     - `id`: Identifiant unique du professeur (clé primaire).
     - `nom`: Nom du professeur.
     - `prenom`: Prénom du professeur.
     - `cin`: Numéro de carte d'identité nationale.
     - `adresse`: Adresse personnelle.
     - `telephone`: Numéro de téléphone.
     - `email`: Adresse e-mail.
     - `dateRec`: Date de recrutement.
     - `idDep`: Identifiant du département auquel le professeur est affecté.

2. **Departement** :
   - **Attributs** :
     - `id`: Identifiant unique du département (clé primaire).
     - `nom`: Nom du département.



![Untitled](https://github.com/user-attachments/assets/14e5cf40-ac24-461e-bff3-dad9abc42f8e)


---

#### **Modèle Relationnel (MLD)**
Le modèle relationnel se compose de deux tables avec une relation clé étrangère :
1. **Table `Professeur`** :
   - Structure :
     ```sql
     CREATE TABLE Professeur (
         id INT PRIMARY KEY AUTO_INCREMENT,
         nom VARCHAR(255),
         prenom VARCHAR(255),
         cin VARCHAR(50),
         adresse VARCHAR(255),
         telephone VARCHAR(20),
         email VARCHAR(255),
         date_recrutement DATE,
         id_deprat INT,
         FOREIGN KEY (id_deprat) REFERENCES Departement(id)
     );
     ```

2. **Table `Departement`** :
   - Structure :
     ```sql
     CREATE TABLE Departement (
         id INT PRIMARY KEY AUTO_INCREMENT,
         nom VARCHAR(255)
     );
     ```

---

### **2. Implémentation Technique**

#### **a) Classes Métier**
1. **Classe `Professeur`** :
   - Représente les données d’un professeur, avec ses attributs, un constructeur, des getters, et des setters.

     ```java
     public class Professeur {
         private int id;
         private String nom;
         private String prenom;
         private String cin;
         private String adresse;
         private String telephone;
         private String email;
         private String dateRec;
         private int idDep;

         // Constructeurs, getters et setters
  
     }
     ```

2. **Classe `Departement`** :
   - Représente les données d’un département avec des attributs similaires.
  
      ```java
     ppublic class Departement {

        private String nom;
        private int id_deprat ;


        public Departement( int id_deprat,String nom) {
            this.nom = nom;
            this.id_deprat = id_deprat;
    
        }

         // Constructeurs, getters et setters
  
     }
     ```

---

#### **b) Classe `MetierImpl`**
Cette classe contient les **méthodes CRUD** pour les entités :
- **Professeur** :
  - `ajouterProfesseur(Professeur prof)`: Ajoute un professeur.
  - `modifierProfesseur(Professeur prof)`: Met à jour les informations d'un professeur existant.
  - `supprimerProfesseur(int id)`: Supprime un professeur en fonction de son `id`.
  - `getProfesseur(int id)`: Récupère un professeur par son `id`.
  - `getAllProfesseurs()`: Récupère la liste de tous les professeurs.

- **Departement** :
  - `ajouterDepartement(Departement dep)`.
  - `modifierDepartement(Departement dep)`.
  - `supprimerDepartement(int id)`.
  - `getDepartement(int id)`.
  - `getAllDepartements()`.

Exemple d’implémentation d’une méthode CRUD :
```java
public void ajouterProfesseur(Professeur prof) {
    try {
        String query = "INSERT INTO Professeur (nom, prenom, cin, adresse, telephone, email, date_recrutement, id_deprat) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, prof.getNom());
        ps.setString(2, prof.getPrenom());
        ps.setString(3, prof.getCin());
        ps.setString(4, prof.getAdresse());
        ps.setString(5, prof.getTelephone());
        ps.setString(6, prof.getEmail());
        ps.setDate(7, Date.valueOf(prof.getDateRec()));
        ps.setInt(8, prof.getIdDep());
        ps.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
```

---

#### **c) Singleton pour la Connexion à la Base de Données**
Le singleton garantit une connexion unique à la base de données :

```java
public class SignletonConnectionDB {
    private static Connection connection;

    private SignletonConnectionDB() {}

    public static Connection getConnexion() {
        if (connection == null) {
            try {
                // Explicitly load the MySQL JDBC driver
                Class.forName("com.mysql.cj.jdbc.Driver");

                // Update connection string with parameters used in the test class
                String url = "jdbc:mysql://localhost:3306/TP5?useSSL=false&serverTimezone=UTC";
                String user = "root";  // Your database username
                String password = "";  // Your database password

                connection = DriverManager.getConnection(url, user, password);
                System.out.println("Connection established successfully!");
            } catch (ClassNotFoundException e) {
                System.out.println("MySQL JDBC Driver not found.");
                e.printStackTrace();
            } catch (SQLException e) {
                System.out.println("Database connection failed: " + e.getMessage());
                e.printStackTrace();
                throw new RuntimeException("Database connection error!");
            }
        }
        return connection;
    }
}
```

---

### **3. Interface Utilisateur (JavaFX)**

---
### **Description de l'Interface Utilisateur (UI)**

L'interface utilisateur développée pour ce travail pratique utilise **JavaFX** et propose une gestion intuitive des **professeurs** et des **départements**. L'application est structurée en deux onglets principaux : **Professeurs** et **Départements**, accessibles via un **TabPane**.

---

#### **Structure Générale de l'UI**
1. **Onglets de Navigation** :
   - **Professeurs** : Permet d'effectuer toutes les opérations CRUD pour les professeurs.
   - **Départements** : Permet d'effectuer toutes les opérations CRUD pour les départements.

2. **Tableaux d'Affichage (`TableView`)** :
   - Chaque onglet contient un tableau (TableView) qui affiche la liste des entités (professeurs ou départements).
   - Les colonnes des tableaux sont liées aux attributs des entités via des `PropertyValueFactory`.

3. **Formulaires de Saisie** :
   - Chaque onglet contient un formulaire permettant d'entrer les données nécessaires pour ajouter ou modifier une entité.
   - Les champs de saisie (`TextField`) sont utilisés pour collecter les informations comme l'identifiant, le nom, l'adresse, etc.

4. **Boutons d'Action** :
   - Chaque onglet dispose de boutons dédiés pour les opérations CRUD :
     - **Ajouter** : Ajoute une nouvelle entité.
     - **Mettre à jour** : Met à jour une entité existante.
     - **Supprimer** : Supprime une entité spécifique.
     - **Lister** : Affiche toutes les entités dans le tableau.

---

### **Onglet Professeurs**

![image](https://github.com/user-attachments/assets/f0a4e220-3f60-445f-8641-9150551f26e5)


#### **Description**
L'onglet **Professeurs** est conçu pour gérer les informations des professeurs. Il contient :
- Un tableau (`TableView`) avec des colonnes correspondant aux attributs d'un professeur (`id`, `nom`, `prenom`, `cin`, `adresse`, `telephone`, `email`, `dateRec`, `idDep`).
- Un formulaire avec des champs de saisie pour entrer ou modifier les informations d’un professeur.
- Des boutons pour effectuer les actions CRUD.

#### **Actions Disponibles**
1. **Ajouter un Professeur** :
   - **Étapes** :
     1. Remplissez les champs dans le formulaire (e.g., `nom`, `prenom`, `cin`, etc.).
     2. Cliquez sur le bouton **Ajouter**.
     3. Les données sont envoyées à la base via la méthode `ajouterProfesseur` dans `MetierImpl`.
     4. Cliquez sur **Lister** pour voir le nouveau professeur ajouté dans le tableau.
     
   - **Code Événementiel** :
     ```java
     addButton.setOnAction(e -> {
            try {
                Professeur prof = new Professeur();
                prof.setNom(nomField.getText());
                prof.setPrenom(prenomField.getText());
                prof.setCin(cinField.getText());
                prof.setAdresse(adresseField.getText());
                prof.setTelephone(telephoneField.getText());
                prof.setEmail(emailField.getText());
                prof.setDateRec(dateRecField.getText());
                prof.setIdDep(Integer.parseInt(depField.getText()));
                metier.ajouterProfesseur(prof);
                listButton.fire(); // Refresh the list
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
     ```

2. **Mettre à Jour un Professeur** :
   - **Étapes** :
     1. Sélectionnez un professeur dans le tableau ou entrez son `id` dans le champ correspondant.
     2. Remplissez les champs à modifier (e.g., `nom`, `prenom`, etc.). Dans le cas où vous ne seriez pas en mesure de modifier un attribut, laissez-le vide.
     3. Cliquez sur le bouton **Mettre à jour**.
     4. Les modifications sont appliquées via la méthode `modifierProfesseur`.
     5. Cliquez sur **Lister** pour voir les changements dans le tableau.

   - **Code Événementiel** :
     ```java
     updateButton.setOnAction(e -> {
            try {
                int id = Integer.parseInt(idField.getText());
                Professeur prof = metier.getProfesseur(id);
                if (prof != null) {
                    prof.setNom(nomField.getText());
                    prof.setPrenom(prenomField.getText());
                    prof.setCin(cinField.getText());
                    prof.setAdresse(adresseField.getText());
                    prof.setTelephone(telephoneField.getText());
                    prof.setEmail(emailField.getText());
                    prof.setDateRec(dateRecField.getText());
                    prof.setIdDep(Integer.parseInt(depField.getText()));
                    metier.modifierProfesseur(prof);
                    listButton.fire(); // Refresh the list
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
     ```

3. **Supprimer un Professeur** :
   - **Étapes** :
     1. Entrez l'`id` du professeur à supprimer.
     2. Cliquez sur le bouton **Supprimer**.
     3. Le professeur est supprimé via la méthode `supprimerProfesseur`.

    - **Code Événementiel** :
     ```java
     deleteButton.setOnAction(e -> {
            try {
                int id = Integer.parseInt(idField.getText());
                metier.deleteProfesseur(id);
                listButton.fire(); // Refresh the list
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
     ```

4. **Lister les Professeurs** :
   - **Étapes** :
     1. Cliquez sur le bouton **Lister**.
     2. Tous les professeurs sont récupérés via `getAllProfesseurs` et affichés dans le tableau.
        
      - **Code Événementiel** :
     ```java
     listButton.setOnAction(e -> {
            try {
                List<Professeur> professors = metier.getProfesseurs();
                professorTable.getItems().clear();
                professorTable.getItems().addAll(professors);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
     ```
     

---

### **Onglet Départements**

![image](https://github.com/user-attachments/assets/07ecd8b0-181c-4933-b35f-615a341f2383)

#### **Description**
L'onglet **Départements** est dédié à la gestion des départements. Il contient :
- Un tableau (`TableView`) avec des colonnes pour `id` et `nom`.
- Un formulaire avec des champs de saisie pour entrer ou modifier les informations d’un département.
- Des boutons pour effectuer les actions CRUD.

#### **Actions Disponibles**
1. **Ajouter un Département** :
   - **Étapes** :
     1. Remplissez le champ `nom` dans le formulaire.
     2. Cliquez sur le bouton **Ajouter**.
     3. Le département est ajouté via `ajouterDepartement`.
     4. Cliquez sur **Lister** pour afficher le nouveau département dans le tableau.

   - **Code Événementiel** :
     ```java
     addButton.setOnAction(e -> {
         Departement dep = new Departement(0, nomField.getText());
         metier.ajouterDepartement(dep);
         listButton.fire(); // Rafraîchir le tableau
     });
     ```

2. **Mettre à Jour un Département** :
   - **Étapes** :
     1. Entrez l'`id` du département ou sélectionnez-le dans le tableau.
     2. Modifiez le champ `nom`.
     3. Cliquez sur le bouton **Mettre à jour**.
     4. Les modifications sont appliquées via `modifierDepartement`.

    - **Code Événementiel** :
     ```java
     updateButton.setOnAction(e -> {
            try {
                int id = Integer.parseInt(idField.getText());
                Departement dep = metier.getDepartement(id);
                if (dep != null) {
                    dep.setNom(nomField.getText());
                    metier.modifierDepartement(dep);
                    listButton.fire(); // Refresh the list
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
     ```

3. **Supprimer un Département** :
   - **Étapes** :
     1. Entrez l'`id` du département à supprimer.
     2. Cliquez sur le bouton **Supprimer**.
     3. Le département est supprimé via `supprimerDepartement`.

    - **Code Événementiel** :
     ```java
     deleteButton.setOnAction(e -> {
            try {
                int id = Integer.parseInt(idField.getText());
                metier.deleteDepartement(id);
                listButton.fire(); // Refresh the list
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
     ```

4. **Lister les Départements** :
   - **Étapes** :
     1. Cliquez sur le bouton **Lister**.
     2. Tous les départements sont récupérés via `getAllDepartements` et affichés dans le tableau.

    - **Code Événementiel** :
     ```java
     listButton.setOnAction(e -> {
            try {
                List<Departement> departments = metier.getDepartements();
                departmentTable.getItems().clear();
                departmentTable.getItems().addAll(departments);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
     ```

---

### **Résumé des Points Clés**
1. **Interface Modulaire** :
   - Deux onglets distincts pour la gestion des professeurs et des départements.
2. **CRUD Intégré** :
   - Toutes les fonctionnalités CRUD sont accessibles via des boutons clairs.
3. **Utilisation de TableView** :
   - Affichage dynamique des données.
   - Les colonnes sont automatiquement mises à jour après chaque opération.
4. **Interaction Simplifiée** :
   - Formulaires simples pour saisir ou modifier les données.

---



### **4. Tests et Validation**

#### **Tests Fonctionnels**
- Ajout d’un professeur et d’un département.
- Mise à jour des informations.
- Suppression d’un enregistrement.
- Vérification de la liste affichée.

#### **Tests Techniques**
- Vérification des requêtes SQL.
- Validation des entrées utilisateur (e.g., format d’email).

---

### **5. Résultats Obtenus**

- Une application fonctionnelle avec une interface intuitive.
- Gestion complète des données :
  - Ajout, mise à jour, suppression, et affichage des professeurs et départements.
- Base de données relationnelle interconnectée et synchronisée avec l'application.

---

### **6. Améliorations Futures**
1. **Recherche Avancée** :
   - Recherche par nom ou par ID avec des champs dédiés.
2. **Styling** :
   - Ajout d’un thème CSS pour améliorer l’interface utilisateur.
3. **Sécurisation** :
   - Ajout de contrôles pour éviter les injections SQL.

---

### **Conclusion**
Ce projet a permis de mettre en pratique les concepts avancés de Java et de MySQL pour développer une application de gestion robuste. Les compétences acquises incluent :
- Intégration de JavaFX avec une base de données.
- Création et manipulation des interfaces graphiques.
- Conception de systèmes CRUD évolutifs.
