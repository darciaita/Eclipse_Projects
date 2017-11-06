import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentDatabaseConnection 
{
	private static Connection connection;
    private static final String TABLE_NAME = "f17g310_daita2_myTab";
    public static void connectDatabase()
    {
    	//onnection to the database
    	try
    	{
	        Class.forName("com.mysql.jdbc.Driver");
	        connection = DriverManager.getConnection("jdbc:mysql://131.193.209.54:3306/f17x321","f17x321","f17x321TS");   
	    }
    	catch(SQLException sqlEx)
    	{
	        System.out.println("Unable to connect. \n" + sqlEx.getMessage());
	    } 
    	catch (ClassNotFoundException ex) 
    	{
	        System.out.println("Driver class not found.\n" + ex.getMessage());
    	}
    }
	
    public static void closeDatabaseConnection()
    {
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


	public static void insert(Student student) {
		// TODO Auto-generated method stub
		
		//insert student into the database

        try
        {
            //SQL STRING
        	String SQL=" insert into "+TABLE_NAME+" (id, name, program)"
        	        + " values (?, ?, ?, ?, ?, ?, ?)";
        	// create preparedstatement
            PreparedStatement ps = connection.prepareStatement(SQL);
            ps.setInt(1, student.getid());
            ps.setString(2, student.getname());
            ps.setString(3, student.getLastName());
            ps.setString(4, student.getEmail());
            ps.setString(5, student.getPhone());
            ps.setString(6, student.getGender());
            ps.setString(7, student.getAddress());

            // execute the preparedstatement
            ps.execute();
             
             
             System.out.println("Student " + student.getid() + " was inserted!");
             
        }
        catch(SQLException sqlEX)
        {
            System.out.println("Student was not inserted!\n\n" + sqlEX.getMessage());
        }
	}


	public static Student select(int id) {
		// TODO Auto-generated method stub
		Student student=null;
        try
        {
            //SQL STRING
            String sql = "SELECT * FROM "+TABLE_NAME+" WHERE id = ?";
        
          //PREPARED STATEMENT OBJECT
            PreparedStatement ps = connection.prepareStatement(sql);
            
            ps.setInt(1, id);
            
            //EXECUTE STATEMENT AND RETURN RESULTSET
            ResultSet rs = ps.executeQuery();
        
            //
            while(rs.next()){
            
            	student = new Student(rs.getInt("id"), rs.getString("name"),rs.getString("LastName"), rs.getString("Email"),rs.getString("Phone"),rs.getString("Gender"), rs.getString("Address") );
                
                System.out.println("Record was selected");
            }
            if (student==null){
                System.out.println("No Record was found!");
            }
        
            
            
        }catch(SQLException sqlEX){
            
            System.out.println("Record was not selected" + sqlEX.getMessage());
        }
    
        //return selected Student
        return student;
	}

	public static ArrayList<Student> selectAll() {
		// TODO Auto-generated method stub

		ArrayList<Student> studentList=new ArrayList<>();
        try
        {
            //SQL STRING
            String sql = "SELECT * FROM "+TABLE_NAME;
        
          //PREPARED STATEMENT OBJECT
            PreparedStatement ps = connection.prepareStatement(sql);
            
            
            //EXECUTE STATEMENT AND RETURN RESULTSET
            ResultSet rs = ps.executeQuery();
        
            //
            while(rs.next())
            {
            
            	Student student = new Student(rs.getInt("id"), rs.getString("name"),rs.getString("LastName"), rs.getString("Email"),rs.getString("Phone"),rs.getString("Gender"), rs.getString("Address") );
                studentList.add(student);
                
            }
            
            if (studentList.size()==0)
            {
                System.out.println("No Record was found!");
            }
            
            
            
        }catch(SQLException sqlEX){
            
            System.out.println("Record was not selected" + sqlEX.getMessage());
        }
    
        //return selected Employee list
        return studentList;
	}

	public static void delete(int id) {
		// TODO Auto-generated method stub
		
		try
        {
            
            String SQL = "DELETE FROM "+TABLE_NAME+" WHERE id = ?";
            
            PreparedStatement ps = connection.prepareStatement(SQL);
            ps.setInt(1, id);
            
            ps.executeUpdate();
            
            System.out.println("Student has been Deleted!");
        
        }
        catch(SQLException sqlEX)
        {
            System.out.println("Student has not been Deleted!");
        }
	}

	public static void deleteAll() {
		// TODO Auto-generated method stub
		
		try
        {
    		//
    		int size=0;
    		//this query will return the number of records are there in the targeted table
    		String SQL ="SELECT COUNT(*) FROM "+TABLE_NAME+";";
    		PreparedStatement PS = connection.prepareStatement(SQL);
    		ResultSet RS = PS.executeQuery();
    		while(RS.next())
    		{
    			size = RS.getInt(1);
    		}
    		
    		//to delete all rows from the table
            //SQL STRING
            String sql = "TRUNCATE "+TABLE_NAME;
            
          //PREPARED STATEMENT OBJECT
            PreparedStatement ps = connection.prepareStatement(sql);
            
            
            //EXECUTE STATEMENT AND RETURN RESULTSET
            ps.executeQuery();
           
            System.out.println("Successfully deleted "+size+" record");
            
        }
    	catch(SQLException sqlEX)
    	{
            System.out.println("Records was not deleted " + sqlEX.getMessage());
        }
		
	}

	public static void update(Student student) {
		// TODO Auto-generated method stub
		
		try
        {
            //SQL STRING
            String sql = "UPDATE "+TABLE_NAME+" SET name=?, LastName=? , "+
            		" Email= ? , Phone= ?, Gender= ?"+ ", Address= ? "+
                    " WHERE id = ?" ;
            
            //PREPARED STATEMENT OBJECT
            PreparedStatement ps = connection.prepareStatement(sql);
            
            ps.setString(1, student.getname());
            ps.setString(2, student.getLastName());
            ps.setString(3, student.getEmail());
            ps.setString(4, student.getPhone());
            ps.setString(5, student.getGender());
            ps.setString(6, student.getAddress());
            ps.setInt(7, student.getid());

            //EXECUTE THE STATEMENT
            ps.executeUpdate();

            System.out.println(student.getid()+ " was updated!");
        }catch(SQLException sqlEX)
        {
            System.out.println(student.getid()+ " was not updated!"+"\n"+sqlEX.getMessage());
        }
	}

	

}
