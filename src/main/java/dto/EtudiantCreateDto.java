package com.ism.dto;

public final class EtudiantCreateDto {
    public final String nomComplet;
    public final String matricule;
    public final String classe;

    public EtudiantCreateDto(String nomComplet, String matricule, String classe) {
        this.nomComplet = nomComplet;
        this.matricule = matricule;
        this.classe = classe;
    }
}