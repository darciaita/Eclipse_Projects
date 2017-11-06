
<%@page import="world.City"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>City</title>
        <link rel="stylesheet" href="main.css" type="text/css"/>
    </head>
    <body>
        <form action="Logout" method="post">
            <table class="ActionButton">
                <tr>
                    <th>
                        <input type="button" value="Home" onClick="JavaScript:window.location='home.jsp';">
                    </th>
                    <th><pre>           </pre></th>
                    <th>
                        <input type="submit" value="Logout"><br>
                    </th>
                </tr>

            </table>
        </form>
        <%
            ArrayList<City> cityData = (ArrayList<City>)session.getAttribute("cityInfo");
            if(cityData == null || cityData.isEmpty())
            {
                out.print("No record found in the table");
            }
            else
            {
                %>
                
                <form>                        
                        <table border="1">
                            <tr>
                                <th>S.N.</th>
                                <th>City ID</th>
                                <th>City Name</th>
                                <th>Country Code</th>
                                <th>District</th>
                                <th>Population</th>
                            </tr>
                            <tr>                                
                            </tr>
                            <tr>                                
                            </tr>
                            <%
                                for(int i=0; i<cityData.size();i++)
                                {
                                    %>
                                    <tr>
                                        <td>
                                            <%
                                                out.print(i+1+".");
                                            %>
                                        </td>
                                        <td>
                                            <%
                                                out.print(cityData.get(i).getID());
                                            %>
                                        </td>
                                        <td>
                                            <%
                                                out.print(cityData.get(i).getName());
                                            %>
                                        </td>
                                        <td>
                                            <%
                                                out.print(cityData.get(i).getCountryCode());
                                            %>
                                        </td>
                                        <td>
                                            <%
                                                out.print(cityData.get(i).getDistrict());
                                            %>
                                        </td>
                                        <td>
                                            <%
                                                out.print(cityData.get(i).getPopulation());
                                            %>
                                        </td>
                                    </tr>
                                    <%
                                }
                            %>
                        </table>
                    </form>
                <%
            }
        %>
        
    </body>
</html>
