package gsetiondesnotes.com.service;

import java.util.List;

import gsetiondesnotes.com.domain.Etudiant;

public interface EtudiantService {
    boolean addEtudiant(Etudiant nouveau);
    List<Etudiant> findAll();
}