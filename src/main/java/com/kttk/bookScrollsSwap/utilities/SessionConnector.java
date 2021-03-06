package com.kttk.bookScrollsSwap.utilities;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionConnector {

    private static SessionConnector instance;
    private static Configuration configure;

    private SessionConnector(){
       configure = new Configuration().configure();
    }

    public static SessionConnector getInstance() {
        if (instance == null) {
           instance = new SessionConnector();
        }
        return instance;
    }

    public SessionFactory createFactory(){
         return configure.configure("hibernate.cfg.xml").buildSessionFactory();
    }

    public SessionFactory createH2Factory(){
        return configure.configure("hibernate-h2.cfg.xml").buildSessionFactory();
    }
}
