package com.napier.sem;

import java.sql.ResultSet;

/**
 * Results shown in a population report
 */
public class PopulationReportView extends ReportView {
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
    public long TotalPopulation;

    /**
     * Population of continent/region/country living in cities
     */
    public long PopulationInCities;

    /**
     * Percentage of population of continent/region/country living in cities
     */
    public float PopulationInCitiesPercent;

    /**
     * Population of continent/region/country not living in cities
     */
    public long PopulationNotInCities;

    /**
     * Percentage of population of continent/region/country not living in cities
     */
    public float PopulationNotInCitiesPercent;

    public PopulationReportView(ResultSet results, PopulationReportScale scale) {
        try {
            Scale = scale;

            Name = results.getString(Scale.name());
            TotalPopulation = results.getLong("Total Population");
            PopulationInCities = results.getLong("Population Living in Cities");
            PopulationInCitiesPercent = results.getInt("Population Living in Cities (%)");
            PopulationNotInCities = results.getLong("Population Not Living in Cities");
            PopulationNotInCitiesPercent = results.getLong("Population Not Living in Cities (%)");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to fetch population report view");
        }
    }

    public String getHeader() {
        return String.format("%-40s %-35s %-35s %-35s %-35s",
                Scale.name(),
                "Population Living in Cities", "Population Living in Cities (%)",
                "Population Not Living in Cities", "Population Not Living in Cities (%)");
    }

    public String toString() {
        return String.format("%-40s %-35s %-35s %-35s %-35s",
                Name, TotalPopulation, PopulationInCities, PopulationInCitiesPercent, PopulationNotInCities, PopulationNotInCitiesPercent);
    }
}