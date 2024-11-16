import java.util.ArrayList;
import java.util.Scanner;

public class GestionProduitsApp {
    public static void main(String[] args) {
        ArrayList<Produit> produits = new ArrayList<>();

        Produit produit1 = new Produit(123548,"phone",120.00);

        produits.add(produit1);
        produits.add(new Produit(124548,"laptop",1200.00));
        produits.add(new Produit(125548,"headset",20.00));

        //affichage de liste
        for (Produit p : produits) {
            System.out.println(p.getId());
            System.out.println(p.getNom());
            System.out.println(p.getPrix());
            System.out.println("");

        }
        //supposons que l indice est entrer par utilisateur
        int indice =0;
        // la supression par indice
        if(indice < produits.size()){
            produits.remove( indice );
        }

        //affichage de liste
        System.out.println("la liste apres la supression");
        for (Produit p : produits) {
            System.out.println(p.getId());
            System.out.println(p.getNom());
            System.out.println(p.getPrix());
            System.out.println("");

        }
        
        //la modification par indice

        if(indice < produits.size()){
            produits.get(indice).setNom("mouse");
            produits.get(indice).setId(12778);
            produits.get(indice).setPrix(100.00);
        }



        System.out.println("la liste apres la modification");

        //affichage de liste
        for (Produit p : produits) {
            System.out.println(p.getId());
            System.out.println(p.getNom());
            System.out.println(p.getPrix());
            System.out.println("");

        }

        Scanner sc = new Scanner(System.in);
        System.out.println("nom :");
        String nom = sc.nextLine();


        for (Produit p : produits) {
            if (p.getNom().equals(nom)) {
                System.out.println(p.getId());
                System.out.println(p.getNom());
                System.out.println(p.getPrix());
            }
        }


    }
}
