package com.kttk.bookScrollsSwap.dao;

import com.kttk.bookScrollsSwap.model.Author;

import javax.persistence.EntityManager;
import java.util.List;


public class AuthorDao implements BaseDaoCrud<Author, Long> {

    private final EntityManager entityManager;

    public AuthorDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Author> findAll() {
        return GeneralDao.findAll(Author.class);
    }

    @Override
    public Author findById(Long id) {
       return GeneralDao.find(Author.class, id);
    }

    @Override
    public Author save(Author toAdd) {
       return GeneralDao.save(toAdd);
    }


    @Override
    public void deleteById(Long id) {
        GeneralDao.deleteById(Author.class, id);
    }

    @Override
    public Author update(Author updatedItem) {
       return GeneralDao.update(updatedItem);
    }
}
