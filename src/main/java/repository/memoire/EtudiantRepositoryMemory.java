package com.ism.repository.memoire;

import java.util.List;
import java.util.Optional;

import com.ism.domain.Etudiant;
import com.ism.repository.EtudiantRepository;

public class EtudiantRepositoryMemory implements EtudiantRepository {
    private DatabaseMemory dbm;

    public EtudiantRepositoryMemory(DatabaseMemory dbm) {
        this.dbm = dbm;
    }

    @Override
    public boolean insert(Etudiant nouveau) {
        dbm.etudiants.add(nouveau);
        return true;
    }

    @Override
    public List<Etudiant> selectAll() {
        return dbm.etudiants;
    }

    @Override
    public Optional<Etudiant> selectByMatricule(String matricule) {
        for (Etudiant etudiant : dbm.etudiants) {
            if (etudiant.getMatricule().equals(matricule)) {
                return Optional.of(etudiant);
            }
        }
        return Optional.empty();
    }
}