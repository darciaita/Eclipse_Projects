
<%@page import="world.Country"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Country</title>
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
                        <input type="submit" value="Logout">
                    </th>
                </tr>

            </table>
        </form>
        <%
            ArrayList<Country> countryData = (ArrayList<Country>)session.getAttribute("countryInfo");
            if(countryData == null || countryData.isEmpty())
            {
                out.print("No record found");
            }
            else
            {
                %>
                
                <form>                        
                        <table border="1">
                            <tr>
                                <th>S.N.</th>
                                <th>Country Code</th>
                                <th>Country Name</th>
                                <th>Continent</th>
                                <th>Region</th>
                                <th>Surface Area</th>
                                <th>Population</th>
                                <th>Local Name</th>
                                <th>Government Form</th>
                            </tr>
                            <tr>                                
                            </tr>
                            <tr>                                
                            </tr>
                            <%
                                for(int i=0; i<countryData.size();i++)
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
                                                out.print(countryData.get(i).getCountryCode());
                                            %>
                                        </td>
                                        <td>
                                            <%
                                                out.print(countryData.get(i).getCountryName());
                                            %>
                                        </td>
                                        <td>
                                            <%
                                                out.print(countryData.get(i).getContinent());
                                            %>
                                        </td>
                                        <td>
                                            <%
                                                out.print(countryData.get(i).getRegion());
                                            %>
                                        </td>
                                        <td>
                                            <%
                                                out.print(countryData.get(i).getSurfaceArea());
                                            %>
                                        </td>
                                        <td>
                                            <%
                                                out.print(countryData.get(i).getPopulation());
                                            %>
                                        </td>
                                        <td>
                                            <%
                                                out.print(countryData.get(i).getLocalName());
                                            %>
                                        </td>
                                        <td>
                                            <%
                                                out.print(countryData.get(i).getGovernmentForm());
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
