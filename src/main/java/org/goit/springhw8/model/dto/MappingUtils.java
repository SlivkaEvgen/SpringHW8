package org.goit.springhw8.model.dto;

import org.goit.springhw8.model.User;
import org.springframework.stereotype.Service;

@Service
public class MappingUtils {

    //из entity в dto
    public UserDto mapToUserDto(User user){
        UserDto dto = new UserDto();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setLastName(user.getLastName());
        dto.setGender(user.getGender());
        dto.setEmail(user.getEmail());
        dto.setPassword(user.getPassword());
        dto.setPasswordConfirm(user.getPasswordConfirm());
//        dto.setRoleDtoSet(user.getRoles());

        return dto;
    }

    //из dto в entity
    public User mapToUserEntity(UserDto dto){
        User user = new User();
        user.setId(dto.getId());
        user.setName(dto.getName());
        user.setGender(dto.getGender());
        user.setEmail(dto.getEmail());
        user.setLastName(dto.getLastName());
        user.setPassword(dto.getPassword());
//        user.setRoles(dto.getRoleDtoSet());
        return user;
    }
}
