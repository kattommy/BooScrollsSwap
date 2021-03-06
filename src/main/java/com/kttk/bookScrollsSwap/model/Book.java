package com.kttk.bookScrollsSwap.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Tom - 06.03.2021
 */
@Data
@EqualsAndHashCode(exclude = "author")
@Entity
public class Book {

    @Id
    @GeneratedValue
    private Long id;

    private String title;

    @OneToOne
    private Author author;
    private String Publisher;
    private String isbn;

    @OneToMany
    private Set<BookCopy> bookCopies;
}
