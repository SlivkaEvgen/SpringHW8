package org.goit.springhw8.repository;

import org.goit.springhw8.model.BaseModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

/**
 * The interface Repository i.
 *
 * @param <T>  the type parameter
 * @param <ID> the type parameter
 */
@NoRepositoryBean
public interface RepositoryI<T extends BaseModel<ID>, ID> extends JpaRepository<T, ID> {

    /**
     * Find by name containing ignore case list.
     *
     * @param name the name
     * @return the list
     */
    List<T> findByNameContainingIgnoreCase(String name);
}
