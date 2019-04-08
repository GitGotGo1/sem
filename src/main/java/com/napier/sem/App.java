package com.napier.sem;

import java.util.ArrayList;
import java.sql.*;
import java.util.Scanner;

public class App {
    static DatabaseManager db;

    /**
     * Connect to database and run report.
     *
     * @param args string
     */
    public static void main(String[] args) {
        db = new DatabaseManager();
        App a = new App();

        // Connect to DB
        if (args.length < 1) {
            db.connect("localhost:33060");
        } else {
            db.connect(args[0]);
        }
        // Main report
        a.menu();

        // Disconnect DB
        db.disconnect();
    }

    /**
     * Select a report menu
     */
    private void menu() {
            System.out.println("Select a function:");
            System.out.println("0 Exit the application.\n");
            System.out.println("1 All the countries in the world organised by largest population to smallest.\n");
            System.out.println("2 All the countries in a continent organised by largest population to smallest.\n");
            System.out.println("3 All the countries in a region organised by largest population to smallest.\n");
            System.out.println("4 The top N populated countries in the world where N is provided by the user.\n");
            System.out.println("5 The top N populated countries in a continent where N is provided by the user.\n");
            System.out.println("6 The top N populated countries in a region where N is provided by the user.\n");
            System.out.println("7 All the cities in the world organised by largest population to smallest.\n");
            System.out.println("8 All the cities in a continent organised by largest population to smallest.\n");
            System.out.println("9 All the cities in a region organised by largest population to smallest.\n");
            System.out.println("10 All the cities in a country organised by largest population to smallest.\n");
            System.out.println("11 All the cities in a district organised by largest population to smallest.\n");
            System.out.println("12 The top N populated cities in the world where N is provided by the user.\n");
            System.out.println("13 The top N populated cities in a continent where N is provided by the user.\n");
            System.out.println("14 The top N populated cities in a region where N is provided by the user.\n");
            System.out.println("15 The top N populated cities in a country where N is provided by the user.\n");
            System.out.println("16 The top N populated cities in a district where N is provided by the user.\n");
            System.out.println("17 All the capital cities in the world organised by largest population to smallest.\n");
            System.out.println("18 All the capital cities in a continent organised by largest population to smallest.\n");
            System.out.println("19 All the capital cities in a region organised by largest to smallest.\n");
            System.out.println("20 The top N populated capital cities in the world where N is provided by the user.\n");
            System.out.println("21 The top N populated capital cities in a continent where N is provided by the user.\n");
            System.out.println("22 The top N populated capital cities in a region where N is provided by the user.\n");
            System.out.println("23 The population of people, people living in cities, and people not living in cities in each continent.\n");
            System.out.println("24 The population of people, people living in cities, and people not living in cities in each region.\n");
            System.out.println("25 The population of people, people living in cities, and people not living in cities in each country.\n");
            System.out.println("26 The population of the world.\n");
            System.out.println("27 The population of a continent.\n");
            System.out.println("28 The population of a region.\n");
            System.out.println("29 The population of a country.\n");
            System.out.println("30 The population of a district.\n");
            System.out.println("31 The population of a city.\n");
            System.out.println("32 Chinese.\n");
            System.out.println("33 English.\n");
            System.out.println("34 Hindi.\n");
            System.out.println("35 Spanish.\n");
            System.out.println("36 Arabic.\n");
            System.out.println("37 Get Capital City.\n");
            System.out.println("38 Get top number of populated capital cities in the world where the number is provided by you\n");
            System.out.println("39 Get all capital cities in the world\n");


        Scanner input = new Scanner(System.in);
        int i;

        do {
            try {
                i = input.nextInt();
            } catch (java.util.InputMismatchException e) {
                // Clear input by taking line
                input.next();

                // Force default case
                i = -1;
            }

            switch (i) {
                case 0:
                    // Do nothing
                    break;

                case 1:
                    System.out.println("All countries by population from largest to smallest:\n");
                    printReportViews(worldCountriesByPopulationLS());
                    break;

                case 2:
                    System.out.println("Select a continent:");
                    String continent = input.next();
                    System.out.println("All the countries in a continent organised by largest population to smallest:\n");
                    printReportViews(continentCountriesByPopulationLS(continent));
                    break;

                case 3:
                    System.out.println("Select a region:");
                    String region = input.next();
                    System.out.println("All the countries in a region organised by largest population to smallest:\n");
                    printReportViews(regionCountriesByPopulationLS(region));
                    break;

                case 37:
                    System.out.println("Enter a capital city name:");
                    String choice = input.next();
                    printReportViews(CapitalCityReport(choice));
                    break;

                case 38:
                    System.out.println("provide the top number of capital cities you wish to view:");
                    choice = input.next();
                    printReportViews(TopCapitalCityReport38(choice));
                    break;

                case 39:
                    printReportViews(TopCapitalCityReport29());
                    break;

                default:
                    System.out.println("An invalid choice was selected. Please try again.");
            }

            System.out.println("\nChoose another function, or 0 to exit");
        } while (i != 0);

        System.out.println("Application has exited");
    }

