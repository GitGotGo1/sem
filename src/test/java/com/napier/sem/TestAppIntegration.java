package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type Test app integration.
 */
class TestAppIntegration {
    /**
     * The App.
     */
    static App app;
    /**
     * The Db.
     */
    static DatabaseManager db;

    /**
     * Init.
     */
    @BeforeAll
    static void init() {
        app = new App();
        db = new DatabaseManager();
        db.connect("localhost:33060");
    }

    /**
     * World countries by population ls.
     */
    @Test
    void worldCountriesByPopulationLS() {
        app.worldCountriesByPopulationLS();
    }
}
