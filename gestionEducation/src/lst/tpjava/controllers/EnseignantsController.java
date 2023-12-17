package lst.tpjava.controllers;

import lst.tpjava.main.Main;
import lst.tpjava.models.Enseignant;
import lst.tpjava.services.EnseignantServices;

public class EnseignantsController {

    public static void showMenu() {
        System.out.println("-------------------------[ Enseignants ]---------------------------");
        System.out.println("1: Pour ajouter un enseignant");
        System.out.println("2: Pour afficher les enseignants");
        System.out.println("3: Pour modifier un enseignant");
        System.out.println("4: Pour supprimer un enseignant");
        System.out.println("0: Pour retourner au menu principal");

        int option = Main.getIntInput("Veuillez sélectionner une option : ");
        switch (option) {
            case 1:
                createEnseignant();
                break;
            case 2:
                showEnseignants();
                break;
            case 3:
                editEnseignant();
                break;
            case 4:
                destroyEnseignant();
                break;
            default:
                Main.showPrincipalMenu();
        }
    }

    public static void showEnseignants() {
        for (Enseignant enseignant : EnseignantServices.getAllEns()) {
            System.out.print("Id : " + enseignant.getId());
            System.out.print(" | Nom : " + enseignant.getNom() + " " + enseignant.getPrenom());
            System.out.print(" | Email : " + enseignant.getEmail());
            System.out.println("");
        }
    }

    public static void createEnseignant() {
        String nom = Main.getStringInput("Entrez le nom :");
        String prenom = Main.getStringInput("Entrez le prénom :");
        String email = Main.getStringInput("Entrez l'email :");

        EnseignantServices.addEns(nom, prenom, email, email, null);

        showEnseignants();
        showMenu();
    }

    public static void editEnseignant() {
        showEnseignants();
        int id = Main.getIntInput("Sélectionnez un enseignant par id :");
        String nom = Main.getStringInput("Entrez le nom :");
        String prenom = Main.getStringInput("Entrez le prénom :");
        String email = Main.getStringInput("Entrez l'email :");

        EnseignantServices.updateEns(id, nom, prenom, email, email, null);

        showEnseignants();
        showMenu();
    }

    public static void destroyEnseignant() {
        showEnseignants();
        int id = Main.getIntInput("Sélectionnez un enseignant par id :");
        EnseignantServices.deleteEnsById(id);
        showEnseignants();
    }
}

