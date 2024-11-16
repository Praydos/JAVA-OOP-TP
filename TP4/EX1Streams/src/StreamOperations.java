import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamOperations {

    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "pear", "grape", "orange", "kiwi");

        // 1. Filtrer les mots qui contiennent la lettre "a".
        List<String> filteredWordsWithA = words.stream()
                .filter(word -> word.contains("a"))
                .collect(Collectors.toList());
        System.out.println("Mots contenant la lettre 'a': " + filteredWordsWithA);

        // 2. Filtrer les mots ayant une longueur supérieure à 3 et inverser chaque mot.
        List<String> invertedLongWords = words.stream()
                .filter(word -> word.length() > 3)
                .map(word -> new StringBuilder(word).reverse().toString())
                .collect(Collectors.toList());
        System.out.println("Mots inversés de longueur > 3: " + invertedLongWords);

        // 3. Filtrer les chaînes contenant la lettre "e" et aplatir chaque chaîne en une liste de caractères.
        List<Character> flattenedCharsWithE = words.stream()
                .filter(word -> word.contains("e"))
                .flatMap(word -> word.chars().mapToObj(c -> (char) c))
                .collect(Collectors.toList());
        System.out.println("Caractères des mots contenant 'e': " + flattenedCharsWithE);

        // 4. Transformer chaque chaîne en majuscules.
        List<String> uppercasedWords = words.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println("Mots en majuscules: " + uppercasedWords);

        // 5. Convertir chaque chaîne en sa longueur.
        List<Integer> wordLengths = words.stream()
                .map(String::length)
                .collect(Collectors.toList());
        System.out.println("Longueurs des mots: " + wordLengths);

        // 6. Transformer chaque chaîne en une liste de ses caractères et aplatir en une liste unique.
        List<Character> allCharacters = words.stream()
                .flatMap(word -> word.chars().mapToObj(c -> (char) c))
                .collect(Collectors.toList());
        System.out.println("Liste aplatie de tous les caractères: " + allCharacters);

        // 7. Transformer chaque mot en une chaîne de la forme "Nom - Index".
        List<String> indexedWords = IntStream.range(0, words.size())
                .mapToObj(index -> words.get(index) + " - " + index)
                .collect(Collectors.toList());
        System.out.println("Mots avec index: " + indexedWords);
    }
}
