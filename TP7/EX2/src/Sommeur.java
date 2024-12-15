import java.util.ArrayList;
import java.util.List;

public class Sommeur implements Runnable {
    private List<Integer> table;
    private int debut;
    private int fin;
    private int somme; //

    //constructor
    public Sommeur(int debut, int fin,List<Integer> table) {
        this.debut = debut;
        this.fin = fin;
        this.table = table;

    }
    // getters & settters
    public int getDebut() {
        return debut;
    }
    public void setDebut(int debut) {
        this.debut = debut;
    }

    public int getFin() {
        return fin;
    }
    public void setFin(int fin) {
        this.fin = fin;
    }
    public List<Integer> getTable() {
        return table;
    }
    public void setTable(List<Integer> table) {
        this.table = table;
    }

    public int getSomme(){
        return somme;
    }
    //implementation du run
    @Override
    public void run() {
        if((debut>0 && debut<=fin) && (fin>debut && fin<=table.get(table.size()-1))) {
            for (int i = debut; i <= fin; i++) {
                somme += table.get(i);
            }

        }
    }



}
