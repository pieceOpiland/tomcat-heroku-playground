package com.example.pie.persistance;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.PersistenceException;

public final class PersistenceManager {

    private static class Holder {
        private static PersistenceManager INSTANCE = new PersistenceManager();
    }

    private SessionFactory factory;

    private PersistenceManager() {
        Configuration config = new Configuration();
        config.setProperty("hibernate.connection.url", System.getenv("JDBC_DATABASE_URL"));
        try {
            factory = config.configure().buildSessionFactory();
        } catch (PersistenceException e ) {
            e.printStackTrace();
        }
    }

    public static PersistenceManager getInstance() {
        return Holder.INSTANCE;
    }

    public void tearDown() {
        factory.close();
    }

    public Session getSession() {
        return factory.getCurrentSession();
    }
}
