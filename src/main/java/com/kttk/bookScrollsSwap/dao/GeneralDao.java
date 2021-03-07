package com.kttk.bookScrollsSwap.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.List;

class GeneralDao{

    protected final EntityManagerFactory factory;

    public GeneralDao(EntityManagerFactory factory) {
        this.factory = factory;
    }

    public <T> T save(T entity) {
        final EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        entityManager.persist(entity);
        transaction.commit();

        entityManager.close();

        return entity;
    }

    public <T> List<T> findAll(Class<T> type) {
        final EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        String from = "from " + type.getName();
        List<T> entities = entityManager.createQuery(from, type).getResultList();

        transaction.commit();
        entityManager.close();
        return entities;
    }

    public <T> T find(Class<T> type, Long id) {
        final EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        T entity = entityManager.find(type, id);
        transaction.commit();

        entityManager.close();
        return entity;
    }

    public <T> T update(T entity) {
        final EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        T updatedEntity = entityManager.merge(entity);
        transaction.commit();
        entityManager.close();

        return updatedEntity;
    }

    public <T> void deleteById(Class<T> type, Long id) {
        final EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        T entity = entityManager.find(type, id);
        entityManager.remove(entity);
        transaction.commit();
        entityManager.close();
    }
}
