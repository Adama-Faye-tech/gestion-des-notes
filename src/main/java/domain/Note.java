package com.ism.domain;

public class Note {
    private String matiere;
    private double valeur;
    private Etudiant etudiant;

    public Note() {
    }

    public Note(String matiere, double valeur, Etudiant etudiant) {
        this.matiere = matiere;
        this.valeur = valeur;
        this.etudiant = etudiant;
    }

    public String getMatiere() {
        return matiere;
    }

    public void setMatiere(String matiere) {
        this.matiere = matiere;
    }

    public double getValeur() {
        return valeur;
    }

    public void setValeur(double valeur) {
        this.valeur = valeur;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    @Override
    public String toString() {
        return "Note{" +
                "matiere='" + matiere + '\'' +
                ", valeur=" + valeur +
                ", etudiant=" + etudiant +
                '}';
    }
}
