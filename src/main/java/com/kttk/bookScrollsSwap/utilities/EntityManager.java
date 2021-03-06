package com.kttk.bookScrollsSwap.utilities;

public class EntityManager {

    private static EntityManager instance;

    public static EntityManager getInstance() {
        if (instance == null) {
            SessionConnector.createFactory();
        }
        return instance;
    }
}
