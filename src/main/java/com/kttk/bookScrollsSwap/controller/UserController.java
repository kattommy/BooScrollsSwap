package com.kttk.bookScrollsSwap.controller;

import com.kttk.bookScrollsSwap.services.UserServiceImpl;
import com.kttk.bookScrollsSwap.utilities.UserCreator;

public class UserController {
    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }


    public void createUser(){
        UserCreator.createUser();

    }

    public void login(){

    }
}
