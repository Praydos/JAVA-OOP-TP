public class Adherent extends Personne{
    private int numAdherent;

    public Adherent(String nom, String prenom, int age, String email, int numAdherent) {
        super(nom, prenom, age, email);
        this.numAdherent = numAdherent;
    }

    @Override
    public void affiche() {
        super.affiche();
        System.out.println("Num Adherent: " + numAdherent);
    }
}
