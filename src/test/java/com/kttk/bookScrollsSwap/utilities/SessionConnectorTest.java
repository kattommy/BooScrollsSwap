package com.kttk.bookScrollsSwap.utilities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManagerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class SessionConnectorTest {
    SessionConnector instance;

    @BeforeEach
    void setUp() {
        instance = SessionConnector.getInstance();
    }

    @Test
    void getInstance() {
        final SessionConnector newInstance = SessionConnector.getInstance();

        assertEquals(instance, newInstance);
    }

    @Test
    void createFactory() {
        EntityManagerFactory factory = instance.createFactory();

        assertNotNull(factory);
    }
}