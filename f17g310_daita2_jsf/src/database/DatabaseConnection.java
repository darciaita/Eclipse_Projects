package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import world.City;
import world.Country;

public class DatabaseConnection {

    private static Connection connection;
    private static String username, password;
    public static void setUsernameAndPassword(String userId, String userPass) {
        username = userId;
        password = userPass;
    }
    public static void connect() {
        //establish a connection to the database
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://131.193.209.54:3306/World", username, password);
        } catch (SQLException sqlEx) {
            System.out.println("There was an error connecting to the database!\n" + sqlEx.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("Error - Driver class not found.\n" + ex.getMessage());
        }
    }
    public static void disconnect() {
        //close the connection to the database
        try {
            connection.close();
        } catch (SQLException sqlEx) {
            System.out.println(sqlEx.getMessage());
        }
    }

    
    //SELECT COUNTRY
    public static Country selectCountry(String code) {
        Country country = null;
        try {
            //SQL STRING
            String sql = "SELECT Code, Name, Continent, Region, SurfaceArea, Population, LocalName, GovernmentForm FROM COUNTRY WHERE code = ?";

            //PREPARED STATEMENT OBJECT
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, code);

            //EXECUTE STATEMENT AND RETURN RESULTSET
            ResultSet rs = ps.executeQuery();

            //IF THERE ARE RESULTS ASSIGN THEM TO A PRODUCT
            while (rs.next()) {
                country = new Country(rs.getString("Code"), rs.getString("Name"), rs.getString("Continent"), rs.getString("Region"), rs.getDouble("SurfaceArea"), rs.getInt("Population"), rs.getString("LocalName"), rs.getString("GovernmentForm"));
                System.out.println("Record was selected");
            }
            if (country == null) {
                System.out.println("No Record was found!");
            }
        } catch (SQLException sqlEX) {
            System.out.println("Record was not selected" + sqlEX.getMessage());
        }
        return country;
    }

    //COUNT COUNTRY
    public static int countCountry() {
        int count = 0;
        try {
            //SQL STRING
            String sql = "select * from country";

            //PREPARED STATEMENT OBJECT
            PreparedStatement ps = connection.prepareStatement(sql);

            //EXECUTE STATEMENT AND RETURN RESULTSET
            ResultSet rs = ps.executeQuery();
            rs.last();
            count = rs.getRow();
            System.out.println("The total count of countries is" + count);

        } catch (SQLException sqlEX) {
            System.out.println("Record was not selected" + sqlEX.getMessage());
        }
        return count;
    }
    
    //AVG COUNTRY Population
    public static int avgCountryPop() {
        int count = 1;
        try {
            //SQL STRING
            String sql = "SELECT AVG(Population) AS count FROM COUNTRY";
            //PREPARED STATEMENT OBJECT
            PreparedStatement ps = connection.prepareStatement(sql);
            //EXECUTE STATEMENT AND RETURN RESULTSET
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            count = rs.getInt("count");}
            System.out.println("The average population of all countries is" + count);

        } catch (SQLException sqlEX) {
            System.out.println("Record was not selected" + sqlEX.getMessage());
        }
        return count;
    }

    //AVG CITY Population
    public static int avgCityPop() {
        int count = 1;
        try {
            //SQL STRING
            String sql = "SELECT AVG(Population) AS count FROM CITY";
            //PREPARED STATEMENT OBJECT
            PreparedStatement ps = connection.prepareStatement(sql);
            //EXECUTE STATEMENT AND RETURN RESULTSET
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            count = rs.getInt("count");}
            System.out.println("The average population of all cities is" + count);

        } catch (SQLException sqlEX) {
            System.out.println("Record was not selected" + sqlEX.getMessage());
        }
        return count;
    }
    public static ArrayList < Country > selectAllCountry() {
        ArrayList < Country > countryList = new ArrayList < > ();
        try {
            //SQL STRING
            String sql = "SELECT Code, Name, Continent, Region, SurfaceArea, Population, LocalName, GovernmentForm FROM COUNTRY;";
            //PREPARED STATEMENT OBJECT
            PreparedStatement ps = connection.prepareStatement(sql);

            //EXECUTE STATEMENT AND RETURN RESULTSET
            ResultSet rs = ps.executeQuery();

            //IF THERE ARE RESULTS ASSIGN THEM TO A PRODUCT
            while (rs.next()) {

                Country country = new Country(rs.getString("Code"), rs.getString("Name"), rs.getString("Continent"), rs.getString("Region"), rs.getDouble("SurfaceArea"), rs.getInt("Population"), rs.getString("LocalName"), rs.getString("GovernmentForm"));

                countryList.add(country);
            }
            if (countryList.isEmpty()) {
                System.out.println("No Record was found!");
            }

        } catch (SQLException sqlEX) {

            System.out.println("Record was not selected" + sqlEX.getMessage());
        }

        return countryList;
    }

    public static City selectCity(int ID) {
        City city = null;
        try {
            //SQL STRING
            String sql = "SELECT * FROM CITY WHERE ID = ?";
            //PREPARED STATEMENT OBJECT
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, ID);
            //EXECUTE STATEMENT AND RETURN RESULTSET
            ResultSet rs = ps.executeQuery();
            //IF THERE ARE RESULTS ASSIGN THEM TO A PRODUCT
            while (rs.next()) {
                city = new City(rs.getInt("ID"), rs.getString("Name"), rs.getString("CountryCode"), rs.getString("District"), rs.getInt("Population"));
                System.out.println("Record was selected");
            }
            if (city == null) {
                System.out.println("No Record was found!");
            }
        } catch (SQLException sqlEX) {
            System.out.println("Record was not selected" + sqlEX.getMessage());
        }

        //RETURN selected Employee
        return city;
    }

    public static ArrayList < City > selectAllCity() {
        //select employee from database
        //SQL EXAMPLE => SELECT * FROM EMPLOYEE;

        ArrayList < City > cityList = new ArrayList < > ();
        try {
            //SQL STRING
            String sql = "SELECT * FROM CITY;";

            //PREPARED STATEMENT OBJECT
            PreparedStatement ps = connection.prepareStatement(sql);

            //EXECUTE STATEMENT AND RETURN RESULTSET
            ResultSet rs = ps.executeQuery();

            //IF THERE ARE RESULTS ASSIGN THEM TO A PRODUCT
            while (rs.next()) {

                City employee = new City(rs.getInt("ID"), rs.getString("Name"), rs.getString("CountryCode"), rs.getString("District"), rs.getInt("Population"));
                cityList.add(employee);

            }

            if (cityList.isEmpty()) {
                System.out.println("No Record was found!");
            }

        } catch (SQLException sqlEX) {

            System.out.println("Record was not selected" + sqlEX.getMessage());
        }

        //RETURN selected Employee
        return cityList;
    }
	
    public static int countCity() {
		  int count = 0;
	        try {
	            //SQL STRING
	            String sql = "select * from city";

	            //PREPARED STATEMENT OBJECT
	            PreparedStatement ps = connection.prepareStatement(sql);

	            //EXECUTE STATEMENT AND RETURN RESULTSET
	            ResultSet rs = ps.executeQuery();
	            rs.last();
	            count = rs.getRow();
	            System.out.println("The total count of cities is" + count);

	        } catch (SQLException sqlEX) {
	            System.out.println("Record was not selected" + sqlEX.getMessage());
	        }
	        return count;
	}
}