package org.goit.springhw8.service;

import org.goit.springhw8.model.Role;
import org.goit.springhw8.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        System.out.println("RoleService");
        this.roleRepository = roleRepository;
    }

    public List<Role> getAllRoles() {
        System.out.println("getAllRoles");
        return roleRepository.findAll();
    }

    public Optional<Role> findById(String id) {
        System.out.println("findById");
        return roleRepository.findById(Long.parseLong(id));
    }

    public List<Role> findByRoleName(String name) {
        System.out.println("findByRoleName");
        return roleRepository.findByName(name);
    }

    public void deleteRole(String id) {
        System.out.println("deleteRole");
        if (roleRepository.findById(Long.parseLong(id)).isPresent()) {
            roleRepository.deleteById(Long.parseLong(id));
        }
    }

    public Role saveRole(Role role) {
        System.out.println("saveRole");
        return roleRepository.save(role);
    }
}
