package com.ism.dto;

import com.ism.domain.Etudiant;

public record NoteCreateDto(double valeur, String matiere, Etudiant etudiant) {
    
}