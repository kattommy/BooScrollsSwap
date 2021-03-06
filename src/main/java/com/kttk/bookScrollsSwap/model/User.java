package com.kttk.bookScrollsSwap.model;

import com.kttk.bookScrollsSwap.enums.UserStatus;
import lombok.Data;
import org.hibernate.type.LocalDateType;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private LocalDateType registrationDate;

    @Enumerated(value = EnumType.STRING)
    private UserStatus status;

    @ManyToMany
    private Set<User> friends = new HashSet();
}
