package com.example.pie.listeners;

import com.example.pie.persistance.PersistenceManager;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // Initialize the persistence manager
        //noinspection ResultOfMethodCallIgnored
        PersistenceManager.getInstance();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        PersistenceManager.getInstance().tearDown();
    }
}
