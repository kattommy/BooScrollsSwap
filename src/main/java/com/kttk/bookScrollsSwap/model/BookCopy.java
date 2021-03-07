package com.kttk.bookScrollsSwap.model;

import com.kttk.bookScrollsSwap.enums.BookQuality;
import com.kttk.bookScrollsSwap.enums.BookState;
import lombok.Data;

import javax.persistence.*;

/**
 * Created by Tom - 06.03.2021
 */
@Data
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

    public void addOwner(User owner){
        this.owner = owner;
        owner.getOwnedBooks().add(this);
    }
}
