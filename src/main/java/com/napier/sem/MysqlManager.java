package com.napier.sem;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * MySQL implementation.
 */
public final class MysqlManager extends DBManager {

    /**
     * How many attempts to make during DB connection.
     */
    public static final int CONNECTION_RETRIES = 10;

    /**
     * {@inheritDoc}
     */
    @Override
    public void create(String dbName) {
        System.out.print("create()");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void drop(String dbName) {
        System.out.print("drop()");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void connect() {
        try {
            // Load Database driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        for (int i = 0; i < CONNECTION_RETRIES; ++i) {
            System.out.println("Connecting to database...");
            try {
                // Wait a bit for db to start
                // Connect to database
                database = DriverManager.getConnection("jdbc:mysql://" + "localhost:33060" + "/world?allowPublicKeyRetrieval=true&useSSL=false", "root", "example");
                System.out.println("Successfully connected");
                break;
            } catch (SQLException sqle) {
                System.out.println("Failed to connect to database attempt " + i);
                System.out.println(sqle.getMessage());
            }

            try {
                Thread.sleep(5000);
            } catch (InterruptedException ie) {
                System.out.println("Thread interrupted? Should not happen.");
                Thread.currentThread().interrupt();
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void disconnect() {
        if (database != null) {
            try {
                // Close connection
                database.close();
            } catch (Exception e) {
                System.out.println("Error closing connection to database");
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResultSet query(String sql) {
        try {
            Statement stmt = database.createStatement();
            return stmt.executeQuery(sql);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Query Failed");
        }
        return null;
    }
}
