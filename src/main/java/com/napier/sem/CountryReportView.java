package com.napier.sem;

import java.sql.ResultSet;

/**
 * Results shown in a country report
 */
public class CountryReportView extends ReportView {
    /**
     * Country Code
     */
    public String Code;

    /**
     * Country Name
     */
    public String Name;

    /**
     * Country Continent
     */
    public String Continent;

    /**
     * Country Region
     */
    public String Region;

    /**
     * Country Population
     */
    public int Population;

    /**
     * Country Capital City Name
     */
    public String Capital;

    /**
     * Instantiates a new Country report view.
     *
     * @param results the results
     */
    public CountryReportView(ResultSet results) {
        try {
            Code = results.getString("Code");
            Name = results.getString("Name");
            Continent = results.getString("Continent");
            Region = results.getString("Region");
            Population = results.getInt("Population");
            Capital = results.getString("Capital");;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to fetch country report view");
        }
    }

    public String getHeader() {
        return String.format("%-5s %-50s %-20s %-30s %-15s %-20s",
                "Code", "Name", "Continent", "Region", "Population", "Capital");
    }

    public String toString() {
        return String.format("%-5s %-50s %-20s %-30s %-15s %-20s",
                Code, Name, Continent, Region, Population, Capital);
    }
}