    /**
     * Prints countries.
     *
     * @param countries countries to print.
     */
    void printCountries(ArrayList<Country> countries) {
        if (countries != null) {
            System.out.println(String.format("%-10s %-15s %-20s", "Name", "Continent", "Population"));
            for (Country country : countries) {
                if (country == null) {
                    continue;
                }
                String formatted_string =
                        String.format("%-10s %-15s %-20s",
                                country.Name, country.Continent, country.Population);
                System.out.println(formatted_string);
            }
        } else {
            System.out.println("No countries");
        }
    }

    /**
     * Prints report view.
     *
     * @param views report views to print.
     */
    void printReportViews(ArrayList<ReportView> views) {
        if (views != null && !views.isEmpty()) {
            System.out.println(views.get(0).getHeader());
            for (ReportView view : views) {
                if (view == null) {
                    continue;
                }

                System.out.println(view);
            }
        } else {
            System.out.println("No data returned");
        }
    }

    /**
     * The population of the world.
     *
     * @return
     */
    public ArrayList<Country> worldPopulation() {
        return null;
    }

    /**
     * The population of a continent.
     *
     * @return
     */
    public ArrayList<Country> continentPopulation(String continent) {
        return null;
    }

    /**
     * The population of a region.
     *
     * @return
     */
    public ArrayList<Country> regionPopulation(String region) {
        return null;
    }

    /**
     * The population of a country.
     *
     * @return
     */
    public ArrayList<Country> countryPopulation(String country) {
        return null;
    }

    /**
     * The population of a district.
     *
     * @return
     */
    public ArrayList<Country> districtPopulation(String district) {
        return null;
    }

    /**
     * The population of a city.
     *
     * @return
     */
    public ArrayList<Country> cityPopulation(String city) {
        return null;
    }

    /**
     * All the countries in the world organised by largest population to smallest.
     *
     * @return countries
     */
    ArrayList<ReportView> worldCountriesByPopulationLS() {
        try {
            String query =  "SELECT c.Code, c.Name, c.Continent, c.Region, c.Population, capitalCity.Name AS Capital FROM country c\n" +
                            "JOIN city capitalCity ON capitalCity.ID = c.Capital\n" +
                            "ORDER BY population DESC;";

            ResultSet results = db.query(query);
            ArrayList<ReportView> views = new ArrayList<>();
            while (results.next()) {
                CountryReportView view = new CountryReportView(results);
                views.add(view);
            }
            return views;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to fetch country");
            return null;
        }
    }

