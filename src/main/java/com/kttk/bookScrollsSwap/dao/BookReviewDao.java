package com.kttk.bookScrollsSwap.dao;

import com.kttk.bookScrollsSwap.model.BookReview;

import javax.persistence.EntityManager;
import java.util.List;


public class BookReviewDao implements BaseDaoCrud<BookReview, Long> {

    private final EntityManager entityManager;

    public BookReviewDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<BookReview> findAll() {
        return GeneralDao.findAll(BookReview.class);
    }

    @Override
    public BookReview findById(Long id) {
       return GeneralDao.find(BookReview.class, id);
    }

    @Override
    public BookReview save(BookReview toAdd) {
       return GeneralDao.save(toAdd);
    }


    @Override
    public void deleteById(Long id) {
        GeneralDao.deleteById(BookReview.class, id);
    }

    @Override
    public BookReview update(BookReview updatedItem) {
       return GeneralDao.update(updatedItem);
    }
}
