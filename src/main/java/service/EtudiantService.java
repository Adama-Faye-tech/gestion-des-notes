package com.ism.service;

import java.util.List;
import java.util.Optional;

import com.ism.domain.Etudiant;

public interface EtudiantService {
    boolean addEtudiant(Etudiant nouveau);
    List<Etudiant> findAll();
    Optional<Etudiant> findByMatricule(String matricule);
}
