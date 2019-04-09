package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TestAppIntegration {
    static App app;
    static DatabaseManager db;

    @BeforeAll
    static void init() {
        app = new App();
        db = new DatabaseManager();
        db.connect("localhost:33060");
    }

    @Test
    void worldCountriesByPopulationLS() {
        app.worldCountriesByPopulationLS();
    }
}
