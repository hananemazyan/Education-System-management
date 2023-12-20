package lst.tpjava.test;


import lst.tpjava.models.Enseignant;
import lst.tpjava.models.Departement;
import lst.tpjava.services.DepartementServices;


public class TestDepartementService {
        public static void main(String[] args) {
        Enseignant chef = new Enseignant(); // Remplissez les détails nécessaires de l'Enseignant
        chef.setId(1); // Utilisez un ID existant dans votre base de données

        Departement nouveauDepartement = DepartementServices.addDept("Informatique", chef);

        if (nouveauDepartement != null && nouveauDepartement.getId() > 0) {
            System.out.println("Département ajouté avec succès : " + nouveauDepartement);
        } else {
            System.out.println("Erreur lors de l'ajout du département");
        }
    }
}
