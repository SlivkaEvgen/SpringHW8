package org.goit.springhw8.service;

import org.goit.springhw8.model.Note;
import org.goit.springhw8.model.enums.AccessTypes;
import org.goit.springhw8.repository.NoteRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class NoteService extends ServiceI<Note, String> {

    public NoteService(NoteRepository noteRepository) {
        super(noteRepository);
    }

    public List<AccessTypes> getAccessType() {
        return Arrays.asList(AccessTypes.PUBLIC, AccessTypes.PRIVATE);
    }

}
