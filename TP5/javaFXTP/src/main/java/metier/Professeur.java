package metier;

import java.util.Date;

public class Professeur {
    private String nom;
    private String prenom;
    private String adresse;
    private String email;
    private String telephone;
    private String cin;
    private int id;
    private String dateRec;
    private int idDep;

    public Professeur( int id,String nom, String prenom, String adresse, String email, String telephone, String cin, String dateRec, int idDep) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.email = email;
        this.telephone = telephone;
        this.cin = cin;
        this.id = id;
        this.dateRec = dateRec;
        this.idDep = idDep;
    }

    public Professeur(){};

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public String getAdresse() {
        return adresse;
    }
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getTelephone() {
        return telephone;
    }
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    public String getCin() {
        return cin;
    }
    public void setCin(String cin) {
        this.cin = cin;
    }
    public String getDateRec() {
        return dateRec;
    }
    public void setDateRec(String dateRec) {
        this.dateRec = dateRec;
    }

    public int getIdDep() {
        return idDep;
    }
    public void setIdDep(int idDep) {
        this.idDep = idDep;
    }

    public void afficherProf(){
        System.out.println("Nom: " + nom);
        System.out.println("Prenom: " + prenom);
        System.out.println("Adresse: " + adresse);
        System.out.println("Email: " + email);
        System.out.println("Telephone: " + telephone);
        System.out.println("Cin: " + cin);
        System.out.println("DateRec: " + dateRec);


    }

}
