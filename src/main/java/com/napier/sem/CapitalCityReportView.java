package com.napier.sem;

import java.sql.ResultSet;

/**
 * Results shown in a capital city report
 */
public class CapitalCityReportView extends ReportView {
    /**
     * City Name
     */
    public String Name;

    /**
     * Country Name
     */
    public String Country;

    /**
     * City Population
     */
    public int Population;

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