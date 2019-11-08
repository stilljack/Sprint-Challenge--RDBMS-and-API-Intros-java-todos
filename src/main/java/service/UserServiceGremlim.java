package service;

import models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import respositories.UserRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value = "userService")
public class UserServiceGremlim implements UserService {

    @Autowired
    private UserRepository userRepository;

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

    @Override
    public User save(User user) {
        return null;
    }
}
