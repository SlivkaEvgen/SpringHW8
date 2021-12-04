package org.goit.springhw8.service;

import org.goit.springhw8.model.Role;
import org.goit.springhw8.repository.RoleRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

@Service
public class RoleService extends ServiceI<Role,String>{

    public RoleService(RoleRepository roleRepository) {
        super(roleRepository);
    }

    @Override
    public void deleteById(String id) {
        if (super.getById(id).get().getName().equalsIgnoreCase("ADMIN")){
            return;
        }
        super.deleteById(id);
    }

    @Override
    public void saveEntity(@NotNull Role role) {
        if (role.getName().equalsIgnoreCase("ADMIN")){
            return;
        }
        if (role.getId().equalsIgnoreCase("1")){
            return;
        }
        super.saveEntity(role);
    }
}
