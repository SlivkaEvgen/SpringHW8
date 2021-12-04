package org.goit.springhw8.service;

import org.goit.springhw8.model.Role;
import org.goit.springhw8.repository.RepositoryI;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService extends ServiceI<Role, String> {

    private final RepositoryI<Role, String> roleRepository;

    public RoleService(RepositoryI<Role, String> roleRepository) {
        super(roleRepository);
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> getAll() {
        System.out.println("getAllRoles");
        return roleRepository.findAll();
    }

    @Override
    public Optional<Role> findById(String id) {
        System.out.println("findById");
        return roleRepository.findById(id);
    }

    @Override
    public List<Role> findByName(String name) {
        System.out.println("findByRoleName");
        return roleRepository.findByName(name);
    }

    @Override
    public void delete(String id) {
        System.out.println("deleteRole");
        if (roleRepository.findById(id).isPresent()) {
            roleRepository.deleteById(id);
        }
    }

    @Override
    public void save(Role role) {
        System.out.println("saveRole");
         roleRepository.save(role);
    }
}
