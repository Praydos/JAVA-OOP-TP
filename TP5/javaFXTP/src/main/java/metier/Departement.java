package metier;

import java.util.ArrayList;

public class Departement {

    private String nom;
    private int id_deprat ;


    public Departement( int id_deprat,String nom) {
        this.nom = nom;
        this.id_deprat = id_deprat;

    }

    public int getId() {
        return id_deprat;
    }

    public void setId_deprat(int id_deprat) {
        this.id_deprat = id_deprat;
    }

    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }

    public void afficherDepartement() {
        System.out.println("Nom: " + nom);
        System.out.println("Id de deprat: " + id_deprat);
    }
}
