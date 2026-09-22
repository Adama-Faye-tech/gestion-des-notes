package com.ism.repository.memoire;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.ism.domain.Etudiant;
import com.ism.repository.EtudiantRepository;

public class EtudiantRepositoryMemory implements EtudiantRepository {
    private List<Etudiant> etudiants = new ArrayList<>();

    @Override
    public boolean insert(Etudiant nouveau) {
        etudiants.add(nouveau);
        return true;
    }

    @Override
    public List<Etudiant> selectAll() {
        return etudiants;
    }

    @Override
    public Optional<Etudiant> selectByMatricule(String matricule) {
        for (Etudiant etudiant : etudiants) {
            if (etudiant.getMatricule().equals(matricule)) {
                return Optional.of(etudiant);
            }
        }
        return Optional.empty();
    }
}
