package com.ism.service;

import java.util.List;
import java.util.Optional;

import com.ism.domain.Etudiant;
import com.ism.repository.EtudiantRepository;

public class EtudiantServiceImpl implements EtudiantService {
    private final EtudiantRepository repo;

    public EtudiantServiceImpl(EtudiantRepository repo) {
        this.repo = repo;
    }

    @Override
    public boolean addEtudiant(Etudiant nouveau) {
        return repo.insert(nouveau);
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
