//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Calculateur calc = new Calculateur();

        try {
            calc.testRacineCarree(10);
            System.out.println("Racine carree valide");
            calc.testRacineCarree(-1);
        } catch (RacineCarreeException e) {
            System.out.println(e.getMessage());
        }

    }
}