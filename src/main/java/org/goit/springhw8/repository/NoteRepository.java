package org.goit.springhw8.repository;

import org.goit.springhw8.model.Note;
import org.springframework.stereotype.Repository;

/**
 * The interface Note repository.
 */
@Repository
public interface NoteRepository extends RepositoryI<Note, String>{


}
