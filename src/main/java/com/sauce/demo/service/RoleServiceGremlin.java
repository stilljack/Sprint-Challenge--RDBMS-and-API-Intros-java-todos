package com.sauce.demo.service;

import com.sauce.demo.models.Role;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service(value = "roleService")
public class RoleServiceGremlin implements  RoleService{
    @Override
    public Role save(Role role) {
        return null;
    }
}
