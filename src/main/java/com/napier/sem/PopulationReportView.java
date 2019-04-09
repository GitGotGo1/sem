package com.napier.sem;

/**
 * Results shown in a population report
 */
public class PopulationReportView {
    /**
     * Name of the continent, region or country
     */
    public String Name;

    /**
     * Scale of this report - continent, region or country
     */
    public PopulationReportScale Scale;

    /**
     * Total population of continent/region/country
     */
    public int TotalPopulation;

    /**
     * Population of continent/region/country living in cities
     */
    public int PopulationInCities;

    /**
     * Percentage of population of continent/region/country living in cities
     */
    public float PopulationInCitiesPercent;

    /**
     * Population of continent/region/country not living in cities
     */
    public int PopulationNotInCities;

    /**
     * Percentage of population of continent/region/country not living in cities
     */
    public float PopulationNotInCitiesPercent;
}