package com.kttk.bookScrollsSwap.model;

import com.kttk.bookScrollsSwap.enums.BookQuality;
import com.kttk.bookScrollsSwap.enums.BookState;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Created by Tom - 06.03.2021
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"note","owner"})
@Entity
public class BookCopy {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Book book;

    @Enumerated(value = EnumType.STRING)
    private BookState state;

    @Enumerated(value = EnumType.STRING)
    private BookQuality quality;

    @ManyToOne
    private User owner;

    @OneToOne
    private Note note;

    public void addOwner(User owner){
        this.owner = owner;
        owner.getOwnedBooks().add(this);
    }

    @Builder
    public BookCopy(Book book, BookState state, BookQuality quality, User owner) {
        this.book = book;
        this.state = state;
        this.quality = quality;
        this.owner = owner;
    }
}
