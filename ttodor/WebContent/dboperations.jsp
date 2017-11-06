<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Database Operations</title>
</head>
<body>

<jsp:useBean id="dbmsUserBean" scope="session"
class="assignment2_ttodor2.model.UserAccessBean">
</jsp:useBean>
<jsp:useBean id="messageBean" scope="session"
class="assignment2_ttodor2.model.MessageBean">
</jsp:useBean>
<h1 align="center">f17g310 Tammy Todor's Assignment 2 - DB OPERATIONS</h1>
<hr />
<h1 align="center"><a href="index.jsp">Home</a></h1>
<br/>
<br/>
<p align="left"> Please select an operation for a table for the World Database</p>
<form action="/assignment2_ttodor2/OperationServlet" method="post">
	<p><font color="red"><%= dbmsUserBean.geterror()%></font></p>
	<table>
		<tr> <th align="right">Table:</th>
			<td> <select name="table" size="3">
				<option value="city" selected="selected">City</option>
 				<option value="country">Country</option>
 				<option value="countrylanguage">Country Language</option>
			</select> </td>
		</tr>
			<tr> <th align="right">Measure:</th>
			<td> <select name="columns" size="6">
			<option value="Population" selected="selected">City - Population</option>
 			<option value="SurfaceArea">Country - Surface Area</option>
 			<option value="LifeExpectancy">Country - Life Expectancy</option>
 			<option value="GNP">Country - GNP</option>
 			<option value="Capital">Country - Capital</option>
 			<option value="Percentage">Country Language - Percentage</option>
			</select> </td>
		</tr>
			<tr> <th align="right">Function:</th>
			<td> <select name="function" size="5">
			<option value="sum" selected="selected">SUM</option>
 			<option value="count">COUNT</option>
 			<option value="avg">AVERAGE</option>
 			<option value="min">MINIMUM</option>
 			<option value="max">MAXIMUM</option>
			</select> </td>
		</tr>
		<tr> <td></td>
			<td> <input type="submit" value = "showvalue" /> </td>
		</tr>
		<tr> <th align="right">Result:</th>
			<td> <%=dbmsUserBean.getResult() %> </td> </tr>
	
	</table>
</form>
</body>
</html>