public class Ordinateur {
    private String nom;
    private double prix;
    private String description;
    private int nbrStock;

    public Ordinateur(String nom, double prix, String description, int nbrStock) {
        this.nom = nom;
        this.prix = prix;
        this.description = description;
        this.nbrStock = nbrStock;
    }
    public double calculerPrix(int nbrDonne) {
        return prix*nbrDonne;
    }

    //getters
    public double getPrix() {
        return prix;
    }

}
