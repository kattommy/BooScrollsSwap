package com.kttk.bookScrollsSwap.bootloader;

import com.kttk.bookScrollsSwap.dao.*;
import com.kttk.bookScrollsSwap.enums.BookQuality;
import com.kttk.bookScrollsSwap.enums.BookState;
import com.kttk.bookScrollsSwap.enums.UserStatus;
import com.kttk.bookScrollsSwap.model.*;

import java.time.LocalDateTime;

/**
 * Created by Tom - 07.03.2021
 */
public class DataLoader {

    public final AuthorDao authorDao;
    public final BookCopyDao bookCopyDao;
    public final BookDao bookDao;
    public final BookReviewDao bookReviewDao;
    public final NoteDao noteDao;
    public final UserDao userDao;

    public DataLoader(AuthorDao authorDao, BookCopyDao bookCopyDao, BookDao bookDao,
                      BookReviewDao bookReviewDao, NoteDao noteDao, UserDao userDao) {
        this.authorDao = authorDao;
        this.bookCopyDao = bookCopyDao;
        this.bookDao = bookDao;
        this.bookReviewDao = bookReviewDao;
        this.noteDao = noteDao;
        this.userDao = userDao;
    }

    public void loadData(){
        //Books
        Book book = Book.builder()
                .title("Twain's Book")
                .isbn("isbn-number")
                .publisher("new publisher")
                .build();

        Book secondTwainBook = Book.builder()
                .title("Twain's second  Book")
                .isbn("isbn-number-two")
                .publisher("new publisher")
                .build();

        //Authors
        Author author = Author.builder()
                .firstName("Mark")
                .lastName("Twain")
                .build();

        author.addBook(book);
        author.addBook(secondTwainBook);

        authorDao.save(author);
        bookDao.save(secondTwainBook);
        bookDao.save(book);

        //BookCopies

        BookCopy bookCopy = BookCopy.builder()
                .quality(BookQuality.GOOD)
                .state(BookState.BORROWED).build();

        book.addBookCopy(bookCopy);

        BookCopy secondTwainBookCopy = BookCopy.builder()
                .quality(BookQuality.GOOD)
                .state(BookState.BORROWED).build();
        secondTwainBook.addBookCopy(secondTwainBookCopy);

        //Reviews
        BookReview bookReviewByTom = new BookReview();
        bookReviewByTom.setReview("This is review for the book");
        book.addBookReview(bookReviewByTom);

        //Users

        User tom = User.builder()
                .firstName("Tomek")
                .lastName("Kar")
                .email("email@kar.com")
                .password("password")
                .status(UserStatus.PREMIUM)
                .registrationDate(LocalDateTime.now())
                .build();

        //Notes
        Note tomNote = new Note();
        tomNote.setNotes("Note for the Book");

        tom.addBook(bookCopy);
        tom.addReview(bookReviewByTom);
        tom.addNote(tomNote);
        userDao.save(tom);
        bookReviewDao.save(bookReviewByTom);
        bookCopyDao.save(bookCopy);
        tomNote.addBookCopy(bookCopy);
        noteDao.save(tomNote);


        User katrina = User.builder()
                .firstName("Katarzyna")
                .lastName("Kattomy")
                .email("kata@kattomy.pl")
                .password("password")
                .status(UserStatus.PREMIUM)
                .registrationDate(LocalDateTime.now())
                .build();

        katrina.addBook(secondTwainBookCopy);

        katrina.addFriend(tom);
        userDao.save(katrina);
        bookCopyDao.save(secondTwainBookCopy);


    }
}
