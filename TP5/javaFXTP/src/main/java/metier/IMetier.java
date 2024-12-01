package metier;


import java.util.List;

public interface IMetier {
    //gere les professeurs
    List<Professeur> getProfesseurs();
    Professeur getProfesseur(int id);
    void ajouterProfesseur(Professeur p);
    void modifierProfesseur(Professeur p);
    void deleteProfesseur(int id);


    //gere les departement
    List<Departement> getDepartements();
    Departement getDepartement(int id);
    void ajouterDepartement(Departement d);
    void modifierDepartement(Departement d);
    void deleteDepartement(int id);
   // List<Professeur> listerProfesseursParDepartement(int idDepartement);
    public void assignProfesseurToDepartement(int id_prof, int id_deprat);


}
