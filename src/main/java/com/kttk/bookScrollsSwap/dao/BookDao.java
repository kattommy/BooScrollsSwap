package com.kttk.bookScrollsSwap.dao;

import com.kttk.bookScrollsSwap.model.Book;

import javax.persistence.EntityManager;
import java.util.List;


public class BookDao implements BaseDaoCrud<Book, Long> {

    private final EntityManager entityManager;

    public BookDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Book> findAll() {
        return GeneralDao.findAll(Book.class);
    }

    @Override
    public Book findById(Long id) {
       return GeneralDao.find(Book.class, id);
    }

    @Override
    public Book save(Book toAdd) {
       return GeneralDao.save(toAdd);
    }


    @Override
    public void deleteById(Long id) {
        GeneralDao.deleteById(Book.class, id);
    }

    @Override
    public Book update(Book updatedItem) {
       return GeneralDao.update(updatedItem);
    }
}
