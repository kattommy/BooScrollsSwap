package com.kttk.bookScrollsSwap.dao;

import com.kttk.bookScrollsSwap.model.User;

import javax.persistence.EntityManager;
import java.util.List;


public class UserDao implements BaseDaoCrud<User, Long> {

    private final EntityManager entityManager;

    public UserDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<User> findAll() {
        return GeneralDao.findAll(User.class);
    }

    @Override
    public User findById(Long id) {
       return GeneralDao.find(User.class, id);
    }

    @Override
    public User save(User toAdd) {
       return GeneralDao.save(toAdd);
    }


    @Override
    public void deleteById(Long id) {
        GeneralDao.deleteById(User.class, id);
    }

    @Override
    public User update(User updatedItem) {
       return GeneralDao.update(updatedItem);
    }
}
