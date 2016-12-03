package com.example.pie.persistance;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.PersistenceException;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class HibernateInit implements ServletContextListener {

    private static SessionFactory hibernateSessionFactory;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        Configuration config = new Configuration();
        System.out.println(System.getenv("JDBC_DATABASE_URL"));
        config.setProperty("hibernate.connection.url", System.getenv("JDBC_DATABASE_URL"));
        try {
            hibernateSessionFactory = config.configure().buildSessionFactory();
        } catch (PersistenceException e ) {
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        hibernateSessionFactory.close();
    }

    public static Session getSession() {
        return hibernateSessionFactory.getCurrentSession();
    }
}
