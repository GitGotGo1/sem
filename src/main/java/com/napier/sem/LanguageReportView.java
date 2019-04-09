package com.napier.sem;

import java.sql.ResultSet;

/**
 * Represents a country language
 */
public class LanguageReportView extends ReportView {
    /**
     * Language
     */
    public String Language;

    /**
     * Speakers of Language (total)
     */
    public long NumberOfSpeakers;

    /**
     * Speakers of Language (as percent of world population)
     */
    public float PercentageOfSpeakers;

    public LanguageReportView(ResultSet results) {
        try {
            Language = results.getString("Language");
            NumberOfSpeakers = results.getInt("Number Of Speakers");
            PercentageOfSpeakers = results.getFloat("Percentage Of Speakers");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to fetch language report view");
        }
    }

    public String getHeader() {
        return String.format("%-20s %-15s %-15s",
                "Language", "Number Of Speakers", "Percentage Of Speakers");
    }

    public String toString() {
        return String.format("%-20s %-15s %-15s",
                Language, NumberOfSpeakers, PercentageOfSpeakers);
    }
}