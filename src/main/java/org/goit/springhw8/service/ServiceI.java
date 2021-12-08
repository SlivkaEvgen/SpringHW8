package org.goit.springhw8.service;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.goit.springhw8.model.BaseModel;
import org.goit.springhw8.repository.RepositoryI;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public abstract class ServiceI<T extends BaseModel<ID>, ID> {

    private final RepositoryI<T, ID> repositoryI;

    public List<T> getList() {
        return repositoryI.findAll();
    }

    public Optional<T> getById(@Valid ID id) {
        return repositoryI.findById(id);
    }

    public List<T> getByName(@Valid String name) {
        return repositoryI.findByName(name.toUpperCase());
    }

    public void deleteById(@Valid ID id) {
        repositoryI.deleteById(id);
    }

    public void saveEntity(@Valid T t) {
        repositoryI.save(t);
    }

    public List<T> findListById(@Valid ID id) {
        List<T> tList = new ArrayList<>();
        if (repositoryI.findById(id).isPresent()) {
            tList.add(repositoryI.findById(id).get());
        }
        return tList;
    }
}
