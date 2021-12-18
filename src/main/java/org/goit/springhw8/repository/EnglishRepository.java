package org.goit.springhw8.repository;

import org.goit.springhw8.model.English;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnglishRepository extends RepositoryI<English,String>{

    @Query("SELECT u FROM #{#entityName} u WHERE u.ukr=?1")
    List<English> findByUkrainianNameContainingIgnoreCase(String ukr);
}
