
<%@page import="world.Country"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Query Results</title>
    </head>
    <body>
        <%
            Object count = session.getAttribute("count");
        		out.print("The result is: " + count);
        %><br /> 
        <a href="home.jsp">Perform another query</a>
                </form><br /><br />            
                        <form action="Logout" method="post">
                <input class="ActionButton" type="submit" value="Logout"><br></form>
        
    </body>
</html>
