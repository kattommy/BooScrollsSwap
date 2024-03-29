package com.kttk.bookScrollsSwap.controller;


import com.kttk.bookScrollsSwap.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuController {
   private final UserController userController;

    public MenuController(UserController userController) {
        this.userController = userController;
    }

    public void run() {
        Scanner sc = new Scanner(System.in);
        ConsoleMenu consoleMenu = buildMenu();

        while (true) {
            consoleMenu.display();
            int option = sc.nextInt();

            switch (option) {
                case 1:
                    userController.createUser();
                    break;
                case 2:
                    System.out.println("You are leaving the application, please come back");
                    return;
                default:
                    System.out.println("Invalid number. Please try again");
            }
        }
    }

    private static ConsoleMenu buildMenu() {

        List<String> options = new ArrayList<>();
        options.add("Create user.");
        options.add("Log into your account.");
        options.add("Log out of your account.");
        options.add("Add book to your bookshelf.");
        options.add("Delete book from your bookshelf.");
        options.add("Add note.");
        options.add("Add friend.");
        options.add("Rent a book from your friend.");

        String header = "Welcome to BooStrollsSwap app";

        return new ConsoleMenu(header, options);
    }
}
