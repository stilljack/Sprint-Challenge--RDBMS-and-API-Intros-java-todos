package com.sauce.demo.service;



import com.sauce.demo.models.User;

import java.util.List;

public interface UserService {
 List<User> findAll();
 User findUserById(long id);

 User update(User user, long id);
 void delete(long id);
 User save (User user);
}
