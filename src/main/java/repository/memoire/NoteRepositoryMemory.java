package com.ism.repository.memoire;

import java.util.ArrayList;
import java.util.List;

import com.ism.domain.Note;
import com.ism.repository.NoteRepository;

public class NoteRepositoryMemory implements NoteRepository {
    private DatabaseMemory dbm;

    public NoteRepositoryMemory(DatabaseMemory dbm) {
        this.dbm = dbm;
    }

    @Override
    public boolean insert(Note nouveau) {
        dbm.notes.add(nouveau);
        return true;
    }

    @Override
    public List<Note> selectByEtudiant(String matricule) {
        List<Note> notesByEtudiant = new ArrayList<>();
        for (Note note : dbm.notes) {
            if (note.getEtudiant() != null && note.getEtudiant().getMatricule().equals(matricule)) {
                notesByEtudiant.add(note);
            }
        }
        return notesByEtudiant;
    }
}