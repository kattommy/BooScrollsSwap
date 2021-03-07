package com.kttk.bookScrollsSwap.services;

import com.kttk.bookScrollsSwap.dao.BookReviewDao;
import com.kttk.bookScrollsSwap.model.BookReview;

import java.util.List;

/**
 * Created by Tom - 07.03.2021
 */
public class BookReviewServiceImpl implements BookReviewService{

    private final BookReviewDao bookReviewDao;

    public BookReviewServiceImpl(BookReviewDao bookReviewDao) {
        this.bookReviewDao = bookReviewDao;
    }

    @Override
    public List<BookReview> findAll() {
        return bookReviewDao.findAll(BookReview.class);
    }

    @Override
    public BookReview findById(Long id) {
        return bookReviewDao.find(BookReview.class, id);
    }

    @Override
    public BookReview save(BookReview object) {
        return bookReviewDao.save(object);
    }

    @Override
    public BookReview update(BookReview object) {
        return bookReviewDao.update(object);
    }

    @Override
    public void deleteById(Long id) {
        bookReviewDao.deleteById(BookReview.class, id);
    }
}
