package org.goit.springhw8.repository;

import org.goit.springhw8.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends RepositoryI<User,String>{


}
