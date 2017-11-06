<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Logout</title>
</head>
<body>
<jsp:useBean id="dbmsUserBean" scope="session"
	class="assignment2_ttodor2.model.UserAccessBean">
</jsp:useBean>
<jsp:useBean id="messageBean" scope="session"
	class="assignment2_ttodor2.model.MessageBean">
</jsp:useBean>
<h1 align="center">f17g310 Tammy Todor's Assignment 2 - LOGOUT PAGE</h1>
<hr />
<h1 align="center"><a href="index.jsp">Home</a></h1>
<br/>
<p><font color="red"><%= dbmsUserBean.geterror()%></font></p>
<p align="left">Please log out below:</p>
<form action="/assignment2_ttodor2/LogoutServlet" method="post">
<input type="submit" value = "Logout" /> 

<p> <%= dbmsUserBean.getconnectionmessage()%></p>


</form>
</body>
</html>