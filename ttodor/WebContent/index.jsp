<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tammy Todor - Assignment 2</title>
</head>
<body>
<jsp:useBean id="dbmsUserBean" scope="session"
	class="assignment2_ttodor2.model.UserAccessBean">
</jsp:useBean>
<jsp:useBean id="messageBean" scope="session"
	class="assignment2_ttodor2.model.MessageBean">
</jsp:useBean>

<h1 align="center">f17g310 Tammy Todor's Assignment 2</h1>
<hr />
<br/>
<br/>
<p align="center"> <a href="login.jsp">Login</a></p>
<p align="center"> <a href="dboperations.jsp">Database Operations</a></p>
<p align="center"> <a href="logout.jsp">Logout</a>
</body>
</html>