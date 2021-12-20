package org.goit.springhw8.repository;

import org.goit.springhw8.model.English;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * The interface English repository.
 */
@Repository
public interface EnglishRepository extends RepositoryI<English,String>{

    /**
     * Find by ukrainian name containing ignore case list.
     *
     * @param ukr the ukr
     * @return the list
     */
    @Query("SELECT u FROM #{#entityName} u WHERE u.ukr=?1")
    List<English> findByUkrainianNameContainingIgnoreCase(String ukr);
}
