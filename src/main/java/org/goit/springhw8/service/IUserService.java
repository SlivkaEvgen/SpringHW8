package org.goit.springhw8.service;

import org.goit.springhw8.model.User;
import org.goit.springhw8.model.dto.UserDto;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

@Service
public interface IUserService {

    User registerNewUserAccount(UserDto userDto);

}
