package com.ism.service;

import java.util.List;
import java.util.Optional;

import com.ism.domain.Etudiant;
import com.ism.dto.EtudiantCreateDto;
import com.ism.repository.EtudiantRepository;

public class EtudiantServiceImpl implements EtudiantService {
    private final EtudiantRepository repo;

    public EtudiantServiceImpl(EtudiantRepository repo) {
        this.repo = repo;
    }

    @Override
    public boolean addEtudiant(EtudiantCreateDto nouveau) {
        Etudiant newEtudiant = new Etudiant(nouveau.nomComplet, nouveau.matricule, nouveau.classe);
        return repo.insert(newEtudiant);
    }

    @Override
    public List<Etudiant> findAll() {
        return repo.selectAll();
    }

    @Override
    public Optional<Etudiant> findByMatricule(String matricule) {
        return repo.selectByMatricule(matricule);
    }
}
