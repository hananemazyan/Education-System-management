package lst.tpjava.services;

import lst.tpjava.models.Departement;
import lst.tpjava.models.Enseignant;

import java.util.ArrayList;

/**
 * The DepartementServices class provides services for managing departments (Departement) within the system.
 * It includes functionalities to add, update, delete, and retrieve department information.
 */
public class DepartementServices {

    /**
     * Adds a new department to the system.
     * @param intitule The name of the department.
     * @param chef Varargs parameter for the head(s) of the department (Enseignant). 
     *             The first Enseignant (if provided) is set as the department head.
     * @return The newly created Departement object.
     */
    public static Departement addDept(String intitule, Enseignant... chef) {
        Departement departement = new Departement();
        departement.setIntitule(intitule);
        departement.setId(DB.getDeptId());
        if (chef.length > 0) {
            departement.setChef(chef[0]); 
        }
        DB.departements.add(departement); 

        return departement;
    }

    /**
     * Updates the details of an existing department.
     * @param id The ID of the department to update.
     * @param intitule The new name of the department.
     * @param chef Varargs parameter for the new department head. The first Enseignant (if provided) is set as the new head.
     * @return The updated Departement object, or a new Departement object if the specified ID is not found.
     */
    public static Departement updateDept(int id, String intitule, Enseignant... chef) {
        for (Departement departement : DB.departements) {
            if (departement.getId() == id) {
                departement.setIntitule(intitule);
                if (chef.length > 0) {
                    departement.setChef(chef[0]);
                }
                return departement;
            }
        }
        return new Departement(); // Consider returning null or handling this case differently.
    }

    /**
     * Deletes a department by its ID.
     * @param id The ID of the department to delete.
     * @return The list of remaining departments after deletion.
     */
    public static ArrayList<Departement> deleteDeptById(int id) {
        DB.departements.remove(getDeptById(id)); 
        return DB.departements;
    }

    /**
     * Retrieves a department by its ID.
     * @param id The ID of the department to find.
     * @return The Departement object with the specified ID, or a new Departement object if not found.
     */
    public static Departement getDeptById(int id) {
        for (Departement departement : DB.departements) {
            if (departement.getId() == id) return departement;
        }
        return new Departement(); 
    }

    /**
     * Retrieves all departments.
     * @return A list of all departments.
     */
    public static ArrayList<Departement> getAllDept() {
        return DB.departements; 
    }
}
