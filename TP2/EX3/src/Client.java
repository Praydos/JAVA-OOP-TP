import java.util.ArrayList;
import java.util.List;

public class Client {
    private String nom;
    private String prenom;
    private String adresse;
    private String telephone;
    private String email;
    private List<Commande> commandes;

    public Client(String nom, String prenom, String adresse, String telephone, String email) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.telephone = telephone;
        this.email = email;
        commandes = new ArrayList<Commande>();
    }

    public List<Commande> addCommandes(Commande commande) {
        if(!commandes.contains(commande)){
            commandes.add(commande);
        }
        return commandes;
    }

    public List<Commande> removeCommandes(Commande commande) {
        if(commandes.contains(commande)){
            commandes.remove(commande);
        }
        return commandes;
    }

}
