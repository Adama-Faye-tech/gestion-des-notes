package gsetiondesnotes.com.repository;

import java.util.List;

import gsetiondesnotes.com.domain.Etudiant;

public interface EtudiantRepository {
    boolean insert(Etudiant nouveau);
    List<Etudiant> selectAll();
}