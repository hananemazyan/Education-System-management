package lst.tpjava.controllers;

import lst.tpjava.main.Main;
import lst.tpjava.models.Enseignant;
import lst.tpjava.models.Filiere;
import lst.tpjava.models.Module;
import lst.tpjava.services.EnseignantServices;
import lst.tpjava.services.FiliereServices;
import lst.tpjava.services.ModuleServices;

public class ModulesController {

    public static void showMenu() {
        System.out.println("-------------------------[ Modules ]---------------------------");
        System.out.println("1: Pour ajouter un module");
        System.out.println("2: Pour afficher les modules");
        System.out.println("3: Pour modifier un module");
        System.out.println("4: Pour supprimer un module");
        System.out.println("0: Pour retourner au menu principal");

        int option = Main.getIntInput("Veuillez sélectionner une option : ");
        switch (option) {
            case 1:
                createModule();
                break;
            case 2:
                showModules();
                break;
            case 3:
                editModule();
                break;
            case 4:
                destroyModule();
                break;
            default:
                Main.showPrincipalMenu();
        }
    }

    public static void showModules() {
        for (Module module : ModuleServices.getAllModules()) {
            System.out.print("Id : " + module.getId());
            System.out.print(" | Intitulé : " + module.getIntitule());
            // Add more fields if needed
            System.out.println("");
        }
    }

    public static void createModule() {
        String intitule = Main.getStringInput("Entrez l'intitulé du module :");

        EnseignantsController.showEnseignants();
        int id = Main.getIntInput("Sélectionnez un enseignant par id :");

        DepartementsController.showDepartements();
        int depId = Main.getIntInput("Sélectionnez un département par id :");

        // You may want to add more information or validation here based on your application logic

        FilieresController.showFilieres();
        int filiereId = Main.getIntInput("Sélectionnez une filière par id :");

        ModuleServices.addModule(intitule, EnseignantServices.getEnsById(id), FiliereServices.getFiliereById(filiereId));

        showModules();
        showMenu();
    }

    public static void editModule() {
        showModules();
        int id = Main.getIntInput("Sélectionnez un module par id :");
        String intitule = Main.getStringInput("Entrez le nouvel intitulé du module :");

        EnseignantsController.showEnseignants();
        int ensId = Main.getIntInput("Sélectionnez un enseignant par id :");

        DepartementsController.showDepartements();
        int depId = Main.getIntInput("Sélectionnez un département par id :");
        FilieresController.showFilieres();
        int filiereId = Main.getIntInput("Sélectionnez une filière par id :");

        ModuleServices.updateFiliere(id, intitule, EnseignantServices.getEnsById(ensId), FiliereServices.getFiliereById(filiereId));

        showModules();
        showMenu();
    }

    public static void destroyModule() {
        showModules();
        int id = Main.getIntInput("Sélectionnez un module par id :");
        ModuleServices.deleteModuleById(id);
        showModules();
    }
}
