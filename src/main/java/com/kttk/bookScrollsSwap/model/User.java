package com.kttk.bookScrollsSwap.model;

import com.kttk.bookScrollsSwap.enums.UserStatus;
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
    private UserStatus status;
    private Set<User> friends = new HashSet();

}