    /**
     * All the countries in a continent organised by largest population to smallest.
     *
     * @return countries
     */
    ArrayList<ReportView> continentCountriesByPopulationLS(String continent) {
        try {
            String query =  "SELECT c.Code, c.Name, c.Continent, c.Region, c.Population, capitalCity.Name AS Capital FROM country c\n" +
                    "JOIN city capitalCity ON capitalCity.ID = c.Capital\n" +
                    "WHERE c.Continent = '" + continent + "' \n" +
                    "ORDER BY population DESC;";

            ResultSet results = db.query(query);
            ArrayList<ReportView> views = new ArrayList<>();
            while (results.next()) {
                CountryReportView view = new CountryReportView(results);
                views.add(view);
            }
            return views;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to fetch country");
            return null;
        }
    }

    /**
     * All the countries in a region organised by largest population to smallest.
     *
     * @return countries
     */
    ArrayList<ReportView> regionCountriesByPopulationLS(String region) {
        try {
            String query =  "SELECT c.Code, c.Name, c.Continent, c.Region, c.Population, capitalCity.Name AS Capital FROM country c\n" +
                    "JOIN city capitalCity ON capitalCity.ID = c.Capital\n" +
                    "WHERE c.Region = '" + region + "' \n" +
                    "ORDER BY population DESC;";

            ResultSet results = db.query(query);
            ArrayList<ReportView> views = new ArrayList<>();
            while (results.next()) {
                CountryReportView view = new CountryReportView(results);
                views.add(view);
            }
            return views;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to fetch country");
            return null;
        }
    }

    /**
     * The top N populated countries in the world where N is provided by the user.
     *
     * @return
     */
    public ArrayList<Country> worldCountriesTopN(int n) {
        return null;
    }

    /**
     * The top N populated countries in a continent where N is provided by the user.
     *
     * @return
     */
    public ArrayList<Country> continentCountriesTopN(int n) {
        return null;
    }

    /**
     * The top N populated countries in a region where N is provided by the user.
     *
     * @return
     */
    public ArrayList<Country> regionCountriesTopN(int n) {
        return null;
    }

    /**
     * All the cities in the world organised by largest population to smallest.
     *
     * @return
     */
    public ArrayList<City> worldCitiesByPopulationLS() {
        return null;
    }

    /**
     * All the cities in a continent organised by largest population to smallest.
     *
     * @return
     */
    public ArrayList<City> continentCitiesByPopulationLS() {
        return null;
    }

    /**
     * All the cities in a region organised by largest population to smallest.
     *
     * @return
     */
    public ArrayList<City> regionCitiesByPopulationLS() {
        return null;
    }

    /**
     * All the cities in a country organised by largest population to smallest.
     *
     * @return
     */
    public ArrayList<City> countryCitiesByPopulationLS() {
        return null;
    }

    /**
     * All the cities in a district organised by largest population to smallest.
     *
     * @return
     */
    public ArrayList<City> districtCitiesByPopulationLS() {
        return null;
    }

    /**
     * The top N populated cities in the world where N is provided by the user.
     *
     * @return
     */
    public ArrayList<City> worldCitiesTopN(int n) {
        return null;
    }

    /**
     * The top N populated cities in a continent where N is provided by the user.
     *
     * @return
     */
    public ArrayList<City> continentCitiesTopN(int n) {
        return null;
    }

    /**
     * The top N populated cities in a region where N is provided by the user.
     *
     * @return
     */
    public ArrayList<City> regionCitiesTopN(int n) {
        return null;
    }

    /**
     * The top N populated cities in a country where N is provided by the user.
     *
     * @return
     */
    public ArrayList<City> countryCitiesTopN(int n) {
        return null;
    }

    /**
     * The top N populated cities in a district where N is provided by the user.
     *
     * @return
     */
    public ArrayList<City> districtCitiesTopN(int n) {
        return null;
    }

    /**
     * All the capital cities in the world organised by largest population to smallest.
     *
     * @return
     */
    public ArrayList<City> worldCapitalsByPopulationLS() {
        return null;
    }

