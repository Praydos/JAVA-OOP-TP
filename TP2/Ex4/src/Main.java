
import java.util.List;
import java.util.Scanner;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        MetierProduitImpl metier = new MetierProduitImpl();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Afficher la liste des produits.");
            System.out.println("2. Rechercher des produits par mot clé.");
            System.out.println("3. Ajouter un nouveau produit dans la liste.");
            System.out.println("4. Récupérer et afficher un produit par ID.");
            System.out.println("5. Supprimer un produit par id.");
            System.out.println("6. Quitter ce programme.");
            System.out.print("Choisissez une option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    List<Produit> produits = metier.getAll();
                    for (Produit p : produits) {
                        System.out.println(p);
                    }
                    break;
                case 2:
                    System.out.print("Entrez le mot clé: ");
                    String motCle = scanner.nextLine();
                    List<Produit> produitsTrouves = metier.findByNom(motCle);
                    for (Produit p : produitsTrouves) {
                        System.out.println(p);
                    }
                    break;
                case 3:
                    System.out.print("Entrez l'id: ");
                    String id = scanner.nextLine(); // Changed to String

                    System.out.print("Entrez le nom: ");
                    String nom = scanner.nextLine();

                    System.out.print("Entrez la marque: ");
                    String marque = scanner.nextLine();

                    System.out.print("Entrez le prix: ");
                    double prix = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline

                    System.out.print("Entrez la description: ");
                    String description = scanner.nextLine();

                    System.out.print("Entrez le nombre en stock: ");
                    int nombreEnStock = scanner.nextInt();

                    Produit p = new Produit(nom,id,description , prix, nombreEnStock,marque);
                    metier.add(p);
                    System.out.println("Produit ajouté.");
                    break;
                case 4:
                    System.out.print("Entrez l'id du produit: ");
                    String idRecherche = scanner.nextLine(); // Changed to String
                    Produit produit = metier.findById(idRecherche);
                    if (produit != null) {
                        System.out.println(produit);
                    } else {
                        System.out.println("Produit non trouvé.");
                    }
                    break;
                case 5:
                    System.out.print("Entrez l'id du produit à supprimer: ");
                    String idSuppression = scanner.nextLine(); // Changed to String
                    metier.delete(idSuppression);
                    System.out.println("Produit supprimé.");
                    break;
                case 6:
                    System.out.println("Au revoir!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Option invalide.");
            }
        }
    }
}