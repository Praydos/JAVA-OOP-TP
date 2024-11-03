import java.util.List;

public class Categorie {
    private String nom;
    private String description;
    private List<Ordinateur> ordinateurs;

    public Categorie(String nom, String description, List<Ordinateur> ordinateurs) {
        this.nom = nom;
        this.description = description;
        this.ordinateurs = ordinateurs;
    }

    public List<Ordinateur> addOrdinateurs(Ordinateur ordinateur) {
        if (!ordinateurs.contains(ordinateur)) {
            ordinateurs.add(ordinateur);
        }
        return ordinateurs;
    }

    public List<Ordinateur> removeOrdinateurs(Ordinateur ordinateur) {
        if (ordinateurs.contains(ordinateur)) {
            ordinateurs.remove(ordinateur);
        }
        return ordinateurs;
    }

    public Ordinateur findOrdinateur(double prix) {
        for (Ordinateur ordinateur : ordinateurs) {
            if (ordinateur.getPrix() == prix) {
                return ordinateur;
            }
        }
        System.out.println("Erreur findOrdinateur");
        return null;
    }
}
