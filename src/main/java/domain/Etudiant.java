package com.ism.domain;

public class Etudiant extends AbstractEntity {
    private String nomComplet;
    private String matricule;
    private String classe;

    public Etudiant() {
    }

    public Etudiant(String nomComplet, String matricule, String classe) {
        this.nomComplet = nomComplet;
        this.matricule = matricule;
        this.classe = classe;
    }

    public static EtudiantBuilder builder() {
        return new EtudiantBuilder();
    }

    public String getNomComplet() {
        return nomComplet;
    }

    public void setNomComplet(String nomComplet) {
        this.nomComplet = nomComplet;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    @Override
    public String toString() {
        return "Etudiant{" +
                "nomComplet='" + nomComplet + '\'' +
                ", matricule='" + matricule + '\'' +
                ", classe='" + classe + '\'' +
                '}';
    }

    public static class EtudiantBuilder {
        private String nomComplet;
        private String matricule;
        private String classe;

        public EtudiantBuilder nomComplet(String nomComplet) {
            this.nomComplet = nomComplet;
            return this;
        }

        public EtudiantBuilder matricule(String matricule) {
            this.matricule = matricule;
            return this;
        }

        public EtudiantBuilder classe(String classe) {
            this.classe = classe;
            return this;
        }

        public Etudiant build() {
            return new Etudiant(nomComplet, matricule, classe);
        }
    }
}