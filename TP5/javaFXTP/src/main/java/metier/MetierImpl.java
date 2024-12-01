package metier;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MetierImpl implements IMetier {
    private Connection connection;

    public MetierImpl() {
        this.connection = SignletonConnectionDB.getConnexion();
    }


    // CRUD for Professeur
    //add a professeor
    @Override
    public void ajouterProfesseur(Professeur prof) {
        try {
            String query = "INSERT INTO Professeur (id_prof ,nom, prenom, cin, address, telephone, email, date_recrutement, id_deprat) VALUES (?, ?, ?, ?, ?, ?, ?, ?,?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, prof.getId());
            ps.setString(2, prof.getNom());
            ps.setString(3, prof.getPrenom());
            ps.setString(4, prof.getCin());
            ps.setString(5, prof.getAdresse());
            ps.setString(6, prof.getTelephone());
            ps.setString(7, prof.getEmail());
            ps.setString(8, prof.getDateRec());
            ps.setInt(9, prof.getIdDep());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //update a professor infos
    @Override
    public void modifierProfesseur(Professeur prof) {
        try {
            String query = "UPDATE Professeur SET  nom=?, prenom=?, cin=?, address=?, telephone=?, email=?, date_recrutement=?, id_deprat=? WHERE id_prof=?";
            PreparedStatement ps = connection.prepareStatement(query);
            // Set the values for the query
            ps.setString(1, prof.getNom());           // Nom
            ps.setString(2, prof.getPrenom());        // Prenom
            ps.setString(3, prof.getCin());           // CIN
            ps.setString(4, prof.getAdresse());       // Adresse
            ps.setString(5, prof.getTelephone());     // Telephone
            ps.setString(6, prof.getEmail());         // Email
            ps.setString(7, prof.getDateRec());       // Date of recruitment
            ps.setInt(8, prof.getIdDep());            // Department ID
            ps.setInt(9, prof.getId());               // ID of the professor (WHERE clause)
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //delete a professor by id
    @Override
    public void deleteProfesseur(int id_prof) {
        try {
            String query = "DELETE FROM Professeur WHERE id_prof=?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id_prof);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //search for a professor by id
    @Override
    public Professeur getProfesseur(int id_prof) {
        Professeur prof = null;
        try {
            String query = "SELECT * FROM Professeur WHERE id_prof=?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id_prof);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                prof = new Professeur(
                        rs.getInt("id_prof"),
                        rs.getString("nom"),
                        rs.getString("prenom"),
                        rs.getString("address"),
                        rs.getString("email"),
                        rs.getString("telephone"),
                        rs.getString("cin"),
                        rs.getString("date_recrutement"),
                        rs.getInt("id_deprat")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return prof;
    }
//
//    @Override
//    public List<Professeur> searchProfesseur(String keyword) {
//        List<Professeur> professeurs = new ArrayList<>();
//        try {
//            String query = "SELECT * FROM Professeur WHERE nom LIKE ? OR prenom LIKE ?";
//            PreparedStatement ps = connection.prepareStatement(query);
//            ps.setString(1, "%" + keyword + "%");
//            ps.setString(2, "%" + keyword + "%");
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                Professeur prof = new Professeur(
//                        rs.getInt("id_prof"),
//                        rs.getString("nom"),
//                        rs.getString("prenom"),
//                        rs.getString("cin"),
//                        rs.getString("adresse"),
//                        rs.getString("telephone"),
//                        rs.getString("email"),
//                        rs.getDate("date_recrutement").toLocalDate(),
//                        rs.getInt("id_deprat")
//                );
//                professeurs.add(prof);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return professeurs;
//    }
    //get all the professors
    @Override
    public List<Professeur> getProfesseurs() {
        List<Professeur> professeurs = new ArrayList<>();
        try {
            String query = "SELECT * FROM Professeur";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Professeur prof = new Professeur(
                        rs.getInt("id_prof"),
                        rs.getString("nom"),
                        rs.getString("prenom"),
                        rs.getString("cin"),
                        rs.getString("address"),
                        rs.getString("telephone"),
                        rs.getString("email"),
                        rs.getString("date_recrutement"),
                        rs.getInt("id_deprat")
                );
                professeurs.add(prof);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return professeurs;
    }



    // CRUD for Departement
    @Override
    public void ajouterDepartement(Departement dept) {
        try {
            String query = "INSERT INTO Departement (id_deprat,nom) VALUES (?,?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, dept.getId());
            ps.setString(2, dept.getNom());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void modifierDepartement(Departement dept) {
        try {
            String query = "UPDATE Departement SET nom=? WHERE id_deprat=?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, dept.getId());
            ps.setString(2, dept.getNom());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteDepartement(int id_deprat) {
        try {
            String query = "DELETE FROM Departement WHERE id_deprat=?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id_deprat);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Departement getDepartement(int id_deprat) {
        Departement dept = null;
        try {
            String query = "SELECT * FROM Departement WHERE id_deprat=?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id_deprat);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                dept = new Departement(
                        rs.getInt("id_deprat"),
                        rs.getString("nom")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dept;
    }

    @Override
    public List<Departement> getDepartements() {
        List<Departement> departements = new ArrayList<>();
        try {
            String query = "SELECT * FROM Departement";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Departement dept = new Departement(
                        rs.getInt("id_deprat"),
                        rs.getString("nom")
                );
                departements.add(dept);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return departements;
    }

    // Additional operations
//    @Override
//    public List<Professeur> getProfesseursByDepartement(int id_deprat) {
//        List<Professeur> professeurs = new ArrayList<>();
//        try {
//            String query = "SELECT * FROM Professeur WHERE id_deprat=?";
//            PreparedStatement ps = connection.prepareStatement(query);
//            ps.setInt(1, id_deprat);
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                Professeur prof = new Professeur(
//                        rs.getInt("id_prof"),
//                        rs.getString("nom"),
//                        rs.getString("prenom"),
//                        rs.getString("cin"),
//                        rs.getString("adresse"),
//                        rs.getString("telephone"),
//                        rs.getString("email"),
//                        rs.getDate("date_recrutement").toLocalDate(),
//                        rs.getInt("id_deprat")
//                );
//                professeurs.add(prof);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return professeurs;
//    }

    @Override
    public void assignProfesseurToDepartement(int id_prof, int id_deprat) {
        try {
            String query = "UPDATE Professeur SET id_deprat=? WHERE id_prof=?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id_deprat);
            ps.setInt(2, id_prof);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
