package com.napier.sem;

import java.sql.ResultSet;

/**
 * Results shown in a capital city report
 */
public class CapitalCityReportView extends ReportView {
    /**
     * City Name
     */
    private String Name;

    /**
     * Country Name
     */
    private String Country;

    /**
     * City Population
     */
    private int Population;

    /**
     * Instantiates a new Capital city report view.
     *
     * @param results the results
     */
    public CapitalCityReportView(ResultSet results) {
        try {
            Name = results.getString("Name");
            Country = results.getString("Country");
            Population = results.getInt("Population");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to fetch country report view");
        }
    }

    public String getHeader() {
        return String.format("%-20s %-50s %-15s",
                "Name", "Country", "Population");
    }

    public String toString() {
        return String.format("%-20s %-50s %-15s",
                Name, Country, Population);
    }
}