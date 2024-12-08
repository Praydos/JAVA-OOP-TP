import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MetierProduitImpl metierProduit = new MetierProduitImpl("produits.dat");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Afficher la liste des produits.");
            System.out.println("2. Rechercher un produit par son nom.");
            System.out.println("3. Ajouter un nouveau produit.");
            System.out.println("4. Supprimer un produit par nom.");
            System.out.println("5. Sauvegarder les produits.");
            System.out.println("6. Quitter.");
            int choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1:
                    metierProduit.getAll().forEach(System.out::println);
                    break;
                case 2:
                    System.out.print("Entrez le nom du produit : ");
                    String nom = scanner.nextLine();
                    System.out.println(metierProduit.findByNom(nom));
                    break;
                case 3:
                    System.out.print("Nom : ");
                    String name = scanner.nextLine();
                    System.out.print("Marque : ");
                    String marque = scanner.nextLine();
                    System.out.print("Prix : ");
                    double prix = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Description : ");
                    String desc = scanner.nextLine();
                    System.out.print("Stock : ");
                    int stock = scanner.nextInt();
                    scanner.nextLine();
                    metierProduit.add(new Produit(name, marque, stock,prix, desc ));
                    break;
                case 4:
                    System.out.print("Nom : ");
                    String nomSupp = scanner.nextLine();
                    metierProduit.delete(nomSupp);
                    break;
                case 5:
                    metierProduit.saveAll();
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.out.println("Choix invalide.");
            }
        }
    }
}
