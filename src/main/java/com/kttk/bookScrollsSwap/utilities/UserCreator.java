package com.kttk.bookScrollsSwap.utilities;

import com.kttk.bookScrollsSwap.model.User;

import java.util.Scanner;

public class UserCreator {

    public static User createUser(){
        Scanner sc = new Scanner(System.in);
        User user = new User();

        System.out.println("Enter your name");
        String name = sc.nextLine();
        user.setFirstName(name);

        System.out.println("Enter your last name");
        String lastName = sc.nextLine();
        user.setLastName(lastName);

        System.out.println("Enter your email");
        String email = sc.nextLine();
        user.setEmail(email);

        System.out.println("Enter password");
        String password = sc.nextLine();
        user.setPassword(password);

        return user;
    }
}
