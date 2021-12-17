package org.goit.springhw8.service;

import lombok.RequiredArgsConstructor;
import org.goit.springhw8.model.BaseModel;
import org.goit.springhw8.repository.RepositoryI;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public abstract class ServiceI<T extends BaseModel<ID>, ID> {

    private final RepositoryI<T, ID> repositoryI;

    public List<T> getAll() {
        return repositoryI.findAll();
    }

    public Optional<T> getById(ID id) {
        return repositoryI.findById(id);
    }

    public List<T> findByName(String name) {
        return repositoryI.findByName(name.toUpperCase());
    }

    public void deleteById(ID id) {
        repositoryI.deleteById(id);
    }

    public void saveEntity(T t) {
        repositoryI.save(t);
    }

    public List<T> findListByEntityId(ID id) {
        ArrayList<T> tList = new ArrayList<>();
        repositoryI.findById(id).ifPresent(tList::add);
        return tList;
    }
}
