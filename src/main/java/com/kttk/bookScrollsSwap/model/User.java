package com.kttk.bookScrollsSwap.model;

import com.kttk.bookScrollsSwap.enums.UserStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.type.LocalDateType;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@EqualsAndHashCode(exclude = {"friends", "reviews","status", "ownedBooks","registrationDate"})
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
    @JoinTable(name = "friends",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "friend_id")
    )
    private Set<User> friends = new HashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<BookReview> reviews = new HashSet<>();

    @OneToMany(mappedBy = "owner")
    private Set<BookCopy> ownedBooks = new HashSet<>();

    private void addFriend(User friend){
        if(!friends.contains(friend)){
            friends.add(friend);
            friend.addFriend(this);
        }
    }

    private void addReview(BookReview review){
        reviews.add(review);
        review.setUser(this);
    }

    private void addBook(BookCopy bookCopy){
        ownedBooks.add(bookCopy);
        bookCopy.setOwner(this);
    }
}
