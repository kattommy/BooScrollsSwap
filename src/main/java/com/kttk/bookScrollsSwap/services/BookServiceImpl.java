package com.kttk.bookScrollsSwap.services;

import com.kttk.bookScrollsSwap.dao.BookDao;
import com.kttk.bookScrollsSwap.model.Book;

import java.util.List;

/**
 * Created by Tom - 07.03.2021
 */
public class BookServiceImpl implements BookService{

    private final BookDao bookDao;

    public BookServiceImpl(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    public List<Book> findAll() {
        return bookDao.findAll(Book.class);
    }

    @Override
    public Book findById(Long id) {
        return bookDao.find(Book.class, id);
    }

    @Override
    public Book save(Book object) {
        return bookDao.save(object);
    }

    @Override
    public Book update(Book object) {
        return bookDao.update(object);
    }

    @Override
    public void deleteById(Long id) {
        bookDao.deleteById(Book.class,id);
    }
}
