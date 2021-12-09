package org.goit.springhw8.service;

import org.goit.springhw8.model.User;
import org.goit.springhw8.model.dto.UserDto;

@FunctionalInterface
public interface IUserService {

    User registerNewUserAccount(UserDto userDto);

}
