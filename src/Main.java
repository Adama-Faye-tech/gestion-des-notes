package gsetiondesnotes.com;

import gsetiondesnotes.com.domain.Etudiant;
import gsetiondesnotes.com.repository.EtudiantRepository;
import gsetiondesnotes.com.repository.memory.EtudiantRepositoryMemory;
import gsetiondesnotes.com.service.EtudiantService;
import gsetiondesnotes.com.service.EtudiantServiceImpl;

public class Main {
    public static void main(String[] args) {
        // FACTORY
        EtudiantRepository erm = new EtudiantRepositoryMemory();
        EtudiantService es = new EtudiantServiceImpl(erm);

        String choix;
        do {
            System.out.println("1 - Créer étudiant");
            System.out.println("2 - Lister étudiants");
            System.err.println("0 - Quitter");
            choix = System.console().readLine("Votre choix : ");

            switch (choix) {
                case "1":
                    String nom = System.console().readLine("Nom complet : ");
                    String matricule = System.console().readLine("Matricule : ");
                    String classe = System.console().readLine("Classe : ");
                    Etudiant nouveau = new Etudiant(nom, matricule, classe);
                    boolean success = es.addEtudiant(nouveau);
                    if (success) {
                        System.out.println("Succès");
                    } else {
                        System.out.println("Erreur");
                    }
                    break;

                case "2":
                    var etudiants = es.findAll();
                    System.out.println(etudiants);
                    break;

                case "0":
                    
                    break;
            
                default:
                    break;
            }
        } while (!choix.equals("0"));
    }
}