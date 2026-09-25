package com.ism;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.ism.domain.Etudiant;
import com.ism.dto.EtudiantCreateDto;
import com.ism.dto.EtudiantListeDto;
import com.ism.dto.NoteCreateDto;
import com.ism.dto.NoteListeDto;
import com.ism.factory.RepositoryFactory;
import com.ism.service.EtudiantService;
import com.ism.service.EtudiantServiceImpl;
import com.ism.service.MoyenneService;
import com.ism.service.MoyenneServiceImpl;
import com.ism.service.NoteService;
import com.ism.service.NoteServiceImpl;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        MoyenneService ms = new MoyenneServiceImpl();
        EtudiantService es = new EtudiantServiceImpl(
                RepositoryFactory.createEtudiantRepository(),
                RepositoryFactory.createNoteRepository(),
                ms
        );
        NoteService ns = new NoteServiceImpl(RepositoryFactory.createNoteRepository());

        String choix;
        do {
            System.out.println("1 - Créer étudiant");
            System.out.println("2 - Lister étudiants");
            System.out.println("3 - Ajouter note");
            System.out.println("4 - Lister les étudiants avec leurs notes et leur moyenne");
            System.out.println("0 - Quitter");
            System.out.print("Votre choix : ");
            choix = scanner.nextLine();

            switch (choix) {
                case "1":
                    System.out.print("Nom complet : ");
                    String nom = scanner.nextLine();
                    System.out.print("Matricule : ");
                    String matricule = scanner.nextLine();
                    System.out.print("Classe : ");
                    String classe = scanner.nextLine();

                    EtudiantCreateDto nouveau = new EtudiantCreateDto(nom, matricule, classe);
                    boolean success = es.addEtudiant(nouveau);
                    System.out.println(success ? "Succès" : "Erreur");
                    break;

                case "2":
                    List<Etudiant> etudiants = es.findAll();
                    for (Etudiant etudiant : etudiants) {
                        System.out.println(etudiant);
                    }
                    break;

                case "3":
                    System.out.print("Matricule : ");
                    String matriculeNote = scanner.nextLine();
                    Optional<Etudiant> etudiantOpt = es.findByMatricule(matriculeNote);
                    if (etudiantOpt.isEmpty()) {
                        System.out.println("Ce matricule ne correspond à aucun étudiant");
                    } else {
                        System.out.print("Matière : ");
                        String matiere = scanner.nextLine();
                        System.out.print("Valeur : ");
                        double valeur = Double.parseDouble(scanner.nextLine());
                        NoteCreateDto nouvelle = new NoteCreateDto(valeur, matiere, etudiantOpt.get());
                        boolean noteAdded = ns.addNote(nouvelle);
                        System.out.println(noteAdded ? "Note ajoutée" : "Erreur lors de l'ajout");
                    }
                    break;

                case "4":
                    List<EtudiantListeDto> etudiantsDto = es.findAllWithNotes();
                    for (EtudiantListeDto etudiantDto : etudiantsDto) {
                        System.out.println("Nom : " + etudiantDto.nomComplet());
                        System.out.println("Matricule : " + etudiantDto.matricule());
                        System.out.println("Moyenne : " + etudiantDto.moyenne());
                        for (NoteListeDto noteDto : etudiantDto.notes()) {
                            System.out.println("Matière : " + noteDto.matiere());
                            System.out.println("Note : " + noteDto.valeur());
                        }
                    }
                    break;

                case "0":
                    break;

                default:
                    System.out.println("Choix invalide");
                    break;
            }
        } while (!"0".equals(choix));

        scanner.close();
    }
}