package lst.tpjava.test;


import lst.tpjava.dao.DatabaseConnector;
import lst.tpjava.models.Departement;
import lst.tpjava.models.Enseignant;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



/**
 * The DepartementServices class provides services for managing departments (Departement) within the system.
 * It includes functionalities to add, update, delete, and retrieve department information.
 */
public class DeptService  {

        public static void registerJDBCDriver() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            // Handle the exception or exit the program if necessary
        }
    }

    /**
     * Adds a new department to the system.
     * @param intitule The name of the department.
     * @param chef Varargs parameter for the head(s) of the department (Enseignant). 
     *             The first Enseignant (if provided) is set as the department head.
     * @return The newly created Departement object.
     */

     public static Departement addDept(String intitule, Enseignant... chef) {
        String sql = "INSERT INTO departements (intitule, chef_id) VALUES (?, ?)";
        Departement departement = new Departement();
    
        try (Connection conn = DatabaseConnector.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
    
            pstmt.setString(1, intitule);
            pstmt.setInt(2, chef.length > 0 && chef[0] != null ? chef[0].getId() : null);
    
            int affectedRows = pstmt.executeUpdate();
    
            if (affectedRows > 0) {
                try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        departement.setId(generatedKeys.getInt(1));
                        departement.setIntitule(intitule);
                        if (chef.length > 0) {
                            departement.setChef(chef[0]);
                        }
                    } else {
                        throw new SQLException("La création du département a échoué, aucun ID obtenu.");
                    }
                }
            }
    
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
        return departement;
    }
    
       
       /*Departement departement = new Departement();
        departement.setIntitule(intitule);
        departement.setId(DB.getDeptId());
        if (chef.length > 0) {
            departement.setChef(chef[0]); 
        }
        DB.departements.add(departement); 

        return departement; */
    




    

    /**
     * Updates the details of an existing department.
     * @param id The ID of the department to update.
     * @param intitule The new name of the department.
     * @param chef Varargs parameter for the new department head. The first Enseignant (if provided) is set as the new head.
     * @return The updated Departement object, or a new Departement object if the specified ID is not found.
     */
    public static Departement updateDept(int id, String intitule, Enseignant... chef) {
        String sql = "UPDATE departements SET intitule = ?, chef_id = ? WHERE department_id = ?";

        try (Connection conn = DatabaseConnector.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
    
            pstmt.setString(1, intitule);
            pstmt.setInt(2, chef.length > 0 && chef[0] != null ? chef[0].getId() : null);
            pstmt.setInt(3, id);
    
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                // Si la mise à jour a réussi, retournez le département mis à jour
                return getDeptById(id); // Implémentez cette méthode pour récupérer le département mis à jour
            }
    
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
        return null; 
    }
    /**
     * Deletes a department by its ID.
     * @param id The ID of the department to delete.
     * @return The list of remaining departments after deletion.
     */
    public static boolean deleteDeptById(int id) {
        String sql = "DELETE FROM departements WHERE department_id = ?";
    
        try (Connection conn = DatabaseConnector.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
    
            pstmt.setInt(1, id);
    
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
    
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Retrieves a department by its ID.
     * @param id The ID of the department to find.
     * @return The Departement object with the specified ID, or a new Departement object if not found.
     */
    public static Departement getDeptById(int id) {
        String sql = "SELECT department_id, intitule, chef_id FROM departements WHERE department_id = ?";
    
        try (Connection conn = DatabaseConnector.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
    
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
    
            if (rs.next()) {
                Departement departement = new Departement();
                departement.setId(rs.getInt("department_id"));
                departement.setIntitule(rs.getString("intitule"));
                // Gérez le chef ici
                return departement;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; 
    }
    /**
     * Retrieves all departments.
     * @return A list of all departments.
     */
    public static ArrayList<Departement> getAllDept() {
        ArrayList<Departement> departements = new ArrayList<>();
        String sql = "SELECT department_id, intitule, chef_id FROM departements";
    
        try (Connection conn = DatabaseConnector.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
    
            while (rs.next()) {
                Departement departement = new Departement();
                departement.setId(rs.getInt("department_id"));
                departement.setIntitule(rs.getString("intitule"));
                // Gérez le chef ici
                departements.add(departement);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return departements;
    }

  
}
