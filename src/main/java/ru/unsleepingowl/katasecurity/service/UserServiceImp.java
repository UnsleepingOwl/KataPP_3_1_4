package ru.unsleepingowl.katasecurity.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.unsleepingowl.katasecurity.dao.UserDao;
import ru.unsleepingowl.katasecurity.model.User;

import java.util.List;
import java.util.Set;


@Service
public class UserServiceImp implements UserService {

    private final UserDao userDao;

    public UserServiceImp(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public void addUser(User user, Set<String> rolesStringSet) {
        userDao.addUser(user, rolesStringSet);
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        userDao.deleteUser(id);
    }

    @Override
    @Transactional
    public void updateUser(User user, Long id, Set<String> rolesStringSet) {
        userDao.updateUser(user, id, rolesStringSet);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getUsersList() {
        return userDao.getUsersList();
    }

    @Override
    @Transactional(readOnly = true)
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    @Override
    public User createUser() {
        return userDao.createUser();
    }

    @Override
    @Transactional(readOnly = true)
    public User getUserById(Long id) {
        return userDao.getUserById(id);
    }

}
