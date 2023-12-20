package lst.tpjava.controllers;

import lst.tpjava.main.Main;
import lst.tpjava.models.Module;
import lst.tpjava.services.EnseignantServices;
import lst.tpjava.services.FiliereServices;
import lst.tpjava.services.ModuleServices;

public class ModulesController {
    
    /**
     * Shows options for module management and handles user input.
     */
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
    
    /**
     * Displays all modules
     */
    public static void showModules() {
        for (Module module : ModuleServices.getAllModules()) {
            System.out.print("Id : " + module.getId());
            System.out.print(" | Intitulé : " + module.getIntitule());
            
            System.out.print(" | Enseignant : " + module.getChef().getNom()); 
            System.out.print(" | Filière : " + module.getFiliere().getIntitule()); 
    
            System.out.println("");
        }
    }


    /**
     * create new module.
     */
    public static void createModule() {
        String intitule = Main.getStringInput("Entrez l'intitulé du module :");

        EnseignantsController.showEnseignants();
        int id = Main.getIntInput("Sélectionnez un enseignant par id :");
        
        FilieresController.showFilieres();
        int filiereId = Main.getIntInput("Sélectionnez une filière par id :");

        ModuleServices.addModule(intitule, EnseignantServices.getEnsById(id), FiliereServices.getFiliereById(filiereId));

        showModules();
        showMenu();
    }

    /**
     * Updates an existing module based on user input.
     */
    public static void editModule() {
        showModules();
        int id = Main.getIntInput("Sélectionnez un module par id :");
        String intitule = Main.getStringInput("Entrez le nouvel intitulé du module :");

        EnseignantsController.showEnseignants();
        int ensId = Main.getIntInput("Sélectionnez un enseignant par id :");

        FilieresController.showFilieres();
        int filiereId = Main.getIntInput("Sélectionnez une filière par id :");

        ModuleServices.updateFiliere(id, intitule, EnseignantServices.getEnsById(ensId), FiliereServices.getFiliereById(filiereId));

        showModules();
        showMenu();
    }

    /**
     * Deletes a module based on its ID.
     */
    public static void destroyModule() {
        showModules();
        int id = Main.getIntInput("Sélectionnez un module par id :");
        ModuleServices.deleteModuleById(id);
        showModules();
    }
}
