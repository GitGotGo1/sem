package com.napier.sem;

/**
 * Database driver factory.
 */
class DBManagerFactory {

    /**
     * Private constructor for utility class.
     */
    private DBManagerFactory() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Returns specified database instance.
     *
     * @param dbType String
     * @return DBManager
     */
    public static DBManager getInstance(final String dbType) {
        switch (dbType) {
            case "mysql":
                return new MysqlManager();
            default:
                throw new IllegalArgumentException();
        }
    }
}
