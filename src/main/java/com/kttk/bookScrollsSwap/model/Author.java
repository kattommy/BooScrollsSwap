package com.kttk.bookScrollsSwap.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Tom - 06.03.2021
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(exclude = "books")
@Entity
public class Author {

    @Id
    @GeneratedValue
    private Long id;

    private String firstName;
    private String lastName;

    @OneToMany(mappedBy = "author")
    private Set<Book> books = new HashSet<>();

    public void addBook(Book book){
        if(books==null){
            books = new HashSet<>();
        }
        books.add(book);
        book.setAuthor(this);
    }

    @Builder
    public Author(String firstName, String lastName, Set<Book> books) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.books = books;
    }
}
