package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class TestAppIntegration {
    static App app;
    DBManager db;

    @BeforeAll
    static void init() {
        app = new App();
        DBManager db = DBManagerFactory.getInstance("mysql");
    }

    @Test
    void worldCountriesByPopulationLS() {
        app.worldCountriesByPopulationLS();
    }
}
