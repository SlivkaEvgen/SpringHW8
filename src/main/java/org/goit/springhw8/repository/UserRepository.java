package org.goit.springhw8.repository;

import org.goit.springhw8.model.User;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends RepositoryI<User, String> {

    @Query("SELECT u FROM #{#entityName} u WHERE u.email=?1")
    List<User> findByEmail(String email);

}
