public class Auteur extends Personne{
    private int numAuteur;


    public Auteur(String nom, String prenom, int age, String email, int numAuteur) {
        super(nom, prenom, age, email);
        this.numAuteur = numAuteur;
    }

    public void afficher(){
        super.affiche();
        System.out.println("Auteur: " + numAuteur);
    }


}
