package org.goit.springhw8.service;

import org.goit.springhw8.model.Note;
import org.goit.springhw8.repository.NoteRepository;
import org.springframework.stereotype.Service;

@Service
public class NoteService extends ServiceI<Note, String>{


    public NoteService(NoteRepository noteRepository) {
        super(noteRepository);
    }


}
