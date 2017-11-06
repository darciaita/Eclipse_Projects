package registrarbeans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author mpenderg
 */
public class User {
    String firstName = "";
    String lastName = "";
    String id = "";
    String password = "";
    
    boolean loggedIn = false;
    
    public User()
    {
        
    }
    
   public boolean isLoggedIn()
   {
       return loggedIn;
   }
   
   
   public  String getFirstName()
    {
      return firstName;
    }
   
   public void setFirstName(String f)
   {
     firstName = f;
   }
   
    public  String getLastName()
    {
      return lastName;
    }
   
   public void setLasttName(String l)
   {
     lastName = l;
   }
   
    public  String getId()
    {
      return id;
    }
   
   public void setId(String i)
   {
     id = i;
   }
    public  String getPassword()
    {
      return password;
    }
   
   public void setPassword(String p)
   {
     password = p;
   }
   
   public boolean login(String url)
   {
   //    
   // database work
   //               
        try{
         // open a connection
          Connection con = null;
          Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  // load the driver
          con = DriverManager.getConnection(url);
      //    con = DriverManager.getConnection("jdbc:sqlserver://rubble.user.ad.fgcu.edu:1433;databaseName=sp12ism3232x;user=s12ISM3232;password=s12ISM3232;");
      // create the sql command
          PreparedStatement prep = con.prepareStatement("Select lastname, firstname from Users where userid=? and password=?");  
          prep.setString(1,id);
          prep.setString(2,password);
        
          ResultSet rs  = prep.executeQuery();
          if(rs.next())
          {
           lastName = rs.getString(1);
           firstName = rs.getString(2);
           loggedIn = true;
          }
          else
            loggedIn = false;
          prep.close();
          con.close();
          
         }
        catch(Exception sqlex)
        {
          loggedIn = false;  
        }  
        
        return loggedIn;
   }
   
   public void logOut()
   {
     loggedIn = false;
   }
}