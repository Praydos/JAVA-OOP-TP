public class Ingenieur extends Employe {

    private String specialite;

    public Ingenieur(String nom, String prenom, String telephone, double salaire, String specialite) {
        super(nom, prenom, telephone, salaire);
        this.specialite = specialite;
    }

    @Override
    public double calculerSalaire() {
        return this.getSalaire()*0.15+this.getSalaire();
    }

    //fct d'affichage

    @Override
    public void affiche() {
        System.out.println("nom "+this.getNom());
        System.out.println("telephone "+this.getTelephone());
        System.out.println("prenom "+this.getPrenom());
        System.out.println("Specialite "+specialite);
        System.out.println("Salaire "+this.calculerSalaire());

    }
}
