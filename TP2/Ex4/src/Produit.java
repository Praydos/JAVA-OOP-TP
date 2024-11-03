public class Produit {
    private String nom;
    private String id;
    private String description;
    private double prix;
    private String marque;
    private int nbrStock;

    public Produit(String nom, String id, String description, double prix, int nbrStock, String marque) {
        this.nom = nom;
        this.id = id;
        this.description = description;
        this.prix = prix;
        this.nbrStock = nbrStock;
        this.marque = marque;

    }

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getMarque() { return marque; }
    public void setMarque(String marque) { this.marque = marque; }

    public double getPrix() { return prix; }
    public void setPrix(double prix) { this.prix = prix; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public int getNombreEnStock() { return nbrStock; }
    public void setNombreEnStock(int nombreEnStock) { this.nbrStock = nombreEnStock; }

    // ToString for easy display
    @Override
    public String toString() {
        return "Produit{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", marque='" + marque + '\'' +
                ", prix=" + prix +
                ", description='" + description + '\'' +
                ", nombreEnStock=" + nbrStock +
                '}';
    }



}
