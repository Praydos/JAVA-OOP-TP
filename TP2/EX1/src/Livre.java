public class Livre {
    private String isbn;
    private String titre;
    private Auteur auteur;

    public Livre(String isbn, String titre, Auteur auteur) {
        this.isbn = isbn;
        this.titre = titre;
        this.auteur = auteur;
    }

    public void affiche() {
        System.out.println("ISBN: " + isbn);
        System.out.println("Titre: " + titre);
        auteur.affiche();
    }

}
