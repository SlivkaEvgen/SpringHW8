package org.goit.springhw8.repository;

import org.goit.springhw8.model.BaseModel;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;

import java.util.List;

@NoRepositoryBean
public interface RepositoryI<T extends BaseModel<ID>, ID> extends JpaRepository<T, ID> {

    List<T> findByNameContainingIgnoreCase(String name);

    //    @Query("SELECT u FROM #{#entityName} u WHERE lower(u.name) like lower(concat('%', ?1,'%'))")
//    @Query("SELECT u.name FROM #{#entityName} u WHERE u.name LIKE CONCAT('%',:name,'%')")


}
