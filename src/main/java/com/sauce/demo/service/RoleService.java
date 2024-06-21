package com.sauce.demo.service;


import com.sauce.demo.models.Role;

import javax.persistence.EntityNotFoundException;

public interface RoleService {

  Role save(Role role);

  Role findRoleById(long id);
}
