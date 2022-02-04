package org.goit.springhw8.repository;

import org.goit.springhw8.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * The interface User repository.
 */
@Repository
public interface UserRepository extends RepositoryI<User, String> {

    /**
     * Find by email list.
     *
     * @param email the email
     * @return the list
     */
    @Query("SELECT u FROM #{#entityName} u WHERE u.email=?1")
    List<User> findByEmail(String email);

}
