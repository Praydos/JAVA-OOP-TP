public class Calculateur {
    public Calculateur() {}

    public void testRacineCarree(int entier) throws RacineCarreeException {
        if (entier <0 ){
            throw new RacineCarreeException(entier);
        }
    }
}
