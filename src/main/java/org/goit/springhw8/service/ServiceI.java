package org.goit.springhw8.service;

import lombok.RequiredArgsConstructor;
import org.goit.springhw8.model.BaseModel;
import org.goit.springhw8.repository.RepositoryI;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * The type Service i.
 *
 * @param <T>  the type parameter
 * @param <ID> the type parameter
 */
@Service
@RequiredArgsConstructor
public abstract class ServiceI<T extends BaseModel<ID>, ID> {

    private final RepositoryI<T, ID> repositoryI;

    /**
     * Gets all.
     *
     * @return the all
     */
    public List<T> getAll() {
        return repositoryI.findAll();
    }

    /**
     * Gets by id.
     *
     * @param id the id
     * @return the by id
     */
    public Optional<T> getById(ID id) {
        return repositoryI.findById(id);
    }

    /**
     * Find by name list.
     *
     * @param name the name
     * @return the list
     */
    public List<T> findByName(String name) {
        return repositoryI.findByName(name.toUpperCase());
    }

    /**
     * Delete by id.
     *
     * @param id the id
     */
    public void deleteById(ID id) {
        repositoryI.deleteById(id);
    }

    /**
     * Save entity.
     *
     * @param t the t
     */
    public void saveEntity(T t) {
        repositoryI.save(t);
    }

    /**
     * Find list by entity id list.
     *
     * @param id the id
     * @return the list
     */
    public List<T> findListByEntityId(ID id) {
        ArrayList<T> tList = new ArrayList<>();
        repositoryI.findById(id).ifPresent(tList::add);
        return tList;
    }
}
