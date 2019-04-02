package com.napier.sem;

abstract class DBManager {
    protected String database;
    protected Integer queryTime;
    protected String lastError;
    protected String lastResult;

    public String getDatabase() {
        return database;
    }
    public abstract void connect();
    public abstract void disconnect();
}
