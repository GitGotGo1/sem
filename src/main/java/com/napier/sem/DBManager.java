package com.napier.sem;

import java.sql.Connection;
import java.sql.ResultSet;

/**
 * Base database implementation.
 */
interface DBManager {
    /**
     * Create a DB.
     *
     * @param dbName String
     */
    void create(String dbName);

    /**
     * Drop a DB.
     *
     * @param dbName String
     */
    void drop(String dbName);

    /**
     * Connect to the DB.
     */
    void connect();

    /**
     * Disconnect from the DB connection.
     */
    void disconnect();

    /**
     * Returns the DB connection object if it exists, otherwise restarts the connection.
     *
     * @return Connection
     */
    Connection getConnection();

    /**
     * Runs DB query.
     *
     * @param sql String
     * @return ResultSet
     */
    ResultSet query(String sql);
}
