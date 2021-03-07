package com.kttk.bookScrollsSwap.dao;

import com.kttk.bookScrollsSwap.model.BookReview;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;


public class BookReviewDaoImpl implements BaseDaoCrud<BookReview, Long> {

    private final EntityManagerFactory factory;

    public BookReviewDaoImpl(EntityManagerFactory factory) {
        this.factory = factory;
    }

    @Override
    public List<BookReview> findAll() {
        final EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        TypedQuery<BookReview> getAllUsersQuery = entityManager.createQuery("from BookReview", BookReview.class);
        List<BookReview> reviews = getAllUsersQuery.getResultList();

        transaction.commit();
        entityManager.close();

        return reviews;
    }

    @Override
    public BookReview findById(Long id) {
        final EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        BookReview review = entityManager.find(BookReview.class, id);

        transaction.commit();
        entityManager.close();

        return review;
    }

    @Override
    public BookReview save(BookReview toAdd) {
        final EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        entityManager.persist(toAdd);

        transaction.commit();
        entityManager.close();

        return toAdd;
    }


    @Override
    public void deleteById(Long id) {
        final EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        BookReview review = entityManager.find(BookReview.class, id);
        entityManager.remove(review);

        transaction.commit();
        entityManager.close();
    }

    @Override
    public BookReview update(BookReview updatedItem) {
        final EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        BookReview toUpdate = entityManager.find(BookReview.class, updatedItem.getId());
        toUpdate.setUser(updatedItem.getUser());
        toUpdate.setBook(updatedItem.getBook());
        toUpdate.setReview(updatedItem.getReview());

        transaction.commit();
        entityManager.close();
        return toUpdate;
    }
}
