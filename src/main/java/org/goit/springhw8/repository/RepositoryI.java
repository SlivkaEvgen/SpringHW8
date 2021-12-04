package org.goit.springhw8.repository;

import org.goit.springhw8.model.BaseModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface RepositoryI<T extends BaseModel<ID>,ID> extends JpaRepository<T,ID> {

    @Query("SELECT u FROM #{#entityName} u WHERE u.name=?1")
    List<T> findByName(String name);

}
