package com.napier.sem;

/**
 * Database driver factory.
 */
class DBManagerFactory {

    /**
     * Private constructor.
     */
    private DBManagerFactory() {
    }

    /**
     * Returns specified database instance.
     *
     * @param dbType String
     * @return DBManager
     */
    static DBManager getInstance(final String dbType) {
        switch (dbType) {
            case "mysql":
                return new MysqlManager();
            default:
                throw new IllegalArgumentException();
        }
    }
}
