package com.ism.service;

import java.util.List;

import com.ism.domain.Note;

public class MoyenneServiceImpl implements MoyenneService {

    @Override
    public double moyenne(List<Note> notes) {
        if (notes == null || notes.isEmpty()) {
            return 0.0;
        }

        double somme = 0;
        for (Note note : notes) {
            somme += note.getValeur();
        }
        return somme / notes.size();
    }
}
