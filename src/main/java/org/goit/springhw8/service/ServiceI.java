package org.goit.springhw8.service;

import lombok.RequiredArgsConstructor;
import org.goit.springhw8.model.BaseModel;
import org.goit.springhw8.repository.RepositoryI;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public abstract class ServiceI<T extends BaseModel<ID>, ID> {

    private final RepositoryI<T, ID> repositoryI;

    abstract List<T> getAll();

    abstract Optional<T> findById(ID id);

    abstract List<T> findByName(String name);

    abstract void delete(ID id);

    abstract void save(T t);

}
