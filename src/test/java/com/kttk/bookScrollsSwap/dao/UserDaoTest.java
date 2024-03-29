package com.kttk.bookScrollsSwap.dao;

import com.kttk.bookScrollsSwap.model.User;
import com.kttk.bookScrollsSwap.utilities.SessionConnector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {

    UserDao dao;

    User user;

    @BeforeEach
    void setUp() {
        dao = new UserDao(SessionConnector.getInstance().createH2Factory());

        user = new User();
        user.setFirstName("Kasia");
        user.setLastName("Misiewicz");
    }

    @Test
    void findAll() {
        User secondUser = new User();
        dao.save(user);
        dao.save(secondUser);

        final List<User> users = dao.findAll(User.class);

        assertEquals(2, users.size());
    }

    @Test
    void findById() {
        User savedUser = dao.save(user);

        final User foundUser = dao.find(User.class, savedUser.getId());

        assertNotNull(foundUser);
        assertEquals("Misiewicz",foundUser.getLastName());
    }

    @Test
    void save() {
        final User save = dao.save(user);

        assertNotNull(save);
    }

    @Test
    void deleteById() {
       User deleteUser = dao.save(user);

        dao.deleteById(User.class,deleteUser.getId());

        final User userById = dao.find(User.class,user.getId());

        assertNull(userById);
    }

    @Test
    void update() {
        final User savedUser = dao.save(user);
        savedUser.setFirstName("Katarzyna");

        final User updated = dao.update(savedUser);

        assertEquals("Katarzyna",updated.getFirstName());
    }

    @Test
    void findByPassword() {
        String EMAIL = "tomek@tk.com";
        user.setEmail(EMAIL);
        dao.save(user);

        final Optional<User> byPassword = dao.findByEmail(EMAIL);

        assertTrue(byPassword.isPresent());
        assertEquals(EMAIL, byPassword.get().getEmail());
    }

}