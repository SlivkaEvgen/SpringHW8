package org.goit.springhw8.service;

import org.goit.springhw8.model.User;
import org.goit.springhw8.model.dto.UserDto;
import org.springframework.stereotype.Service;

/**
 * The interface User service.
 */
@Service
public interface IUserService {

    /**
     * Register new user account user.
     *
     * @param userDto the user dto
     * @return the user
     */
    User registerNewUserAccount(UserDto userDto);

}
