package org.goit.springhw8.repository;

import org.goit.springhw8.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends RepositoryI<User, String> {


}
