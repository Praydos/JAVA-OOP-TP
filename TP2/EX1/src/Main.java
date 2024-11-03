
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Exercice 1\n");
        Adherent adherent = new Adherent("Chafik","Anas",21,"email@email.com",12534);
        Auteur auteur = new Auteur("dadas","aziz",45,"email@email.com",12535);
        Livre livre = new Livre("15-12-21145","Titre",auteur);

        System.out.println("les infos Adherent");
        adherent.affiche();
        System.out.println("\nles infos Auteur & livre");
        livre.affiche();


    }
}