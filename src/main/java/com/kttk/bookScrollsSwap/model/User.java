package com.kttk.bookScrollsSwap.model;

import com.kttk.bookScrollsSwap.enums.UserStatus;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@EqualsAndHashCode(exclude = {"friends", "reviews","status", "ownedBooks","registrationDate", "notes"})
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String firstName;
    private String lastName;

    @Column(unique = true)
    private String email;

    private String password;
    private LocalDateTime registrationDate;

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

    @OneToMany(mappedBy = "user")
    private Set<Note> notes = new HashSet<>();

    @Builder
    public User(String firstName, String lastName, String email, String password, LocalDateTime registrationDate,
                UserStatus status, Set<User> friends, Set<BookReview> reviews, Set<BookCopy> ownedBooks) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.registrationDate = registrationDate;
        this.status = status;
        this.friends = friends;
        this.reviews = reviews;
        this.ownedBooks = ownedBooks;
    }

    public void addFriend(User friend){
        if(friends == null){
            friends =  new HashSet<>();
        }
        if(!friends.contains(friend)){
            friends.add(friend);
            friend.addFriend(this);
        }
    }

    public void addReview(BookReview review){
        if(reviews == null){
            reviews =  new HashSet<>();
        }
        reviews.add(review);
        review.setUser(this);
    }

    public void addBook(BookCopy bookCopy){
        if(ownedBooks==null){
            ownedBooks = new HashSet<>();
        }
        ownedBooks.add(bookCopy);
        bookCopy.setOwner(this);
    }

    public void addNote(Note note){
        if(notes == null){
            notes = new HashSet<>();
        }
        notes.add(note);
        note.setUser(this);
    }
}
