package com.kttk.bookScrollsSwap.dao;

import com.kttk.bookScrollsSwap.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;


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

    public Optional<User> findByEmail(String email){
        final EntityManager entityManager = super.factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        String from = "from User u where u.email = ?1";
        final TypedQuery<User> query = entityManager.createQuery(from, User.class);
        query.setParameter(1,email);

        final Optional<User> optionalUser = query.getResultList().stream().findFirst();

        transaction.commit();
        entityManager.close();

        return optionalUser;
    }
}
