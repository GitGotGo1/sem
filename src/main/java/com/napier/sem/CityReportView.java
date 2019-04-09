package com.napier.sem;

import java.sql.ResultSet;

/**
 * Results shown in a city report
 */
public class CityReportView extends ReportView {
    /**
     * City Name
     */
    public String Name;

    /**
     * Country Name
     */
    public String Country;

    /**
     * City District
     */
    public String District;

    /**
     * City Population
     */
    public long Population;

    public CityReportView(ResultSet results) {
        try {
            Name = results.getString("Name");
            Country = results.getString("Country");
            District = results.getString("District");
            Population = results.getLong("Population");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to fetch city report view");
        }
    }

    public String getHeader() {
        return String.format("%-20s %-50s %-30s %-15s",
                "Name", "Country", "District", "Population");
    }

    public String toString() {
        return String.format("%-20s %-50s %-30s %-15s",
                Name, Country, District, Population);
    }
}