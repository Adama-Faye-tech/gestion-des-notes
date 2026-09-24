package com.ism.service;

import java.util.List;
import java.util.Optional;

import com.ism.domain.Etudiant;
import com.ism.dto.EtudiantCreateDto;
import com.ism.dto.EtudiantListeDto;

public interface EtudiantService {
    boolean addEtudiant(EtudiantCreateDto nouveau);
    List<Etudiant> findAll();
    List<EtudiantListeDto> findAllWithNotes();
    Optional<Etudiant> findByMatricule(String matricule);
}
