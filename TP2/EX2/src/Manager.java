public class Manager extends Employe{
    private String service;

    public Manager( String nom, String prenom, String telephone, double salaire,String service) {
        super(nom, prenom, telephone, salaire);
        this.service = service;
    }

    @Override
    public double calculerSalaire() {
        return this.getSalaire()+this.getSalaire()*0.2;
    }

    @Override
    public void affiche() {
        System.out.println("nom "+this.getNom());
        System.out.println("telephone "+this.getTelephone());
        System.out.println("prenom "+this.getPrenom());
        System.out.println("Specialite "+service);
        System.out.println("Salaire "+this.calculerSalaire());

    }
}
