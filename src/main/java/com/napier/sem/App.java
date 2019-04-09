package com.napier.sem;

import java.sql.ResultSet;
import java.util.ArrayList;
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
            System.out.println("40 Get all capital cities in a given continent\n");
            System.out.println("41 Get a limited number of capital cities in a provided continent\n");
            System.out.println("42 Get a limited number of capital cities in a provided region \n");

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

                case 1: {
                    System.out.println("All countries by population from largest to smallest:\n");
                    printReportViews(worldCountriesByPopulationLS());
                }
                    break;

                case 2: {
                    System.out.println("Select a continent:");
                    String continent = input.next();
                    System.out.println("All the countries in a continent organised by largest population to smallest:\n");
                    printReportViews(continentCountriesByPopulationLS(continent));
                }
                    break;

                case 3: {
                    System.out.println("Select a region:");
                    String region = input.next();
                    System.out.println("All the countries in a region organised by largest population to smallest:\n");
                    printReportViews(regionCountriesByPopulationLS(region));
                }
                    break;

                case 4: {
                    System.out.println("Select number of countries to show:");
                    int n = input.nextInt();
                    System.out.println("Top populated countries in the world:\n");
                    printReportViews(worldCountriesTopN(n));
                }
                    break;

                case 5: {
                    System.out.println("Select number of countries to show:");
                    int n = input.nextInt();
                    System.out.println("Select continent:");
                    String continent = input.next();
                    System.out.println("Top populated countries in a continent:\n");
                    printReportViews(continentCountriesTopN(n, continent));
                }
                    break;

                case 6: {
                    System.out.println("Select number of countries to show:");
                    int n = input.nextInt();
                    System.out.println("Select region:");
                    String region = input.next();
                    System.out.println("Top populated countries in a region:\n");
                    printReportViews(regionCountriesTopN(n, region));
                }
                    break;

                case 37: {
                    System.out.println("Enter a capital city name:");
                    String choice = input.next();
                    printReportViews(CapitalCityReport(choice));
                }
                    break;

                case 38:
                    System.out.println("provide the top number of capital cities you wish to view:");
                    String choice = input.next();
                    printReportViews(TopCapitalCityReport38(choice));
                    break;

                case 39:
                    printReportViews(TopCapitalCityReport29());
                    break;

                case 40:
                    System.out.println("provide the name of the continent you wish to see all capital cities in:");
                    String cont = input.next();
                    printReportViews(CapitalCityContinent(cont));
                    break;
                
                case 41:
                    System.out.println("Enter a continent you wish to view:");
                    String choice2 = input.next();
                    System.out.println("provide the top number of capital cities you wish to view:");
                    Integer limit = Integer.parseInt(input.next());
                    printReportViews(CapitalCityContinentLimited(choice2, limit));
                    break;

                case 42:
                    System.out.println("Enter a region you wish to view:");
                    String region = input.next();
                    System.out.println("Provide the top number of capital cities you wish to view:");
                    Integer limit2 = Integer.parseInt(input.next());
                    printReportViews(CapitalCityRegionLimited(region, limit2));
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
    public ArrayList<ReportView> worldPopulation() {
        return null;
    }

    /**
     * The population of a continent.
     *
     * @return
     */
    public ArrayList<ReportView> continentPopulation(String continent) {
        return null;
    }

    /**
     * The population of a region.
     *
     * @return
     */
    public ArrayList<ReportView> regionPopulation(String region) {
        return null;
    }

    /**
     * The population of a country.
     *
     * @return
     */
    public ArrayList<ReportView> countryPopulation(String country) {
        return null;
    }

    /**
     * The population of a district.
     *
     * @return
     */
    public ArrayList<ReportView> districtPopulation(String district) {
        return null;
    }

    /**
     * The population of a city.
     *
     * @return
     */
    public ArrayList<ReportView> cityPopulation(String city) {
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
    public ArrayList<ReportView> worldCountriesTopN(int n) {
        try {
            String query =  "SELECT c.Code, c.Name, c.Continent, c.Region, c.Population, capitalCity.Name AS Capital FROM country c\n" +
                    "JOIN city capitalCity ON capitalCity.ID = c.Capital\n" +
                    "ORDER BY population DESC\n" +
                    "LIMIT " + n + ";";

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
     * The top N populated countries in a continent where N is provided by the user.
     *
     * @return
     */
    public ArrayList<ReportView> continentCountriesTopN(int n, String continent) {
        try {
            String query =  "SELECT c.Code, c.Name, c.Continent, c.Region, c.Population, capitalCity.Name AS Capital FROM country c\n" +
                    "JOIN city capitalCity ON capitalCity.ID = c.Capital\n" +
                    "WHERE c.Continent = '" + continent + "'\n" +
                    "ORDER BY population DESC\n" +
                    "LIMIT " + n + ";";

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
     * The top N populated countries in a region where N is provided by the user.
     *
     * @return
     */
    public ArrayList<ReportView> regionCountriesTopN(int n, String region) {

        try {
            String query =  "SELECT c.Code, c.Name, c.Continent, c.Region, c.Population, capitalCity.Name AS Capital FROM country c\n" +
                    "JOIN city capitalCity ON capitalCity.ID = c.Capital\n" +
                    "WHERE c.Region = '" + region + "'\n" +
                    "ORDER BY population DESC\n" +
                    "LIMIT " + n + ";";

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
     * All the cities in the world organised by largest population to smallest.
     *
     * @return
     */
    public ArrayList<ReportView> worldCitiesByPopulationLS() {
        return null;
    }

    /**
     * All the cities in a continent organised by largest population to smallest.
     *
     * @return
     */
    public ArrayList<ReportView> continentCitiesByPopulationLS() {
        return null;
    }

    /**
     * All the cities in a region organised by largest population to smallest.
     *
     * @return
     */
    public ArrayList<ReportView> regionCitiesByPopulationLS() {
        return null;
    }

    /**
     * All the cities in a country organised by largest population to smallest.
     *
     * @return
     */
    public ArrayList<ReportView> countryCitiesByPopulationLS() {
        return null;
    }

    /**
     * All the cities in a district organised by largest population to smallest.
     *
     * @return
     */
    public ArrayList<ReportView> districtCitiesByPopulationLS() {
        return null;
    }

    /**
     * The top N populated cities in the world where N is provided by the user.
     *
     * @return
     */
    public ArrayList<ReportView> worldCitiesTopN(int n) {
        return null;
    }

    /**
     * The top N populated cities in a continent where N is provided by the user.
     *
     * @return
     */
    public ArrayList<ReportView> continentCitiesTopN(int n) {
        return null;
    }

    /**
     * The top N populated cities in a region where N is provided by the user.
     *
     * @return
     */
    public ArrayList<ReportView> regionCitiesTopN(int n) {
        return null;
    }

    /**
     * The top N populated cities in a country where N is provided by the user.
     *
     * @return
     */
    public ArrayList<ReportView> countryCitiesTopN(int n) {
        return null;
    }

    /**
     * The top N populated cities in a district where N is provided by the user.
     *
     * @return
     */
    public ArrayList<ReportView> districtCitiesTopN(int n) {
        return null;
    }

    /**
     * All the capital cities in the world organised by largest population to smallest.
     *
     * @return
     */
    public ArrayList<ReportView> worldCapitalsByPopulationLS() {
        return null;
    }

    /**
     * All the capital cities in a continent organised by largest population to smallest.
     *
     * @return
     */
    public ArrayList<ReportView> continentCapitalsByPopulationLS() {
        return null;
    }

    /**
     * All the capital cities in a region organised by largest to smallest.
     *
     * @return
     */
    public ArrayList<ReportView> regionCapitalsByPopulationLS() {
        return null;
    }

    /**
     * The top N populated capital cities in the world where N is provided by the user.
     *
     * @return
     */
    public ArrayList<ReportView> worldCapitalsTopN(int n) {
        return null;
    }

    /**
     * The top N populated capital cities in a continent where N is provided by the user.
     *
     * @return
     */
    public ArrayList<ReportView> continentCapitalsTopN(int n) {
        return null;
    }

    /**
     * The top N populated capital cities in a region where N is provided by the user.
     *
     * @return
     */
    public ArrayList<ReportView> regionCapitalsTopN(int n) {
        return null;
    }

    /**
     * The population of people, people living in cities, and people not living in cities in each continent.
     *
     * @return
     */
    public ArrayList<ReportView> continentPopulationCitiesandRural() {
        return null;
    }

    /**
     * The population of people, people living in cities, and people not living in cities in each region.
     *
     * @return
     */
    public ArrayList<ReportView> regionPopulationCitiesandRural() {
        return null;
    }

    /**
     * The population of people, people living in cities, and people not living in cities in each country.
     *
     * @return
     */
    public ArrayList<ReportView> countryPopulationCitiesandRural() {
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



    public ArrayList<ReportView> CapitalCityContinent(String cont) {
        try {
            String query = "SELECT "+
                    "t1.Continent AS 'Continent', "+
                    "t1.name AS 'Country', "+
                    "t2.name AS 'Name', "+
                    "t2.population "+
                    "FROM "+
                    "(select country.Name, country.Continent, country.capital FROM country) as t1, "+
                    "(select city.name, city.population, city.ID FROM city) as t2 "+
                    "where t1.capital = t2.id AND t1.Continent = 'Europe' "+
                    "order by t2.population DESC;";
          
          ResultSet results = db.query(query);

            ArrayList<ReportView> views = new ArrayList<>();
            while (results.next()) {
                CapitalCityReportView view = new CapitalCityReportView(results);
                views.add(view);
            }
          System.out.println("The continent you chose is " + cont);
          return views;
          }
        catch(Exception e){
            System.out.println("No data Found");
            System.out.println(e.getMessage());
            return null;
        }
}
          
    public ArrayList<ReportView> CapitalCityContinentLimited(String cont, Integer limit) {
        try {
            String query = "SELECT "+
                    "t2.name, "+
                    "t2.population, "+
                    "t1.name AS 'Country' "+
                    "FROM (select country.Name, country.Continent, country.capital FROM country) as t1, "+
                    "(select city.name, city.population, city.ID FROM city) as t2 "+
                    "where t1.capital = t2.id AND t1.Continent = '" + cont +"' "+
                    "order by t2.population DESC "+
                    "LIMIT " + limit + ";";
          
            ResultSet results = db.query(query);

            ArrayList<ReportView> views = new ArrayList<>();
            while (results.next()) {
                CapitalCityReportView view = new CapitalCityReportView(results);
                views.add(view);
            }
            System.out.println("You are searching for the top " + limit + " Capital cities in the continent " + cont);
            return views;
        }
        catch(Exception e){
            System.out.println("No data Found");
            System.out.println(e.getMessage());
            return null;
        }
    }




    public ArrayList<ReportView> CapitalCityRegionLimited(String region, Integer limit) {
        try {
            String query = "SELECT "+
                    "t1.region AS 'Region', "+
                    "t1.name AS 'Country', "+
                    "t2.name, "+
                    "t2.population AS 'Population' "+
                    "FROM (select country.Name, country.Region, country.capital FROM country) as t1, (select city.name, city.population, city.ID FROM city) as t2 "+
                    "where t1.capital = t2.id AND t1.region =  '"+ region + "' "+
                    "order by t2.population DESC "+
                    "LIMIT " + limit + " ;";

            ResultSet results = db.query(query);

            ArrayList<ReportView> views = new ArrayList<>();
            while (results.next()) {
                CapitalCityReportView view = new CapitalCityReportView(results);
                views.add(view);
            }
            System.out.println("You are searching for the top " + limit + " Capital cities in the region " + region);
            return views;
        }
        catch(Exception e){
            System.out.println("No data Found");
            System.out.println(e.getMessage());
            return null;
        }
    }

}
