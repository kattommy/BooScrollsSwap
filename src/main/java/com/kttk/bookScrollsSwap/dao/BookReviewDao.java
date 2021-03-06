package com.kttk.bookScrollsSwap.dao;

import com.kttk.bookScrollsSwap.model.Book;
import com.kttk.bookScrollsSwap.model.BookReview;
import com.kttk.bookScrollsSwap.model.Note;
import com.kttk.bookScrollsSwap.services.BaseCrud;
import com.kttk.bookScrollsSwap.utilities.SessionConnector;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;


public class BookReviewDao implements BaseDaoCrud<BookReview, Long> {

    @Override
    public List<BookReview> findAll() {
        EntityManager entityManager = SessionConnector.createFactory().createEntityManager();
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
        EntityManager entityManager = SessionConnector.createFactory().createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        BookReview review = entityManager.find(BookReview.class, id);

        transaction.commit();
        entityManager.close();

        return review;
    }

    @Override
    public BookReview add(BookReview toAdd) {
        EntityManager entityManager = SessionConnector.createFactory().createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        entityManager.persist(toAdd);

        transaction.commit();
        entityManager.close();

        return toAdd;
    }


    @Override
    public void deleteById(Long id) {
        EntityManager entityManager = SessionConnector.createFactory().createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        BookReview review = entityManager.find(BookReview.class, id);
        entityManager.remove(review);

        transaction.commit();
        entityManager.close();
    }
}
