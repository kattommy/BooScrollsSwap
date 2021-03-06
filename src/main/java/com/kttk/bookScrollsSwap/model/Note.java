package com.kttk.bookScrollsSwap.model;

import lombok.Data;

@Data
public class Note {

    private Long id;
    private String notes;
    private User user;
    private BookCopy bookCopy;
}
