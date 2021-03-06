package com.kttk.bookScrollsSwap.dao;

import com.kttk.bookScrollsSwap.model.BookReview;
import com.kttk.bookScrollsSwap.utilities.SessionConnector;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;


public class BookReviewDao implements BaseDaoCrud<BookReview, Long> {

    private final EntityManager entityManager;

    public BookReviewDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<BookReview> findAll() {
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
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        BookReview review = entityManager.find(BookReview.class, id);

        transaction.commit();
        entityManager.close();

        return review;
    }

    @Override
    public BookReview save(BookReview toAdd) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        entityManager.persist(toAdd);

        transaction.commit();
        entityManager.close();

        return toAdd;
    }


    @Override
    public void deleteById(Long id) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        BookReview review = entityManager.find(BookReview.class, id);
        entityManager.remove(review);

        transaction.commit();
        entityManager.close();
    }

    @Override
    public BookReview update(BookReview updatedItem) {
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
