package com.kttk.bookScrollsSwap.services;

import com.kttk.bookScrollsSwap.dao.UserDao;
import com.kttk.bookScrollsSwap.model.User;

import java.util.List;
import java.util.Optional;

/**
 * Created by Tom - 07.03.2021
 */
public class UserServiceImpl implements UserService{

    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll(User.class);
    }

    @Override
    public User findById(Long aLong) {
        return userDao.find(User.class,aLong);
    }

    @Override
    public User save(User object) {
        return userDao.save(object);
    }

    @Override
    public void deleteById(Long aLong) {
        userDao.deleteById(User.class,aLong);
    }

    @Override
    public User update(User object) {
        return userDao.update(object);
    }

    public Optional<User> findByEmail(String email){
        return userDao.findByEmail(email);
    }
}
