package com.kttk.bookScrollsSwap;

import com.kttk.bookScrollsSwap.controller.MenuController;
import com.kttk.bookScrollsSwap.controller.UserController;
import com.kttk.bookScrollsSwap.dao.UserDao;
import com.kttk.bookScrollsSwap.services.UserServiceImpl;
import com.kttk.bookScrollsSwap.utilities.SessionConnector;
import org.hibernate.SessionFactory;

public class Main {
    public static void main(String[] args) {
        final SessionFactory factory = SessionConnector.getInstance().createFactory();
        final UserDao userDao = new UserDao(factory);
        final UserServiceImpl userService = new UserServiceImpl(userDao);

        final UserController userController = new UserController(userService);
        MenuController menuController = new MenuController(userController);

        menuController.run();
    }
}
