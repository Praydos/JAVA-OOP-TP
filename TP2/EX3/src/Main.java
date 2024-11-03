import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Ordinateur ordinateur1= new Ordinateur("dell",1500,"desc1",20);
        Ordinateur ordinateur2= new Ordinateur("dell",1600,"desc2",20);
        Ordinateur ordinateur3= new Ordinateur("dell",1700,"desc3",20);

        List<Ordinateur> ordinateurs = new ArrayList<Ordinateur>();
        ordinateurs.add(ordinateur1);
        ordinateurs.add(ordinateur2);
        ordinateurs.add(ordinateur3);

        Categorie categorie = new Categorie("categorie1","desc-categorie",ordinateurs);

        Client client = new Client("dadas","aziz","address1","+2120754","mail@email.com");

        Commande commande = new Commande("15-16",client,"2020-20-10","bon");

        LigneCommande ligneCommande = new LigneCommande(10,commande,ordinateur1);
        LigneCommande ligneCommande2 = new LigneCommande(10,commande,ordinateur2);
        LigneCommande ligneCommande3 = new LigneCommande(10,commande,ordinateur3);

        List<LigneCommande> LigneCommandes = Arrays.asList(ligneCommande,ligneCommande2,ligneCommande3);




    }
}