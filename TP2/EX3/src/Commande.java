public class Commande {
    private String ref;
    private Client client;
    private String date;
    private String etat;

    public Commande(String ref, Client client, String date, String etat) {
        this.ref = ref;
        this.client = client;
        this.date = date;
        this.etat = etat;

    }


}
