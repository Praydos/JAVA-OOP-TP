package metier;

import java.util.List;
import java.util.Scanner;

public class ConsoleApp {
    private static IMetier metier;

    public static void main(String[] args) {
        metier = new MetierImpl();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("=== Menu ===");
            System.out.println("1. Add Professeur");
            System.out.println("2. Update Professeur");
            System.out.println("3. Delete Professeur");
            System.out.println("4. List All Professeurs");
            System.out.println("5. Search Professeur");
            System.out.println("6. Add Departement");
            System.out.println("7. Update Departement");
            System.out.println("8. Delete Departement");
            System.out.println("9. List All Departements");
            System.out.println("10. Assign Professeur to Departement");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            switch (choice) {
                case 1: // Add Professeur
                    addProfesseur(scanner);
                    break;
                case 2: // Update Professeur
                    updateProfesseur(scanner);
                    break;
                case 3: // Delete Professeur
                    deleteProfesseur(scanner);
                    break;
                case 4: // List All Professeurs
                    listProfesseurs();
                    break;
                case 5: // Search Professeur
                    searchProfesseur(scanner);
                    break;
                case 6: // Add Departement
                    addDepartement(scanner);
                    break;
                case 7: // Update Departement
                    updateDepartement(scanner);
                    break;
                case 8: // Delete Departement
                    deleteDepartement(scanner);
                    break;
                case 9: // List All Departements
                    listDepartements();
                    break;
                case 10: // Assign Professeur to Departement
                    assignProfesseurToDepartement(scanner);
                    break;
                case 0: // Exit
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    // Add Professeur
    private static void addProfesseur(Scanner scanner) {
        System.out.print("Enter id professeur: ");
        int id = scanner.nextInt();
        // Consume the leftover newline character
        scanner.nextLine(); // This is the fix!
        System.out.print("Enter Nom: ");
        String nom = scanner.nextLine();
        System.out.print("Enter Prenom: ");
        String prenom = scanner.nextLine();
        System.out.print("Enter CIN: ");
        String cin = scanner.nextLine();
        System.out.print("Enter Adresse: ");
        String adresse = scanner.nextLine();
        System.out.print("Enter Telephone: ");
        String telephone = scanner.nextLine();
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();
        System.out.print("Enter Date of Recruitment (YYYY-MM-DD): ");
        String dateRecrutement = scanner.nextLine();
        System.out.print("Enter Departement ID: ");
        int departementId = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        Professeur prof = new Professeur(id, nom, prenom, cin, adresse, telephone, email, dateRecrutement, departementId);
        metier.ajouterProfesseur(prof);
        System.out.println("Professeur added successfully!");
    }

    // Update Professeur
    private static void updateProfesseur(Scanner scanner) {
        System.out.print("Enter Professeur ID to update: ");
        int idProf = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Professeur prof = metier.getProfesseur(idProf);
        if (prof == null) {
            System.out.println("Professeur not found!");
            return;
        }

        System.out.print("Enter new Nom (leave blank to keep current): ");
        String nom = scanner.nextLine();
        if (!nom.isEmpty()) prof.setNom(nom);

        System.out.print("Enter new Prenom (leave blank to keep current): ");
        String prenom = scanner.nextLine();
        if (!prenom.isEmpty()) prof.setPrenom(prenom);

        System.out.print("Enter new Email (leave blank to keep current): ");
        String email = scanner.nextLine();
        if (!email.isEmpty()) prof.setEmail(email);

        metier.modifierProfesseur(prof);
        System.out.println("Professeur updated successfully!");
    }

    // Delete Professeur
    private static void deleteProfesseur(Scanner scanner) {
        System.out.print("Enter Professeur ID to delete: ");
        int idProf = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        metier.deleteProfesseur(idProf);
        System.out.println("Professeur deleted successfully!");
    }

    // List All Professeurs
    private static void listProfesseurs() {
        List<Professeur> professeurs = metier.getProfesseurs();
        for (Professeur prof : professeurs) {
            prof.afficherProf();
        }
    }

    // Search Professeur
    private static void searchProfesseur(Scanner scanner) {
        System.out.print("Enter keyword to search: ");
        int keyword = scanner.nextInt();
        Professeur professeur = metier.getProfesseur(keyword);
        professeur.afficherProf();

    }

    // Add Departement
    private static void addDepartement(Scanner scanner) {
        System.out.print("Enter Departement Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Departement id: ");
        int id = scanner.nextInt();
        Departement dept = new Departement(id, name);
        metier.ajouterDepartement(dept);
        System.out.println("Departement added successfully!");
    }

    // Update Departement
    private static void updateDepartement(Scanner scanner) {
        System.out.print("Enter Departement ID to update: ");
        int idDept = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Departement dept = metier.getDepartement(idDept);
        if (dept == null) {
            System.out.println("Departement not found!");
            return;
        }

        System.out.print("Enter new Name (leave blank to keep current): ");
        String name = scanner.nextLine();
        if (!name.isEmpty()) dept.setNom(name);

        metier.modifierDepartement(dept);
        System.out.println("Departement updated successfully!");
    }

    // Delete Departement
    private static void deleteDepartement(Scanner scanner) {
        System.out.print("Enter Departement ID to delete: ");
        int idDept = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        metier.deleteDepartement(idDept);
        System.out.println("Departement deleted successfully!");
    }

    // List All Departements
    private static void listDepartements() {
        List<Departement> departements = metier.getDepartements();
        for (Departement dept : departements) {
            dept.afficherDepartement();
            System.out.println("---------");
        }
    }

    // Assign Professeur to Departement
    private static void assignProfesseurToDepartement(Scanner scanner) {
        System.out.print("Enter Professeur ID: ");
        int idProf = scanner.nextInt();
        System.out.print("Enter Departement ID: ");
        int idDept = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        metier.assignProfesseurToDepartement(idProf, idDept);
        System.out.println("Professeur assigned to Departement successfully!");
    }
}
