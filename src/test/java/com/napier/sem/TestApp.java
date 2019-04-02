package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type Test app.
 */
class TestApp {
    /**
     * The App.
     */
    static App app;

    /**
     * Init.
     */
    @BeforeAll
    static void init() {
        app = new App();
    }

    /**
     * Print countries null test.
     */
    @Test
    void printCountriesNullTest() {
        app.printCountries(null);
    }

    /**
     * Print countries test empty.
     */
    @Test
    void printCountriesTestEmpty() {
        ArrayList<Country> countries = new ArrayList<>();
        app.printCountries(countries);
    }

    /**
     * Print countries test contains null.
     */
    @Test
    void printCountriesTestContainsNull() {
        ArrayList<Country> countries = new ArrayList<>();
        countries.add(null);
        app.printCountries(countries);
    }

    /**
     * Print countries test.
     */
    @Test
    void printCountriesTest() {
        ArrayList<Country> countries = new ArrayList<>();
        Country country = new Country();
        country.Code = "ABW";
        country.Name = "Aruba";
        country.Continent = "North America";
        country.Region = "Caribbean";
        country.SurfaceArea = 193.00f;
        country.IndepYear = 1;
        country.Population = 103000;
        country.LifeExpectancy = 78.4f;
        country.GNP = 828.00f;
        country.GNPOld = 793.00f;
        country.LocalName = "Aruba";
        country.GovernmentForm = "Nonmetropolitan Territory of The Netherlands";
        country.HeadOfState = "Beatrix";
        country.Capital = 129;
        country.Code2 = "AW";

        countries.add(country);
        app.printCountries(countries);
    }

    /**
     * Gets cities.
     */
    @Test
    void getCities() {
    }

    /**
     * Gets languages.
     */
    @Test
    void getLanguages() {
    }

    /**
     * World population.
     */
    @Test
    void worldPopulation() {
    }

    /**
     * Continent population.
     */
    @Test
    void continentPopulation() {
    }

    /**
     * Region population.
     */
    @Test
    void regionPopulation() {
    }

    /**
     * Country population.
     */
    @Test
    void countryPopulation() {
    }

    /**
     * District population.
     */
    @Test
    void districtPopulation() {
    }

    /**
     * City population.
     */
    @Test
    void cityPopulation() {
    }

    /**
     * Continent countries by population ls.
     */
    @Test
    void continentCountriesByPopulationLS() {
    }

    /**
     * Region countries by population ls.
     */
    @Test
    void regionCountriesByPopulationLS() {
    }

    /**
     * World countries top n.
     */
    @Test
    void worldCountriesTopN() {
    }

    /**
     * Continent countries top n.
     */
    @Test
    void continentCountriesTopN() {
    }

    /**
     * Region countries top n.
     */
    @Test
    void regionCountriesTopN() {
    }

    /**
     * World cities by population ls.
     */
    @Test
    void worldCitiesByPopulationLS() {
    }

    /**
     * Continent cities by population ls.
     */
    @Test
    void continentCitiesByPopulationLS() {
    }

    /**
     * Region cities by population ls.
     */
    @Test
    void regionCitiesByPopulationLS() {
    }

    /**
     * Country cities by population ls.
     */
    @Test
    void countryCitiesByPopulationLS() {
    }

    /**
     * District cities by population ls.
     */
    @Test
    void districtCitiesByPopulationLS() {
    }

    /**
     * World cities top n.
     */
    @Test
    void worldCitiesTopN() {
    }

    /**
     * Continent cities top n.
     */
    @Test
    void continentCitiesTopN() {
    }

    /**
     * Region cities top n.
     */
    @Test
    void regionCitiesTopN() {
    }

    /**
     * Country cities top n.
     */
    @Test
    void countryCitiesTopN() {
    }

    /**
     * District cities top n.
     */
    @Test
    void districtCitiesTopN() {
    }

    /**
     * World capitals by population ls.
     */
    @Test
    void worldCapitalsByPopulationLS() {
    }

    /**
     * Continent capitals by population ls.
     */
    @Test
    void continentCapitalsByPopulationLS() {
    }

    /**
     * Region capitals by population ls.
     */
    @Test
    void regionCapitalsByPopulationLS() {
    }

    /**
     * World capitals top n.
     */
    @Test
    void worldCapitalsTopN() {
    }

    /**
     * Continent capitals top n.
     */
    @Test
    void continentCapitalsTopN() {
    }

    /**
     * Region capitals top n.
     */
    @Test
    void regionCapitalsTopN() {
    }

    /**
     * Continent population citiesand rural.
     */
    @Test
    void continentPopulationCitiesandRural() {
    }

    /**
     * Region population citiesand rural.
     */
    @Test
    void regionPopulationCitiesandRural() {
    }

    /**
     * Country population citiesand rural.
     */
    @Test
    void countryPopulationCitiesandRural() {
    }
}
