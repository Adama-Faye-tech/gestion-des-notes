package com.ism.dto;

public class EtudiantCreateDto {
    public String nomComplet;
    public String matricule;
    public String classe;

    public EtudiantCreateDto(String nomComplet, String matricule, String classe) {
        this.nomComplet = nomComplet;
        this.matricule = matricule;
        this.classe = classe;
    }
}
