package com.kttk.bookScrollsSwap.dao;

import com.kttk.bookScrollsSwap.model.Book;
import com.kttk.bookScrollsSwap.utilities.SessionConnector;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BookDaoTest {

    BookDao bookDao;
    AuthorDao authorDao;

    Book book;

    @BeforeEach
    void setUp() {
        final SessionFactory h2Factory = SessionConnector.getInstance().createH2Factory();
        bookDao = new BookDao(h2Factory);
        authorDao = new AuthorDao(h2Factory);

        book = new Book();
        book.setIsbn("ISBN");
        book.setPublisher("Publisher");
    }

    @Test
    void save() {
        final Book saved = bookDao.save(book);

        assertNotNull(saved);
    }

    @Test
    void findAll() {
        Book secondBook = new Book();
        bookDao.save(book);
        bookDao.save(secondBook);

        final List<Book> books = bookDao.findAll(Book.class);

        assertEquals(2, books.size());
    }

    @Test
    void find() {
        final Book savedBook = bookDao.save(book);

        final Book foundBook = bookDao.find(Book.class, savedBook.getId());

        assertNotNull(foundBook);
        assertEquals(savedBook.getId(), foundBook.getId());
    }

    @Test
    void update() {
        final Book savedBook = bookDao.save(book);
        savedBook.setPublisher("New publisher");

        final Book updatedBook = bookDao.update(savedBook);

        assertEquals("New publisher", updatedBook.getPublisher());
    }

    @Test
    void deleteById() {
        final Book savedBook = bookDao.save(book);

        bookDao.deleteById(Book.class, savedBook.getId());

        assertNull(bookDao.find(Book.class, savedBook.getId()));
    }
}