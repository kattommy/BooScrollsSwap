package com.kttk.bookScrollsSwap.dao;

import com.kttk.bookScrollsSwap.model.BookCopy;

import javax.persistence.EntityManager;
import java.util.List;


public class BookCopyDao implements BaseDaoCrud<BookCopy, Long> {

    private final EntityManager entityManager;

    public BookCopyDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<BookCopy> findAll() {
        return GeneralDao.findAll(BookCopy.class);
    }

    @Override
    public BookCopy findById(Long id) {
       return GeneralDao.find(BookCopy.class, id);
    }

    @Override
    public BookCopy save(BookCopy toAdd) {
       return GeneralDao.save(toAdd);
    }


    @Override
    public void deleteById(Long id) {
        GeneralDao.deleteById(BookCopy.class, id);
    }

    @Override
    public BookCopy update(BookCopy updatedItem) {
       return GeneralDao.update(updatedItem);
    }
}
