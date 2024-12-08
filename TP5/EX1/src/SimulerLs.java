import java.io.File;

public class SimulerLs {

    public static void main(String[] args) {
        // Saisie du chemin complet du répertoire
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.print("Entrez le chemin du répertoire : ");
        String cheminRepertoire = scanner.nextLine();
        scanner.close();

        // Création de l'objet File pour le répertoire
        File repertoire = new File(cheminRepertoire);

        // Vérification si le chemin est un répertoire valide
        if (!repertoire.exists() || !repertoire.isDirectory()) {
            System.out.println("Le chemin saisi n'est pas un répertoire valide.");
            return;
        }

        // Lister les fichiers et répertoires de manière récursive
        listerFichiersEtRepertoires(repertoire, "");
    }

    public static void listerFichiersEtRepertoires(File fichierOuRepertoire, String indentation) {
        // Affichage du fichier ou répertoire courant
        afficherInformations(fichierOuRepertoire, indentation);

        // Si c'est un répertoire, explorer son contenu récursivement
        if (fichierOuRepertoire.isDirectory()) {
            File[] contenu = fichierOuRepertoire.listFiles();
            if (contenu != null) {
                for (File file : contenu) {
                    listerFichiersEtRepertoires(file, indentation + "   ");
                }
            }
        }
    }

    public static void afficherInformations(File fichier, String indentation) {
        // Détermination du type : <DIR> ou <FILE>
        String type = fichier.isDirectory() ? "<DIR>" : "<FILE>";

        // Détermination des permissions : lecture, écriture, caché
        String permissions = "";
        permissions += fichier.canRead() ? "r" : "-";
        permissions += fichier.canWrite() ? "w" : "-";
        permissions += fichier.isHidden() ? "h" : "-";

        // Affichage des informations
        System.out.printf("%s%s %s %s%n", indentation, fichier.getAbsolutePath(), type, permissions);
    }
}
