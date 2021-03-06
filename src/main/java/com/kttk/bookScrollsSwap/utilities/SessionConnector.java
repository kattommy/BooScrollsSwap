package com.kttk.bookScrollsSwap.utilities;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionConnector {

    private static SessionConnector instance;
    private static Configuration configure;

    private SessionConnector(){
       configure = new Configuration().configure();
    }

    public SessionConnector getInstance() {
        if (instance == null) {
           instance = new SessionConnector();
        }
        return this;
    }

    public static SessionFactory createFactory(){
        return configure.buildSessionFactory();
    }
}