    /**
     * All the capital cities in a continent organised by largest population to smallest.
     *
     * @return
     */
    public ArrayList<City> continentCapitalsByPopulationLS() {
        return null;
    }

    /**
     * All the capital cities in a region organised by largest to smallest.
     *
     * @return
     */
    public ArrayList<City> regionCapitalsByPopulationLS() {
        return null;
    }

    /**
     * The top N populated capital cities in the world where N is provided by the user.
     *
     * @return
     */
    public ArrayList<City> worldCapitalsTopN(int n) {
        return null;
    }

    /**
     * The top N populated capital cities in a continent where N is provided by the user.
     *
     * @return
     */
    public ArrayList<City> continentCapitalsTopN(int n) {
        return null;
    }

    /**
     * The top N populated capital cities in a region where N is provided by the user.
     *
     * @return
     */
    public ArrayList<City> regionCapitalsTopN(int n) {
        return null;
    }

    /**
     * The population of people, people living in cities, and people not living in cities in each continent.
     *
     * @return
     */
    public ArrayList<City> continentPopulationCitiesandRural() {
        return null;
    }

    /**
     * The population of people, people living in cities, and people not living in cities in each region.
     *
     * @return
     */
    public ArrayList<City> regionPopulationCitiesandRural() {
        return null;
    }

    /**
     * The population of people, people living in cities, and people not living in cities in each country.
     *
     * @return
     */
    public ArrayList<City> countryPopulationCitiesandRural() {
        return null;
    }



    /**
     * Capital City report
     * Prints the capital city details such as name, continent, and population.
     */
    public ArrayList<ReportView> CapitalCityReport(String cityName) {

        try {
            String query = "SELECT cities.name as Name, cities.Population as Population, country.Name as Country\n"+
                    "FROM country \n" +
                    "JOIN city as cities ON cities.ID = country.Capital \n" +
                    "WHERE cities.name LIKE '" + cityName + "'";

            ResultSet results = db.query(query);
            ArrayList<ReportView> views = new ArrayList<>();
            while (results.next()) {
                CapitalCityReportView view = new CapitalCityReportView(results);
                views.add(view);
            }
            return views;
        }
        catch(Exception e){
            System.out.println("No City Found");
            System.out.println(e.getMessage());
            return null;
        }
    }

    public ArrayList<ReportView> TopCapitalCityReport38(String topNumber) {
        try {
            String query = "SELECT t1.name AS 'Country', t2.name AS 'Name', t2.population AS 'Population' "+
            "FROM(select country.Name, country.capital FROM country) as t1, "+
            "(select city.name, city.population, city.ID FROM city) as t2 " +
            "where t1.capital = t2.id " +
            "order by t2.population DESC "+
            "LIMIT " +  topNumber + ";";

            ResultSet results = db.query(query);

            ArrayList<ReportView> views = new ArrayList<>();
            while (results.next()) {
                CapitalCityReportView view = new CapitalCityReportView(results);
                views.add(view);
            }
            return views;
        }
        catch(Exception e){
            System.out.println("No data Found");
            System.out.println(e.getMessage());
            return null;
        }
    }

    public ArrayList<ReportView> TopCapitalCityReport29() {
        try {
            String query = "SELECT "+
                    "t1.name AS 'Country', t2.name AS 'Name', t2.population AS 'Population' "+
                    "FROM (select country.Name, country.capital FROM country) AS t1, "+
                    "(select city.name, city.population, city.ID FROM city) AS t2 "+
                    "WHERE t1.capital = t2.id order by t2.population DESC; ";

            ResultSet results = db.query(query);

            ArrayList<ReportView> views = new ArrayList<>();
            while (results.next()) {
                CapitalCityReportView view = new CapitalCityReportView(results);
                views.add(view);
            }
            return views;
        }
        catch(Exception e){
            System.out.println("No data Found");
            System.out.println(e.getMessage());
            return null;
        }
    }

}
