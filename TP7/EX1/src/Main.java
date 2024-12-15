//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //Thread thead = new Thread(new Talkative(1));

        // Créez 10 instances de Thread
        Thread[] threads = new Thread[10]; // listes des treads vide
        for (int i = 0; i < 10; i++) {
                         //instance de tread
            threads[i] = new Thread(new Talkative(i)); // Chaque Thread a un entier unique
        }
        // Lancez les threads
        for (Thread thread : threads) {
            thread.start();
        }
    }
}