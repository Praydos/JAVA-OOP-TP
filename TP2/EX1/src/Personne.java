public class Personne {
    private String nom;
    private String prenom;
    private int age;
    private String email;

    public Personne(String nom, String prenom, int age, String email) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.email = email;
    }
    public void affiche() {
        System.out.println("Nom: " + nom);
        System.out.println("Prenom: " + prenom);
        System.out.println("Age: " + age);
        System.out.println("Email: " + email);
    }

}
