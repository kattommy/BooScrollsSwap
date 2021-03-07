package com.kttk.bookScrollsSwap.dao;

import com.kttk.bookScrollsSwap.enums.BookQuality;
import com.kttk.bookScrollsSwap.enums.BookState;
import com.kttk.bookScrollsSwap.model.BookCopy;
import com.kttk.bookScrollsSwap.utilities.SessionConnector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BookCopyDaoTest {

    BookCopyDao dao;

    BookCopy bookCopy;

    @BeforeEach
    void setUp() {
        dao = new BookCopyDao(SessionConnector
                .getInstance()
                .createH2Factory());

        bookCopy = new BookCopy();
        bookCopy.setQuality(BookQuality.BAD);
        bookCopy.setState(BookState.BORROWED);
    }

    @Test
    void save() {
        final BookCopy savedBookCopy = dao.save(bookCopy);

        assertNotNull(savedBookCopy);
        assertEquals(1, savedBookCopy.getId());
    }

    @Test
    void findAll() {
        BookCopy second = new BookCopy();
        second.setState(BookState.FOR_SALE);
        dao.save(bookCopy);
        dao.save(second);

        final List<BookCopy> bookCopies = dao.findAll(BookCopy.class);

        assertEquals(2,bookCopies.size());
    }

    @Test
    void find() {
        final BookCopy saved = dao.save(bookCopy);

        final BookCopy foundById = dao.find(BookCopy.class, saved.getId());

        assertNotNull(foundById);
        assertEquals(saved.getId(), foundById.getId());
    }

    @Test
    void update() {
        final BookCopy saved = dao.save(bookCopy);
        saved.setQuality(BookQuality.DAMAGED);

        final BookCopy update = dao.update(saved);

        assertEquals(BookQuality.DAMAGED, update.getQuality());
    }

    @Test
    void deleteById() {
        final BookCopy saved = dao.save(bookCopy);
        
        dao.deleteById(BookCopy.class, saved.getId());

        final BookCopy foundBookCopy = dao.find(BookCopy.class, saved.getId());

        assertNull(foundBookCopy);
    }
}