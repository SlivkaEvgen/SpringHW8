package org.goit.springhw8.service;

import org.goit.springhw8.model.Note;
import org.goit.springhw8.model.enums.AccessTypes;
import org.goit.springhw8.repository.NoteRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * The type Note service.
 */
@Service
public class NoteService extends ServiceI<Note, String> {

    /**
     * Instantiates a new Note service.
     *
     * @param noteRepository the note repository
     */
    public NoteService(NoteRepository noteRepository) {
        super(noteRepository);
    }

    /**
     * Gets access type.
     *
     * @return the access type
     */
    public List<AccessTypes> getAccessType() {
        return Arrays.asList(AccessTypes.PUBLIC, AccessTypes.PRIVATE);
    }

}
