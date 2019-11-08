package service;

import models.User;

import java.util.List;

public interface UserService {
 List<User> allUsers();
 User save (User user);
}
