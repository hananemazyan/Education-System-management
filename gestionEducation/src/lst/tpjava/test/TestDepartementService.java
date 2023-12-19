package lst.tpjava.test;


import lst.tpjava.controllers.DepartementsController;
import lst.tpjava.controllers.EnseignantsController;
import lst.tpjava.controllers.EtudiantsController;
import lst.tpjava.controllers.FilieresController;
import lst.tpjava.controllers.ModulesController;
import lst.tpjava.controllers.NoteController;

import lst.tpjava.models.Enseignant;
import lst.tpjava.models.Departement;
import lst.tpjava.services.DepartementServices;

import java.util.Scanner;

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
