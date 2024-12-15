import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InterruptedException {
        //list des entier
        List<Integer> list = new ArrayList<Integer>();
        for(int i=0 ; i<10;i++){
            list.add(i);
        }

        //System.out.println(list.size());
        //nbr de plages
        int nbrPlages = 5;
        int range = list.size()/nbrPlages;
        // Créez des instances de Thread
        // Create Sommeur objects and threads
        Sommeur[] sommeurs = new Sommeur[nbrPlages];
        Thread[] threads = new Thread[nbrPlages];

        //diviser table => definir end and start
        //
        for (int i = 0; i < nbrPlages; i++) {
            int start = i * range;
            int end = (i == nbrPlages - 1) ? list.size() : (i + 1) * range;
            // Create Sommeur and Thread
            sommeurs[i] = new Sommeur(start, end, list);
            threads[i] = new Thread(sommeurs[i]);
        }

        // Lancez les threads
        // Start all threads
        for (Thread thread : threads) {
            thread.start();
        }

        // Wait for threads to finish
        for (Thread thread : threads) {
            thread.join();
        }

        // Compute total sum
        int totalSum = 0;
        for (Sommeur sommeur : sommeurs) {
            totalSum += sommeur.getSomme();
        }

        System.out.println("Total sum: " + totalSum);
    }
}