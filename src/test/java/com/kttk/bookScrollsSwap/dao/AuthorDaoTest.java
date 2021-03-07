package com.kttk.bookScrollsSwap.dao;

import com.kttk.bookScrollsSwap.model.Author;
import com.kttk.bookScrollsSwap.utilities.SessionConnector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AuthorDaoTest {

    AuthorDao dao;

    Author author;

    @BeforeEach
    void setUp() {
        dao = new AuthorDao(SessionConnector.getInstance().createH2Factory());

        author = new Author();
        author.setFirstName("Adam");
        author.setLastName("Mickiewicz");
    }

    @Test
    void findAll() {
        Author secondAuthor = new Author();
        dao.save(author);
        dao.save(secondAuthor);

        final List<Author> authors = dao.findAll(Author.class);

        assertEquals(2, authors.size());
    }

    @Test
    void findById() {
        dao.save(author);

        final Author foundAuthor = dao.find(Author.class,1L);

        assertNotNull(foundAuthor);
        assertEquals("Mickiewicz",foundAuthor.getLastName());
    }

    @Test
    void save() {
        final Author save = dao.save(author);

        assertNotNull(save);
    }

    @Test
    void deleteById() {
        dao.save(author);

        dao.deleteById(Author.class,1L);

        final Author authorById = dao.find(Author.class,1L);

        assertNull(authorById);
    }

    @Test
    void update() {
        final Author savedAuthor = dao.save(author);
        savedAuthor.setFirstName("Adam Bernard");

        final Author updated = dao.update(savedAuthor);

        assertEquals("Adam Bernard",updated.getFirstName());
    }
}