package com.kttk.bookScrollsSwap.controller;

import com.kttk.bookScrollsSwap.model.User;
import com.kttk.bookScrollsSwap.services.UserServiceImpl;
import com.kttk.bookScrollsSwap.utilities.UserCreator;

public class UserController {
    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }


    public void createUser() {
        User user = UserCreator.createUser();
        String email = user.getEmail();
        if (userService.findByEmail(email).isEmpty()) {
            userService.save(user);
        } else {
            System.out.println("This email exist. Use another email");
            createUser();
        }
    }
    public void login() {

    }
}
