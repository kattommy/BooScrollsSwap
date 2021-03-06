package com.kttk.bookScrollsSwap.model;

import lombok.Data;
import org.hibernate.type.LocalDateType;

import java.util.HashSet;
import java.util.Set;

@Data
public class User {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private LocalDateType registrationDate;
    private String status;
    private Set friends = new HashSet();

}
