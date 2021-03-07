package com.kttk.bookScrollsSwap.dao;

import com.kttk.bookScrollsSwap.model.BookReview;
import com.kttk.bookScrollsSwap.utilities.SessionConnector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BookReviewDaoImplTest {

    BookReviewDaoImpl dao;

    BookReview bookReview;

    @BeforeEach
    void setUp() {
        dao = new BookReviewDaoImpl(SessionConnector.getInstance().createH2Factory());

        bookReview = new BookReview();
        bookReview.setReview("Niece Review");
    }

    @Test
    void findAll() {
        BookReview secondReview = new BookReview();
        dao.save(bookReview);
        dao.save(secondReview);

        final List<BookReview> bookReviews = dao.findAll(BookReview.class);

        assertEquals(2, bookReviews.size());
    }

    @Test
    void findById() {
        dao.save(bookReview);

        final BookReview foundBookReview = dao.find(BookReview.class,1L);

        assertNotNull(foundBookReview);
        assertEquals("Niece Review",foundBookReview.getReview());
    }

    @Test
    void save() {
        final BookReview save = dao.save(bookReview);

        assertNotNull(save);
    }

    @Test
    void deleteById() {
        dao.save(bookReview);

        dao.deleteById(BookReview.class,1L);

        final BookReview bookReviewById = dao.find(BookReview.class,1L);

        assertNull(bookReviewById);
    }

    @Test
    void update() {
        final BookReview savedBook = dao.save(bookReview);
        savedBook.setReview("Bad review");

        final BookReview updated = dao.update(savedBook);

        assertEquals("Bad review",updated.getReview());
    }
}