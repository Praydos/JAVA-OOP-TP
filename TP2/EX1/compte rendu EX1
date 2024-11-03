Voici le compte rendu sous forme de texte continu pour les travaux pratiques sur la gestion de bibliothèque en Java :

Dans ce projet, nous avons conçu une application en Java pour gérer les informations de personnes, d'adhérents et d'auteurs dans le cadre d'une bibliothèque.
Le projet comprend la création de plusieurs classes, chacune représentant des entités spécifiques avec leurs attributs et méthodes propres.

Tout d'abord, la classe de base `Personne` a été créée pour stocker des informations personnelles avec les attributs `nom`, `prenom`, `age` et `email`.
Ces attributs sont privés pour assurer l'encapsulation, et le constructeur permet de les initialiser lors de l'instanciation d'un objet `Personne`. 
La méthode `affiche()` est définie pour afficher les informations de chaque personne. Cette classe est conçue pour être étendue par d'autres classes spécifiques.

Ensuite, nous avons créé une sous-classe `Adherent` qui hérite de `Personne` et ajoute un attribut spécifique `numAdherent` (numéro d'adhérent). 
Dans cette classe, le constructeur appelle celui de la classe parente `Personne` en utilisant le mot-clé `super`, et la méthode `affiche()` est 
redéfinie pour inclure l'affichage de `numAdherent` en plus des attributs de `Personne`. 
Cela permet d'afficher toutes les informations pertinentes pour un adhérent.

De la même manière, une autre sous-classe nommée `Auteur` est dérivée de `Personne`, avec un attribut supplémentaire `numAuteur` (numéro d'auteur). 
Le constructeur de `Auteur` initialise tous les attributs de `Personne` ainsi que `numAuteur`. La méthode `affiche()` est également redéfinie 
pour afficher toutes les informations, y compris le numéro de l'auteur. Ces deux sous-classes, `Adherent` et `Auteur`, illustrent le concept d'héritage et 
de polymorphisme en permettant à des classes spécifiques d'avoir des attributs et des comportements additionnels tout en partageant les caractéristiques de 
`Personne`.

La classe `Livre` a également été implémentée pour représenter les informations d'un livre. 
Elle contient des attributs pour le `ISBN` (numéro de série du livre), le `titre` (titre du livre), et un objet `auteur` de type `Auteur`, 
permettant d'associer un auteur spécifique au livre. Le constructeur de `Livre` initialise ces attributs, et la méthode `affiche()` affiche 
les informations du livre, y compris le `ISBN`, le `titre`, et les informations de l'auteur via un appel à la méthode `affiche()` de `Auteur`.

Enfin, dans la classe principale `Main`, une méthode `main()` est créée pour tester ces différentes classes. 
Un adhérent est d'abord instancié avec des informations de base, suivi par la création d'un auteur et d'un livre. 
Les informations de l'adhérent sont ensuite affichées, puis celles du livre et de son auteur. Ce projet démontre les principes 
fondamentaux de la programmation orientée objet, notamment l'encapsulation, l'héritage et le polymorphisme, 
en structurant les informations de manière hiérarchique et en permettant un affichage clair des détails pour chaque entité.
