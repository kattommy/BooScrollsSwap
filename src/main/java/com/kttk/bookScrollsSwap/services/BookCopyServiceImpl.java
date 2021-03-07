package com.kttk.bookScrollsSwap.services;

import com.kttk.bookScrollsSwap.dao.BookCopyDao;
import com.kttk.bookScrollsSwap.model.BookCopy;

import java.util.List;

/**
 * Created by Tom - 07.03.2021
 */
public class BookCopyServiceImpl implements BookCopyService{

    private final BookCopyDao bookCopyDao;

    public BookCopyServiceImpl(BookCopyDao bookCopyDao) {
        this.bookCopyDao = bookCopyDao;
    }

    @Override
    public List<BookCopy> findAll() {
        return bookCopyDao.findAll(BookCopy.class);
    }

    @Override
    public BookCopy findById(Long id) {
        return bookCopyDao.find(BookCopy.class, id);
    }

    @Override
    public BookCopy save(BookCopy object) {
        return bookCopyDao.save(object);
    }

    @Override
    public BookCopy update(BookCopy object) {
        return bookCopyDao.update(object);
    }

    @Override
    public void deleteById(Long id) {
        bookCopyDao.deleteById(BookCopy.class, id);
    }
}
