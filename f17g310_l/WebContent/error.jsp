<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <link rel="stylesheet" href="main.css" type="text/css"/>
        <title>World Database</title>
    </head>
    <body>
            <%
                String message ="You have logged out";// (String)session.getAttribute("message");
            %>
        <input class="ActionButton" type="button" value="Back" onClick="JavaScript:window.location='index.jsp';"><br>
        <%=message%>
    
    </body>
</html>