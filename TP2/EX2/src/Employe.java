public abstract class Employe {
    private String nom;
    private String prenom;
    private String telephone;
    private double salaire;

    //constructeur avec parametres
    public Employe(String nom, String prenom, String telephone, double salaire) {
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.salaire = salaire;
    }

    //constructeur sans parametre
    public Employe(){}

    public abstract double calculerSalaire();

    //getters

    public double getSalaire() {
        return salaire;
    }

    public String getNom() {
        return nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public String getTelephone() {
        return telephone;
    }


    //fct d'addichage
    public abstract void affiche();

}
