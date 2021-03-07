package com.kttk.bookScrollsSwap.bootloader;

import com.kttk.bookScrollsSwap.dao.*;
import com.kttk.bookScrollsSwap.utilities.SessionConnector;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DataLoaderTest {

    DataLoader dataLoader;

    @BeforeEach
    void setUp() {
        final SessionFactory factory = SessionConnector.getInstance().createFactory();
        AuthorDao authorDao = new AuthorDao(factory);
        BookCopyDao bookCopyDao = new BookCopyDao(factory);
        BookDao bookDao = new BookDao(factory);
        BookReviewDao bookReviewDao = new BookReviewDao(factory);
        NoteDao noteDao = new NoteDao(factory);
        UserDao userDao = new UserDao(factory);

        dataLoader = new DataLoader(authorDao,bookCopyDao,bookDao,bookReviewDao,noteDao,userDao);
    }

    @Test
    void loadData() {
        dataLoader.loadData();
    }
}