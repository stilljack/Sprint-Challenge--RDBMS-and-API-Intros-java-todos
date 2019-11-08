package com.sauce.demo.service;

import com.sauce.demo.models.Role;
import com.sauce.demo.models.Todo;
import com.sauce.demo.models.User;
import com.sauce.demo.respositories.RoleRepository;
import com.sauce.demo.respositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value = "userService")
public class UserServiceGremlim implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleepository;

    @Override
    public List<User> findAll() {
        List<User> list = new ArrayList<>();
        userRepository.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public User findUserById(long id) {
        return null;
    }

    @Override
    public User update(User user, long id) {
        return null;
    }

    @Override
    public void delete(long id) {

    }

    @Transactional
    @Override
    public User save(User user) {

        User newUser =new User();

        newUser.setPassword(user.getPassword());
        newUser.setPrimaryEmail(user.getPrimaryEmail());
        newUser.setUsername(user.getUsername());

        for (Todo t : user.getTodos())
        {
            Todo newTodo =  new Todo(t.getDescription(),t.getDatetime(),t.getUser());

            newUser.addTodos(newTodo);
        }


        for (Role r : user.getRoles()) {
            Role newRole = new Role(r.getRoleName());
            roleepository.save(r);
            newUser.addRoles(newRole);
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

        return userRepository.save(newUser);
    }


}
