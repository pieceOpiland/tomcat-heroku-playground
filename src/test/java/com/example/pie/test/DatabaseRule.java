package com.example.pie.test;

import org.junit.rules.ExternalResource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class DatabaseRule extends ExternalResource {

    @Override
    protected void before() throws Throwable {
        executeFile("/populate.sql");
    }

    @Override
    protected void after() {
        executeFile("/clear.sql");
    }

    private static boolean executeFile(String filename) {
        String jdbcUrl = System.getenv("JDBC_DATABASE_URL");
        try {
            Class.forName("org.postgresql.Driver");

            Scanner scanner = new Scanner(Class.class.getResourceAsStream(filename));

            Connection connection = DriverManager.getConnection(jdbcUrl);

            scanner.useDelimiter(";");

            while (scanner.hasNext()) {
                connection.prepareStatement(scanner.next()).execute();
            }

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
