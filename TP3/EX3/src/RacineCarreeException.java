public class RacineCarreeException extends Exception {
    public RacineCarreeException(int entier) {
        super("C'est une exception de type RacineCarreeException. Nombre négatif : " + entier);
    }
}
