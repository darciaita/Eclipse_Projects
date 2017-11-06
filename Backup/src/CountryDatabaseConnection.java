import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CountryDatabaseConnection 
{
	private static Connection connection;
    
	public static void connectDatabase() {
		// TODO Auto-generated method stub
		
		//establish a connection to the database
    	try
    	{
	        Class.forName("com.mysql.jdbc.Driver");
	        connection = DriverManager.getConnection("jdbc:mysql://131.193.209.54:3306/World","f17x321","f17x321TS");
	        
	    }
    	catch(SQLException sqlEx)
    	{
	        System.out.println("There was an error connecting to the database!\n" + sqlEx.getMessage());
	    } 
    	catch (ClassNotFoundException ex) 
    	{
	        System.out.println("Error - Driver class not found.\n" + ex.getMessage());
    	}
	}
	
	public static void closeDatabaseConnection() {
		// TODO Auto-generated method stub
		
		//close the connection to the database
        try
        {
        	connection.close();
        }
        catch(SQLException sqlEx)
        {
            System.out.println("There was an error closing the DB!\n" + sqlEx.getMessage());
        }
	}
	
	public static Country select(String code) {
		// TODO Auto-generated method stub
		Country country=null;
        try
        {
            //SQL STRING
            String sql = "SELECT Code, Name, Continent, Region, SurfaceArea, Population, LocalName, GovernmentForm FROM COUNTRY WHERE code = ?";
        
          //PREPARED STATEMENT OBJECT
            PreparedStatement ps = connection.prepareStatement(sql);
            
            ps.setString(1, code);
            
            //EXECUTE STATEMENT AND RETURN RESULTSET
            ResultSet rs = ps.executeQuery();
        
            //IF THERE ARE RESULTS ASSIGN THEM TO A PRODUCT
            while(rs.next()){
            
            	country = new Country(rs.getString("Code"), rs.getString("Name"), rs.getString("Continent"), rs.getString("Region"), rs.getDouble("SurfaceArea"), rs.getInt("Population"), rs.getString("LocalName"), rs.getString("GovernmentForm"));
                
            	
                System.out.println("Record was selected");
            }
            if (country==null){
                System.out.println("No Record was found!");
            }
        
            
            
        }catch(SQLException sqlEX){
            
            System.out.println("Record was not selected" + sqlEX.getMessage());
        }
		
		return country;
	}



	public static ArrayList<Country> selectAllCountry() {
		// TODO Auto-generated method stub
		
		ArrayList<Country> countryList = new ArrayList<>();
        try
        {
            //SQL STRING
            String sql = "SELECT Code, Name, Continent, Region, SurfaceArea, Population, LocalName, GovernmentForm FROM COUNTRY;";
        
          //PREPARED STATEMENT OBJECT
            PreparedStatement ps = connection.prepareStatement(sql);
            
            
            //EXECUTE STATEMENT AND RETURN RESULTSET
            ResultSet rs = ps.executeQuery();
        
            //IF THERE ARE RESULTS ASSIGN THEM TO A PRODUCT
            while(rs.next()){
            
            	Country country = new Country(rs.getString("Code"), rs.getString("Name"), rs.getString("Continent"), rs.getString("Region"), rs.getDouble("SurfaceArea"), rs.getInt("Population"), rs.getString("LocalName"), rs.getString("GovernmentForm"));
                
            	countryList.add(country);
            }
            if (countryList.size()==0){
                System.out.println("No Record was found!");
            }
        
            
            
        }catch(SQLException sqlEX){
            
            System.out.println("Record was not selected" + sqlEX.getMessage());
        }
		
		return countryList;
	}

	
}
