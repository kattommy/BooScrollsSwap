package com.kttk.bookScrollsSwap.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Data
@Entity
public class Note {

    @Id
    @GeneratedValue
    private Long id;

    private String notes;

    @ManyToOne
    private User user;

    @ManyToOne
    private BookCopy bookCopy;
}
