package com.kttk.bookScrollsSwap.dao;

import com.kttk.bookScrollsSwap.utilities.SessionConnector;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

class GeneralDao {

    private static EntityManager entityManager;

    GeneralDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public static <T> T save(T entity) {
        try {
            entityManager = SessionConnector.getInstance().createFactory().createEntityManager();
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();

            entityManager.persist(entity);
            transaction.commit();

            return entity;

        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

    public static <T> List<T> findAll(Class<T> type) {
        try {
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            String from = "from " + type.getName();
            List<T> entities = entityManager.createQuery(from, type).getResultList();

            transaction.commit();
            return entities;
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

    public static <T> T find(Class<T> type, Long id) {
        try {
            entityManager = SessionConnector.getInstance().createFactory().createEntityManager();
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();

            T entity = entityManager.find(type, id);
            transaction.commit();

            return entity;
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

    public static <T> T update(T entity) {
        try {
            entityManager = SessionConnector.getInstance().createFactory().createEntityManager();
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();

            T updatedEntity = entityManager.merge(entity);
            transaction.commit();

            return updatedEntity;

        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

    public static <T> void deleteById(Class<T> type, Long id) {
        try {
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            T entity = entityManager.find(type, id);
            entityManager.remove(entity);
            transaction.commit();
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }
}
