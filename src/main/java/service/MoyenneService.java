package com.ism.service;

import java.util.List;

import com.ism.domain.Note;

public interface MoyenneService {
    double moyenne(List<Note> notes);
}
