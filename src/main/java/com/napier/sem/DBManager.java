package com.napier.sem;

import java.sql.Connection;
import java.sql.ResultSet;

/**
 * Base database implementation.
 */
abstract class DBManager {

    /**
     * Connection to database.
     */
    public Connection database = null;

    /**
     * Create a DB.
     *
     * @param dbName String
     */
    public abstract void create(String dbName);

    /**
     * Drop a DB.
     *
     * @param dbName String
     */
    public abstract void drop(String dbName);

    /**
     * Connect to the DB.
     */
    public abstract void connect();

    /**
     * Disconnect from the DB connection.
     */
    public abstract void disconnect();

    /**
     * Runs DB query.
     *
     * @param sql String
     * @return ResultSet
     */
    public abstract ResultSet query(String sql);

    /**
     * Returns the current database.
     *
     * @return Connection
     */
    public Connection getDatabase() {
        checkConnection();
        return database;
    }

    /**
     * Checks the DB connection, if not found then reconnect.
     */
    public void checkConnection() {
        if (database == null) {
            connect();
        }
    }
}
