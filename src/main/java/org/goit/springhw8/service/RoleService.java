package org.goit.springhw8.service;

import org.goit.springhw8.model.Role;
import org.goit.springhw8.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository){
        this.roleRepository=roleRepository;
    }

    public Iterable<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    public Optional<Role> findById(String id) {
        return roleRepository.findById(Long.parseLong(id));
    }

    public Iterable<Role> findByRoleName(String name) {
        return roleRepository.findByName(name);
    }

    public void deleteRole(String id) {
        roleRepository.deleteById(Long.parseLong(id));
    }

    public void saveRole(Role role) {
        roleRepository.save(role);
    }
}
