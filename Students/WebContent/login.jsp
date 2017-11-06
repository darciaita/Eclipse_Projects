<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage = "errorPage.jsp" %>
<jsp:useBean id="user" class="registrarbeans.User" scope="session" />
 <jsp:setProperty name="user" property="*" />  
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <%
          session.setMaxInactiveInterval(1800);  // 30 minute time out 
  		String db = "jdbc:mysql://131.193.209.54/world";

          user.login("jdbc:sqlserver://rubble.user.ad.fgcu.edu:1433;databaseName=sp12ism3232x;user=s12ISM3232;password=s12ISM3232;");
          if(user.isLoggedIn())
            out.println("Hello "+user.getFirstName()+" "+user.getLastName()+"<br/>");
          else
            out.println("Invalid login<br />");
         out.println("<a href='checkLogin.jsp'>check</A>");
        %>

    </body>
</html>