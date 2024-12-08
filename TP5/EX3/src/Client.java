import java.io.Serializable;

public class Client implements Serializable {
    private String nom;
    private String prenom;
    private String adresse;
    private String telephone;

    //constructor
    public Client(String nom, String prenom, String adresse, String telephone) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.telephone = telephone;
    }
    //getters & setters
    public String getNom() {
        return nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public String getAdresse() {
        return adresse;
    }
    public String getTelephone() {
        return telephone;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    //afficher
    public void afficher(){
        System.out.println("Nom: " + nom);
        System.out.println("Prenom: " + prenom);
        System.out.println("Adresse: " + adresse);
        System.out.println("Telephone: " + telephone);
    }
}
