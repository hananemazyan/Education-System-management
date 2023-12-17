package lst.tpjava.services;

import lst.tpjava.models.Departement;
import lst.tpjava.models.Enseignant;

import java.util.ArrayList;

/**
 * EnseignantServices provides a set of services to manage teachers (Enseignant) in the system.
 * It includes methods to add, update, delete, and retrieve teacher information.
 */
public class EnseignantServices {

    /**
     * Adds a new teacher to the system.
     * @param nom The last name of the teacher.
     * @param prenom The first name of the teacher.
     * @param email The email address of the teacher.
     * @param grade The grade or rank of the teacher.
     * @param dept The department to which the teacher belongs.
     * @return The newly created Enseignant object.
     */
    public static Enseignant addEns(String nom, String prenom, String email, String grade, Departement dept) {
        Enseignant enseignant = new Enseignant(nom, prenom, email, grade, dept);
        DB.enseignants.add(enseignant); 
        return enseignant;
    }

    /**
     * Updates the details of an existing teacher.
     * @param id The ID of the teacher to update.
     * @param nom The new last name of the teacher.
     * @param prenom The new first name of the teacher.
     * @param email The new email address of the teacher.
     * @param grade The new grade or rank of the teacher.
     * @param dept The new department of the teacher.
     * @return The updated Enseignant object, or null if not found.
     */
    public static Enseignant updateEns(int id, String nom, String prenom, String email, String grade, Departement dept) {
        for (Enseignant enseignant : DB.enseignants) {
            if (enseignant.getId() == id) {
                enseignant.setNom(nom);
                enseignant.setPrenom(prenom);
                enseignant.setEmail(email);
                enseignant.setGrade(grade);
                enseignant.setDept(dept); 
                return enseignant;
            }
        }
        return null; 
    }

    /**
     * Deletes a teacher by their ID.
     * @param id The ID of the teacher to delete.
     * @return The list of remaining teachers after deletion.
     */
    public static ArrayList<Enseignant> deleteEnsById(int id) {
        Enseignant enseignantToRemove = null;
        for (Enseignant enseignant : DB.enseignants) {
            if (enseignant.getId() == id) {
                enseignantToRemove = enseignant;
                break;
            }
        }
        if (enseignantToRemove != null) {
            DB.enseignants.remove(enseignantToRemove);
        }
        return DB.enseignants;
    }

    /**
     * Retrieves a teacher by their ID.
     * @param id The ID of the teacher.
     * @return The Enseignant object with the specified ID, or null if not found.
     */
    public static Enseignant getEnsById(int id) {
        for (Enseignant enseignant : DB.enseignants) {
            if (enseignant.getId() == id) return enseignant;
        }
        return null; 
    }

    /**
     * Retrieves all teachers in the system.
     * @return A list of all Enseignant objects.
     */
    public static ArrayList<Enseignant> getAllEns() {
        return DB.enseignants; 
    }
}