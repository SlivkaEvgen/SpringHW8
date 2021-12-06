package org.goit.springhw8.service;

import org.goit.springhw8.model.Role;
import org.goit.springhw8.repository.RoleRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService extends ServiceI<Role, String> {

    public RoleService(RoleRepository roleRepository) {
        super(roleRepository);
    }

}
