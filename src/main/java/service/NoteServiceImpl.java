package com.ism.service;

import com.ism.dto.NoteCreateDto;
import com.ism.repository.NoteRepository;

import java.time.LocalDateTime;

import com.ism.domain.Note;

public class NoteServiceImpl implements NoteService {
    private NoteRepository repo;

    public NoteServiceImpl(NoteRepository repo) {
        this.repo = repo;
    }

    @Override
    public boolean addNote(NoteCreateDto nouveau) {
        Note newNote = Note.builder()
                        .matiere(nouveau.matiere())
                        .valeur(nouveau.valeur())
                        .etudiant(nouveau.etudiant())
                        .build();
        newNote.setCreateAt(LocalDateTime.now());
        return repo.insert(newNote);
    }
    
}
