package com.sauce.demo.respositories;


import com.sauce.demo.models.Role;
import org.springframework.data.repository.CrudRepository;


public interface RoleRepository extends CrudRepository<Role,Long> {
}
