package com.sauce.demo.service;

import com.sauce.demo.models.Role;
import com.sauce.demo.models.Todo;
import com.sauce.demo.models.User;
import com.sauce.demo.respositories.RoleRepository;
import com.sauce.demo.respositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value = "userService")
public class UserServiceGremlim implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRpository;
    @Autowired
    private RoleService roleService;

    @Override
    public List<User> findAll() {
        List<User> list = new ArrayList<>();
        userRepository.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public User update(User user, long id) {
        return null;
    }

    @Transactional
    @Override
    public void delete(long id) {
        if (findUserById(id) != null) {
            userRepository.deleteById(id);
        }
    }

    @Transactional
    @Override
    public User save(User user) {

        User newUser = new User();

        newUser.setPassword(user.getPassword());
        newUser.setPrimaryEmail(user.getPrimaryEmail());
        newUser.setUsername(user.getUsername());

        for (Todo t : user.getTodos()) {
            Todo newTodo = new Todo(t.getDescription(), t.getDatetime(), t.isCompleted(), newUser);
            newUser.getTodos().add(newTodo);
        }

        for (Role r : user.getRoles()) {
            Role newRole = roleService.findRoleById(r.getRoleid());

            newUser.addRoles(newRole);
        }

        return userRepository.save(newUser);
    }
    @Override
    public User findUserById(long id) {
        return userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("User with ID: " + id + " does not exist"));
    }
}
//        if(user.getRoles().get(0) != null) {
//            for (Role r : user.getRoles()) {
//                Role newRole = new Role(r.getRoleName());
//                for (User u : r.getUsers()) {
//                    newRole.addUser(new User(u.getUsername(), u.getPrimaryEmail(), u.getPassword()));
//
//                }
//                newUser.addRoles(newRole);
//            }
//        }

