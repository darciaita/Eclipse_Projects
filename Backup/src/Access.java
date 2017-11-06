

import java.sql.*;

public class Access {

	
 private static String user = "f17x321"; // user name
 private static String pass = "f17x321TS"; // password
 private static String url = "jdbc:mysql://131.193.209.54/f17x321";

 
 public static void main(String[] args) throws SQLException {
  Connection conn = null;
  Statement stmt = null;
  ResultSet rs = null;

  try {
	   //Connect to DB 
	   conn = DriverManager.getConnection(url, user, pass);
   
	   //Create a statement
	   stmt = conn.createStatement();
	   
	   //Execute SQL query
	   String tname = "f17g310_daita2_myTab";
	    String sql = "CREATE TABLE IF NOT EXISTS f17g310_daita2_myTab (\n"
		         + "	id integer PRIMARY KEY,\n"
		         + "	fname text NOT NULL,\n"
		         + "	lname text NOT NULL,\n"
		         + "	program text\n"
		         + ");";
	   
	   stmt.execute(sql);
	   
	   //Test Output (Remove once testing is complete)  
	   System.out.println("Table " + tname + " created successfully OR already exists");
	   
	   
  } catch (SQLException ex) {
   System.err.println(ex);
  } finally {
	   if (rs != null) {
		    rs.close();
		   }
	   if (stmt != null) {
		    stmt.close();
		   }
	   if (conn != null) {
		    conn.close();
		   }
  }
 }

}