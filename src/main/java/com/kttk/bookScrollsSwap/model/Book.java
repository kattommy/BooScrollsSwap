package com.kttk.bookScrollsSwap.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Tom - 06.03.2021
 */
@Data
@EqualsAndHashCode(exclude = {"bookCopies", "reviews"})
@NoArgsConstructor
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
        if(bookCopies == null){
            bookCopies = new HashSet<>();
        }
        bookCopies.add(bookCopy);
        bookCopy.setBook(this);
    }

    public void addBookReview(BookReview bookReview){
        if(reviews == null){
            reviews = new HashSet<>();
        }
        reviews.add(bookReview);
        bookReview.setBook(this);
    }

    @Builder
    public Book(String title, Author author, String publisher, String isbn) {
        this.title = title;
        this.author = author;
        Publisher = publisher;
        this.isbn = isbn;
    }
}
