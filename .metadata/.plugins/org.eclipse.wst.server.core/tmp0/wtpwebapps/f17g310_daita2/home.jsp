<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>World Database</title>
        <script type="text/javascript" src="javascript/script.js"></script>
    </head>
    <body>
            <h1>World Database</h1>
            <form class="databaseClass" name="query" action="DisplayData" method="post" >
                    Select Query <br>
                    <select name="availableQueries" id="queries" onclick="selectedQuery()" required> 
                        <option value="countCountry">Count all Countries from database</option>
                        <option value="countCity">Count all Cities from database</option>
                        <option value="avgCityPop">Average City Population from database</option>
                        <option value="avgCountryPop">Average Country Population from database</option>
                        
						<%-- <option value="allCities">Select all Cities from database</option> --%>
                    </select><br>
                <input type="submit" value="Submit">
            </form><br /><br />            
                        <form action="Logout" method="post">
                <input class="ActionButton" type="submit" value="Logout"><br>
            </form>
          
    </body>
</html>