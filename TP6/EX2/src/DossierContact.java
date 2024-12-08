import java.io.*;
import java.util.*;

public class DossierContact {
    private Map<String, String> contacts;
    private final String dossierPath;

    public DossierContact(String dossierPath) {
        this.dossierPath = dossierPath;
        this.contacts = new HashMap<>();
        chargerContacts();
    }

    // Charger les contacts depuis le dossier
    private void chargerContacts() {
        File dossier = new File(dossierPath);
        if (!dossier.exists()) {
            dossier.mkdirs();
        }
        File[] fichiers = dossier.listFiles();
        if (fichiers != null) {
            for (File fichier : fichiers) {
                try (BufferedReader reader = new BufferedReader(new FileReader(fichier))) {
                    String numero = reader.readLine();
                    contacts.put(fichier.getName(), numero);
                } catch (IOException e) {
                    System.out.println("Erreur lors de la lecture du fichier : " + fichier.getName());
                }
            }
        }
    }

    // Sauvegarder un contact dans un fichier
    private void sauvegarderContact(String nom, String numero) {
        File fichier = new File(dossierPath, nom);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fichier))) {
            writer.write(numero);
        } catch (IOException e) {
            System.out.println("Erreur lors de la sauvegarde du contact : " + nom);
        }
    }

    // Supprimer un fichier de contact
    private void supprimerFichierContact(String nom) {
        File fichier = new File(dossierPath, nom);
        if (fichier.exists()) {
            fichier.delete();
        }
    }

    // Ajouter un contact
    public void ajouterContact(String nom, String numero) {
        if (contacts.containsKey(nom)) {
            System.out.println("Un contact avec ce nom existe déjà !");
        } else {
            contacts.put(nom, numero);
            sauvegarderContact(nom, numero);
        }
    }

    // Supprimer un contact
    public void supprimerContact(String nom) {
        if (contacts.remove(nom) != null) {
            supprimerFichierContact(nom);
        } else {
            System.out.println("Contact non trouvé !");
        }
    }

    // Rechercher un contact
    public String rechercherContact(String nom) {
        return contacts.get(nom);
    }

    // Modifier un numéro de téléphone
    public void changerNumero(String nom, String nouveauNumero) {
        if (contacts.containsKey(nom)) {
            contacts.put(nom, nouveauNumero);
            sauvegarderContact(nom, nouveauNumero);
        } else {
            System.out.println("Contact non trouvé !");
        }
    }
}
