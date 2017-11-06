<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <link rel="stylesheet" href="main.css" type="text/css"/>
        <title>World Database</title>
        <script type="text/javascript" src="javascript/script.js"></script>
            
    </head>
    <body>
        
            <h1>Welcome to World Database</h1>
            <form action="Logout" method="post">
                <input class="ActionButton" type="submit" value="Logout"><br>
            </form>
            <form class="databaseClass" name="schemaForm" action="DisplayData" method="post" >
                
                    Select Query <br>
                    <select name="availableQueries" id="queries" onclick="selectedQuery()" required> 
                        <option value="cityWithID">Select City with ID</option>
                        <option value="allCities">Select all Cities from database</option>
                        <option value="countryWithCode">Select Country with Code</option>
                        <option value="allCountries">Select all Countries from database</option>
                        
                    </select><br>
                    <label name="labelQuery" id="labelQueryID"></label> 
                    <input type="text" id="elementID" name="elementName" required disabled><br>
                
                <input type="submit" value="Execute">
            </form>
          
    </body>
</html>