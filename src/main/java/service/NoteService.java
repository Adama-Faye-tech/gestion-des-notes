package com.ism.service;

import com.ism.dto.NoteCreateDto;

public interface NoteService {
    boolean addNote(NoteCreateDto nouveau);
}