package com.napier.sem;

/**
 * Generates queries for capital city reports
 *
 * User inputs are represented by '?' - this will be replaced in prepared statements we'll send to the DB
 */
public class PopulationReportGenerator {
    /**
     * Generates a SQL query to return the population details of a country
     */
    public static String GenerateQuery_PopulationDifferencesCountry(String country) {
        return
            "SELECT \n" +
            "    country.Name \n" +
            "        AS '" + PopulationReportScale.Country.name() + "', \n" +
            "    country.Population\n" +
            "        AS 'Total Population', \n" +
            "    SUM(city.Population) \n" +
            "        AS 'Population Living in Cities',\n" +
            "    (SUM(city.Population) / country.Population) * 100 \n" +
            "        AS 'Population Living in Cities (%)',\n" +
            "    country.Population - SUM(city.Population) \n" +
            "        AS 'Population Not Living in Cities',\n" +
            "    ((country.Population - SUM(city.Population)) / country.Population) * 100 \n" +
            "        AS 'Population Not Living in Cities (%)'\n" +
            "FROM country\n" +
            "JOIN city ON city.CountryCode = country.Code\n" +
            "WHERE country.name LIKE '" + country + "'\n" +
            "GROUP BY country.Name, country.Population";
    }

    /**
     * Generates a SQL query to return the population details of a region
     */
    public static String GenerateQuery_PopulationDifferencesRegion(String region) {
        return
            "SELECT \n" +
            "    country.Region\n" +
            "        AS '" + PopulationReportScale.Region.name() + "', \n" +
            "    SUM(country.Population)\n" +
            "        AS 'Total Population', \n" +
            "    SUM(city.Population) \n" +
            "        AS 'Population Living in Cities',\n" +
            "    (SUM(city.Population) / SUM(country.Population)) * 100 \n" +
            "        AS 'Population Living in Cities (%)',\n" +
            "    SUM(country.Population) - SUM(city.Population) \n" +
            "        AS 'Population Not Living in Cities',\n" +
            "    ((SUM(country.Population) - SUM(city.Population)) / SUM(country.Population)) * 100 \n" +
            "        AS 'Population Not Living in Cities (%)'\n" +
            "FROM country\n" +
            "JOIN city ON city.CountryCode = country.Code\n" +
            "GROUP BY country.Region\n" +
            "HAVING country.Region LIKE '" + region + "'";
    }

    /**
     * Generates a SQL query to return the population details of a continent
     */
    public static String GenerateQuery_PopulationDifferencesContinent(String continent) {
        return
            "SELECT \n" +
            "    country.Continent\n" +
            "        AS '" + PopulationReportScale.Continent.name() + "', \n" +
            "    SUM(country.Population)\n" +
            "        AS 'Total Population', \n" +
            "    SUM(city.Population) \n" +
            "        AS 'Population Living in Cities',\n" +
            "    (SUM(city.Population) / SUM(country.Population)) * 100 \n" +
            "        AS 'Population Living in Cities (%)',\n" +
            "    SUM(country.Population) - SUM(city.Population) \n" +
            "        AS 'Population Not Living in Cities',\n" +
            "    ((SUM(country.Population) - SUM(city.Population)) / SUM(country.Population)) * 100 \n" +
            "        AS 'Population Not Living in Cities (%)'\n" +
            "FROM country\n" +
            "JOIN city ON city.CountryCode = country.Code\n" +
            "GROUP BY country.Continent\n" +
            "HAVING country.Continent LIKE '" + continent + "'";
    }
}