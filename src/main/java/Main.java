package com.ism;

import java.util.List;
import java.util.Scanner;

import com.ism.domain.Etudiant;
import com.ism.dto.EtudiantCreateDto;
import com.ism.factory.RepositoryFactory;
import com.ism.service.EtudiantService;
import com.ism.service.EtudiantServiceImpl;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        EtudiantService es = new EtudiantServiceImpl(RepositoryFactory.createEtudiantRepository());

        String choix;
        do {
            System.out.println("1 - Creer etudiant");
            System.out.println("2 - Lister etudiants");
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
                    System.out.println(success ? "Succes" : "Erreur");
                    break;

                case "2":
                    List<Etudiant> etudiants = es.findAll();
                    for (Etudiant etudiant : etudiants) {
                        System.out.println(etudiant);
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
