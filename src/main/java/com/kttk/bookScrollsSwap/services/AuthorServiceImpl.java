package com.kttk.bookScrollsSwap.services;

import com.kttk.bookScrollsSwap.dao.AuthorDao;
import com.kttk.bookScrollsSwap.model.Author;

import java.util.List;

/**
 * Created by Tom - 07.03.2021
 */
public class AuthorServiceImpl implements AuthorService{

    private final AuthorDao authorDao;

    public AuthorServiceImpl(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    @Override
    public List<Author> findAll() {
        return authorDao.findAll(Author.class);
    }

    @Override
    public Author findById(Long id) {
        return authorDao.find(Author.class, id);
    }

    @Override
    public Author save(Author object) {
        return authorDao.save(object);
    }

    @Override
    public Author update(Author object) {
        return authorDao.update(object);
    }

    @Override
    public void deleteById(Long id) {
        authorDao.deleteById(Author.class, id);
    }
}
