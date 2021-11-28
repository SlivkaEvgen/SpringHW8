package org.goit.springhw8.repository;

import org.goit.springhw8.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM #{#entityName} u WHERE u.name=?1")
    List<User> findByName(String name);

}
