package gsetiondesnotes.com.repository.memory;

import java.util.ArrayList;
import java.util.List;

import gsetiondesnotes.com.domain.Etudiant;
import gsetiondesnotes.com.repository.EtudiantRepository;

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
    
}