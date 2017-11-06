import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainClass {

 public static void main(String[] args) throws NumberFormatException, IOException {

  int mainMenuChoice = 0, studentMenuChoice = 0, countryMenuChoice = 0;

  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  do {
   menu();
   mainMenuChoice = Integer.parseInt(br.readLine());

   switch (mainMenuChoice) {

    case 1:
     {
      do {
       menuWorld();
       countryMenuChoice = Integer.parseInt(br.readLine());

       switch (countryMenuChoice) {
        case 1:
         {
          //select one employee with employee ID
          System.out.print("Enter country code (String) :");
          String code = br.readLine();

          CountryDatabaseConnection.connectDatabase();
          Country country = CountryDatabaseConnection.select(code);
          CountryDatabaseConnection.closeDatabaseConnection();

          if (country != null) {
           System.out.println(country.toString() + "\n");
          }
          break;
         }
        case 2:
         {

          //select all employee from the table of database
          CountryDatabaseConnection.connectDatabase();
          ArrayList < Country > countryList = CountryDatabaseConnection.selectAllCountry();
          CountryDatabaseConnection.closeDatabaseConnection();
          if (countryList != null) {
           System.out.println();
           for (int i = 0; i < countryList.size(); i++) {
            System.out.println(countryList.get(i).toString() + "\n");
           }
           if (countryList.size() > 0)
            System.out.println(countryList.size() + " record was selected.\n");
          }

          break;
         }

        default:
         {
          System.out.println("Invalid choice.\n");
          continue;
         }

       }
      } while (countryMenuChoice != 3);

      break;
     }

    case 2:
     {
      do {
       menuStudent();
       studentMenuChoice = Integer.parseInt(br.readLine());

       switch (studentMenuChoice) {
        case 1:
         {
          //insert new student into table of database
          System.out.println("Enter Student ID (int) : ");
          int studentId = Integer.parseInt(br.readLine());

          System.out.println("Enter Student First Name (String): ");
          String fName = br.readLine();

          System.out.println("Enter Student Last Name (String): ");
          String lName = br.readLine();


          System.out.println("Enter Student Email : (String)");
          String email = br.readLine();

          System.out.println("Enter Student Phone (String): ");
          String phone = br.readLine();

          System.out.println("Enter Student Gender (String): ");
          String gender = br.readLine();

          System.out.println("Enter Student Address (String): ");
          String address = br.readLine();


          Student student = new Student(studentId, fName, lName, email, phone, gender, address);
          StudentDatabaseConnection.connectDatabase();
          StudentDatabaseConnection.insert(student);
          StudentDatabaseConnection.closeDatabaseConnection();

          break;
         }
        case 2:
         {
          //select one employee with employee ID
          System.out.print("Enter Student ID (int) :");
          int studentId = Integer.parseInt(br.readLine());

          StudentDatabaseConnection.connectDatabase();
          Student student = StudentDatabaseConnection.select(studentId);
          StudentDatabaseConnection.closeDatabaseConnection();

          if (student != null) {
           System.out.println(student.toString());
          }


          break;
         }
        case 3:
         {
          //select all employee from the table of database
          StudentDatabaseConnection.connectDatabase();
          ArrayList < Student > studentList = StudentDatabaseConnection.selectAll();
          StudentDatabaseConnection.closeDatabaseConnection();
          if (studentList != null) {
           System.out.println();
           for (int i = 0; i < studentList.size(); i++) {
            System.out.println(studentList.get(i).toString() + "\n");
           }
           if (studentList.size() > 0)
            System.out.println(studentList.size() + " record was selected.\n");
          }

          break;
         }
        case 4:
         {
          //delete one employee from the table of database
          System.out.print("Enter Student ID (int) :");
          int studentId = Integer.parseInt(br.readLine());
          StudentDatabaseConnection.connectDatabase();
          StudentDatabaseConnection.delete(studentId);
          StudentDatabaseConnection.closeDatabaseConnection();
          break;
         }

        case 5:
         {
          //delete all employee from the table of database
          StudentDatabaseConnection.connectDatabase();
          StudentDatabaseConnection.deleteAll();
          StudentDatabaseConnection.closeDatabaseConnection();
          break;
         }
        case 6:
         {
          //update employee in the table of database
          System.out.println("Enter Student ID of student you want to update (int) : ");
          int studentId = Integer.parseInt(br.readLine());

          System.out.println("Enter Student First Name (String): ");
          String fName = br.readLine();

          System.out.println("Enter Student Last Name (String): ");
          String lName = br.readLine();


          System.out.println("Enter Student Email : (String)");
          String email = br.readLine();

          System.out.println("Enter Student Phone (String): ");
          String phone = br.readLine();

          System.out.println("Enter Student Gender (String): ");
          String gender = br.readLine();

          System.out.println("Enter Student Address (String): ");
          String address = br.readLine();

          Student student = new Student(studentId, fName, lName, email, phone, gender, address);

          StudentDatabaseConnection.connectDatabase();
          StudentDatabaseConnection.update(student);
          StudentDatabaseConnection.closeDatabaseConnection();
          break;
         }
        case 7:
         {
          break;
         }
        default:
         {
          System.out.print("Invalid choice. Try again.\nEnter your choice (int): ");
          continue;
         }
       }
      } while (studentMenuChoice != 7);


      break;
     }

    case 3:
     {
      System.exit(0);
     }
   }

  } while (mainMenuChoice != 3);



  br.close();

 }
 public static void menuStudent() {
  System.out.println("1. Insert into database.");
  System.out.println("2. View All");
  System.out.println("3. Get count of rows");
  System.out.println("4. Delete one Student from database.");
  System.out.println("5. Delete all Student from database.");
  System.out.println("6. Update Student details in database.");
  System.out.println("7. Go back to Main Menu..");
  System.out.print("\n\nEnter your choice : ");
 }
 public static void menuWorld() {
  System.out.println("1. Select Country with country code.");
  System.out.println("2. Select all Country from database.");
  System.out.println("3. Go back to Main Menu.");
  System.out.print("\n\nEnter your choice : ");
 }

 public static void menu() {
  System.out.println("1. Select World database.");
  System.out.println("2. Select f17x321 database.");
  System.out.println("3. Exit.");
  System.out.print("\n\nEnter your choice : ");
 }
}