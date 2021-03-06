package com.kttk.bookScrollsSwap.utilities;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionConnector {


    public static SessionFactory createFactory() {
        Configuration configure = new Configuration().configure();
        return configure.buildSessionFactory();
    }
}
