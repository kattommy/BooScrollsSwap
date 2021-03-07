package com.kttk.bookScrollsSwap.dao;

import javax.persistence.EntityManagerFactory;
import java.util.List;


public class UserDao extends GeneralDao {

    public UserDao(EntityManagerFactory factory) {
        super(factory);
    }

    @Override
    public <T> T save(T entity) {
        return super.save(entity);
    }

    @Override
    public <T> List<T> findAll(Class<T> type) {
        return super.findAll(type);
    }

    @Override
    public <T> T find(Class<T> type, Long id) {
        return super.find(type, id);
    }

    @Override
    public <T> T update(T entity) {
        return super.update(entity);
    }

    @Override
    public <T> void deleteById(Class<T> type, Long id) {
        super.deleteById(type, id);
    }
}
