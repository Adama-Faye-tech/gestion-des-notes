package com.ism.dto;

import java.util.List;

public record EtudiantListeDto(String matricule, String nomComplet, List<NoteListeDto> notes, double moyenne) {
}
