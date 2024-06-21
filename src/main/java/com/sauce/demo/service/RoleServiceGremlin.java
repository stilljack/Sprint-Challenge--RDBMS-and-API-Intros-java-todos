package com.sauce.demo.service;

import com.sauce.demo.models.Role;
import com.sauce.demo.respositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.ArrayList;

@Transactional
@Service(value = "roleService")
public class RoleServiceGremlin implements  RoleService{
    @Autowired
    RoleRepository roleRepository;
    @Override
    public Role save(Role role) {
        // restaurants not added through payments
        if (role.getUsers().size() > 0)
        {
            throw new EntityNotFoundException("user not added through role");
        }

        Role newRole = new Role();
        newRole.setUsers(new ArrayList<>());
        newRole.setRolename(role.getRolename());

        return roleRepository.save(newRole);
    }

    @Override
    public Role findRoleById(long id) {
        return roleRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Role with ID " + id + " not found"));
    }
}
