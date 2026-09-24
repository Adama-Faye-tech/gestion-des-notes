package com.ism.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.ism.domain.Etudiant;
import com.ism.domain.Note;
import com.ism.dto.EtudiantCreateDto;
import com.ism.dto.EtudiantListeDto;
import com.ism.dto.NoteListeDto;
import com.ism.repository.EtudiantRepository;
import com.ism.repository.NoteRepository;

public class EtudiantServiceImpl implements EtudiantService {
    private final EtudiantRepository repo;
    private final NoteRepository repoNote;
    private final MoyenneService moyenneService;

    public EtudiantServiceImpl(EtudiantRepository repo, NoteRepository repoNote, MoyenneService moyenneService) {
        this.repo = repo;
        this.repoNote = repoNote;
        this.moyenneService = moyenneService;
    }

    @Override
    public boolean addEtudiant(EtudiantCreateDto nouveau) {
        Etudiant newEtudiant = Etudiant.builder()
                .nomComplet(nouveau.nomComplet)
                .matricule(nouveau.matricule)
                .classe(nouveau.classe)
                .build();
        newEtudiant.setCreateAt(LocalDateTime.now());
        return repo.insert(newEtudiant);
    }

    @Override
    public List<Etudiant> findAll() {
        return repo.selectAll();
    }

    @Override
    public List<EtudiantListeDto> findAllWithNotes() {
        List<EtudiantListeDto> liste = new ArrayList<>();
        List<Etudiant> etudiants = repo.selectAll();
        for (Etudiant etudiant : etudiants) {
            List<Note> notes = repoNote.selectByEtudiant(etudiant.getMatricule());
            List<NoteListeDto> notesDto = new ArrayList<>();
            for (Note note : notes) {
                notesDto.add(new NoteListeDto(note.getValeur(), note.getMatiere()));
            }
            EtudiantListeDto et = new EtudiantListeDto(
                    etudiant.getMatricule(),
                    etudiant.getNomComplet(),
                    notesDto,
                    moyenneService.moyenne(notes)
            );
            liste.add(et);
        }
        return liste;
    }

    @Override
    public Optional<Etudiant> findByMatricule(String matricule) {
        return repo.selectByMatricule(matricule);
    }
}
