package lst.tpjava.controllers;

import lst.tpjava.main.Main;
import lst.tpjava.models.Etudiant;
import lst.tpjava.models.Filiere;
import lst.tpjava.models.Note;
import lst.tpjava.services.DB;
import lst.tpjava.services.NoteService;

import java.util.ArrayList;

/**
 * NoteController manages user interactions for note operations.
 */
public class NoteController {

    /**
     * Shows options for note management and handles user input.
     */
    public static void showMenu() {
        System.out.println("---- Note Management ----");
        System.out.println("1: Add a note");
        System.out.println("2: Update a note");
        System.out.println("3: Delete a note");
        System.out.println("4: View all notes");
        System.out.println("0: Return to main menu");

        int option = Main.getIntInput("Select an option: ");

        switch (option) {
            case 1:
                addNote();
                break;
            case 2:
                updateNote();
                break;
            case 3:
                deleteNote();
                break;
            case 4:
                viewAllNotes();
                break;
            case 0:
                // Return to main menu or exit
                break;
            default:
                System.out.println("Invalid option.");
                break;
        }
    }

    private static void addNote() {
        // Get user input for adding a note
        float grade = Main.getFloatInput("Enter the grade: ");
        int studentId = Main.getIntInput("Enter student ID: ");
        int filiereId = Main.getIntInput("Enter filiere ID: ");

        // Retrieve the student and filiere based on the IDs (You need to implement this logic)
        Etudiant etudiant = getEtudiantById(studentId);
        Filiere filiere = getFiliereById(filiereId);

        if (etudiant != null && filiere != null) {
            Note note = NoteService.addNote(grade, etudiant, filiere);
            System.out.println("Note added: " + note);
        } else {
            System.out.println("Student or filiere not found.");
        }
    }

    private static void updateNote() {
        // Get user input for updating a note
        int noteId = Main.getIntInput("Enter note ID: ");
        float newGrade = Main.getFloatInput("Enter new grade: ");

        Note updatedNote = NoteService.updateNote(noteId, newGrade);
        if (updatedNote != null) {
            System.out.println("Note updated: " + updatedNote);
        } else {
            System.out.println("Note not found.");
        }
    }

    private static void deleteNote() {
        int noteId = Main.getIntInput("Enter note ID to delete: ");
        NoteService.deleteNoteById(noteId);
        System.out.println("Note deleted.");
    }

    private static void viewAllNotes() {
        ArrayList<Note> notes = NoteService.getAllNotes();
        for (Note note : notes) {
            System.out.println(note);
        }
    }

private static Etudiant getEtudiantById(int studentId) {
    for (Etudiant etudiant : DB.etudiants) {
        if (etudiant.getId() == studentId) {
            return etudiant;
        }
    
    }
    return null; 
}

private static Filiere getFiliereById(int filiereId) {
    for (Filiere filiere : DB.filieres) {
        if (filiere.getId() == filiereId) {
            return filiere;
        }
    }
    return null; 
}}
