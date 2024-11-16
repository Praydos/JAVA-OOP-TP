Compte rendu du code Java qui gère les exceptions lors du calcul de la racine carrée, en identifiant les nombres négatifs à l'aide d'une exception personnalisée appelée `RacineCarreeException`. Le code se compose de trois parties : la classe `RacineCarreeException`, la classe `Calculateur`, et une méthode `main` pour tester les fonctionnalités.

### Classe `RacineCarreeException`

La classe `RacineCarreeException` étend la classe `Exception` et est conçue pour représenter une erreur lorsqu'un nombre négatif est utilisé dans un calcul de racine carrée. Cette classe n'a pas d'attributs, conformément aux spécifications de l'exercice. Son constructeur prend un entier en paramètre, représentant le nombre négatif à l'origine de l'exception, et appelle le constructeur de la classe parente avec un message d'erreur spécifique : "C'est une exception de type RacineCarreeException. Nombre négatif : " suivi de la valeur de l'entier. Ce message fournit un retour clair sur la cause de l'exception, permettant ainsi de l'identifier facilement lors de sa capture.

### Classe `Calculateur`

La classe `Calculateur` est une classe utilitaire simple sans attributs, qui propose un constructeur vide. Elle inclut une méthode, `testRacineCarree(int entier)`, qui prend un entier comme argument et lance une `RacineCarreeException` si l'entier est négatif. Ce mécanisme garantit que toute tentative d'utilisation d'un nombre négatif dans un calcul de racine carrée est signalée comme une erreur. L'exception est levée avec l'entier problématique, rendant ainsi clair pour l'utilisateur ou le développeur qu'une entrée négative est invalide pour cette opération.

### Méthode `main` dans la classe `Main`

Dans la méthode `main` de la classe `Main`, une instance de `Calculateur` est créée, et `testRacineCarree()` est appelée deux fois pour démontrer les deux cas : une fois avec -5 (une valeur négative qui devrait déclencher une exception) et une fois avec 5 (une valeur positive qui ne devrait pas déclencher d'exception). Les appels de méthode sont enveloppés dans un bloc `try-catch`, de sorte que si `RacineCarreeException` est lancée, elle soit capturée et gérée. Dans le bloc catch, `System.out.println(e.getMessage())` est utilisé pour afficher le message de l'exception, montrant "C'est une exception de type RacineCarreeException. Nombre négatif : -5" pour l'entrée négative. Ce retour d'information, associé à la pile d'appels, aide à tracer la source de l'erreur et la séquence des appels qui y ont conduit.

### Résumé

En résumé, ce code établit un mécanisme d'exception personnalisé pour gérer les entrées invalides lors de calculs de racine carrée, assurant des messages d'erreur clairs et permettant aux développeurs de capturer et de tracer les exceptions efficacement. En exécutant à la fois des cas positifs et négatifs et en affichant le message d'exception, il vérifie la fonctionnalité de `RacineCarreeException` et fournit un test complet de la capacité de la classe `Calculateur` à gérer des cas limites.
