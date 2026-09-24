package com.ism.factory;

import com.ism.repository.EtudiantRepository;
import com.ism.repository.NoteRepository;
import com.ism.repository.memoire.DatabaseMemory;
import com.ism.repository.memoire.EtudiantRepositoryMemory;
import com.ism.repository.memoire.NoteRepositoryMemory;

public final class RepositoryFactory {
    public static EtudiantRepository createEtudiantRepository() {
        return new EtudiantRepositoryMemory(DatabaseMemory.getInstance());
    }

    public static NoteRepository createNoteRepository() {
        return new NoteRepositoryMemory(DatabaseMemory.getInstance());
    }
}
