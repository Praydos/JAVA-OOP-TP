import java.io.Serializable;

public class Produit implements Serializable {
    private  String nom;
    private String marque;
    private int nbrStock;
    private double prix;
    private String description;

    // constructor
    public Produit(String nom, String marque, int nbrStock, double prix, String description) {
        this.nom = nom;
        this.marque = marque;
        this.nbrStock = nbrStock;
        this.prix = prix;
        this.description = description;
    }
    //getters & setters
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getMarque() {
        return marque;
    }
    public void setMarque(String marque) {
        this.marque = marque;
    }
    public int getNbrStock() {
        return nbrStock;
    }
    public void setNbrStock(int nbrStock) {
        this.nbrStock = nbrStock;
    }
    public double getPrix() {
        return prix;
    }
    public void setPrix(double prix) {
        this.prix = prix;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    //
    public void afficher(){
        System.out.println("Nom: " + nom);
        System.out.println("Marque: " + marque);
        System.out.println("Nbr stock: " + nbrStock);
        System.out.println("Prix: " + prix);
        System.out.println("Description: " + description);
    }


}
