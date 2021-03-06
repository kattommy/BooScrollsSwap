package com.kttk.bookScrollsSwap.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Tom - 06.03.2021
 */
@Data
@EqualsAndHashCode(exclude = {"bookCopies", "reviews"})
@Entity
public class Book {

    @Id
    @GeneratedValue
    private Long id;

    private String title;

    @ManyToOne
    private Author author;

    private String Publisher;
    private String isbn;

    @OneToMany(mappedBy = "book")
    private Set<BookCopy> bookCopies;

    @OneToMany(mappedBy = "book")
    private Set<BookReview> reviews;

    public void addBookCopy(BookCopy bookCopy){
        bookCopies.add(bookCopy);
        bookCopy.setBook(this);
    }

    public void addBookReview(BookReview bookReview){
        reviews.add(bookReview);
        bookReview.setBook(this);
    }
}
