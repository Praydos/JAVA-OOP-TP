import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DossierContact dossierContact = new DossierContact("contacts");

        boolean quitter = false;
        while (!quitter) {
            System.out.println("\nMenu :");
            System.out.println("1. Rechercher un numéro de téléphone.");
            System.out.println("2. Ajouter un nouveau contact.");
            System.out.println("3. Supprimer un contact.");
            System.out.println("4. Changer le numéro de téléphone d’un contact.");
            System.out.println("5. Quitter ce programme.");
            System.out.print("Choisissez une option : ");
            int choix = scanner.nextInt();
            scanner.nextLine(); // Consommer la nouvelle ligne

            switch (choix) {
                case 1:
                    System.out.print("Entrez le nom du contact à rechercher : ");
                    String nomRecherche = scanner.nextLine();
                    String numero = dossierContact.rechercherContact(nomRecherche);
                    if (numero != null) {
                        System.out.println("Numéro de " + nomRecherche + " : " + numero);
                    } else {
                        System.out.println("Contact non trouvé !");
                    }
                    break;

                case 2:
                    System.out.print("Entrez le nom du nouveau contact : ");
                    String nouveauNom = scanner.nextLine();
                    System.out.print("Entrez le numéro de téléphone : ");
                    String nouveauNumero = scanner.nextLine();
                    dossierContact.ajouterContact(nouveauNom, nouveauNumero);
                    break;

                case 3:
                    System.out.print("Entrez le nom du contact à supprimer : ");
                    String nomSupprimer = scanner.nextLine();
                    dossierContact.supprimerContact(nomSupprimer);
                    break;

                case 4:
                    System.out.print("Entrez le nom du contact à modifier : ");
                    String nomModifier = scanner.nextLine();
                    System.out.print("Entrez le nouveau numéro de téléphone : ");
                    String nouveauNumeroModif = scanner.nextLine();
                    dossierContact.changerNumero(nomModifier, nouveauNumeroModif);
                    break;

                case 5:
                    quitter = true;
                    System.out.println("Au revoir !");
                    break;

                default:
                    System.out.println("Choix invalide !");
            }
        }

        scanner.close();
    }
}
