package com.ism.repository.memoire;

import java.util.ArrayList;
import java.util.List;

import com.ism.domain.Etudiant;
import com.ism.domain.Note;

public class DatabaseMemory {
    public final List<Etudiant> etudiants = new ArrayList<>();
    public final List<Note> notes = new ArrayList<>();

    // singleton design pattern
    private static DatabaseMemory instance = null;

    private DatabaseMemory() {
    }

    public static DatabaseMemory getInstance() {
        if (instance == null) {
            instance = new DatabaseMemory();
        }
        return instance;
    }
}