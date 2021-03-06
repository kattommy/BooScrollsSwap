package com.kttk.bookScrollsSwap.utilities;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionConnector {

    private static SessionConnector instance;

    private SessionConnector(){
        Configuration configure = new Configuration().configure();
    }

    public SessionConnector getInstance() {
        if (instance == null) {
           instance = new SessionConnector();
        }
        return this;
    }
}
