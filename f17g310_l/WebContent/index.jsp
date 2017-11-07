<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Home</title>
        <link rel="stylesheet" href="main.css" type="text/css"/>
    </head>
    <body>
        
        <div id="login">
            <form action="Login" method="post">
                <h2 style="color: #10062e">Enter Login Credentials</h2>    
                <span>User ID : </span>
                <input type="text" id="user" name ="userId" placeholder="Username" required><br>

                <span>Password : </span>
                <input type="password" id="pass" name="password" placeholder="Password" required>

                <input type="submit" value="Login">
            </form>
        </div>
    </body>
</html>