package com.ism.repository;

import java.util.List;

import com.ism.domain.Note;

public interface NoteRepository {
    boolean insert(Note nouveau);
    List<Note> selectByEtudiant(String matricule);
}
