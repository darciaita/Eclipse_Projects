
package servlets;

import database.DatabaseConnection;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import world.City;
import world.Country;

@WebServlet(name = "DisplayDataServlet", urlPatterns = {"/DisplayData"})
public class DisplayDataServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(request.getSession().getAttribute("user")==null)
        {
            String message = ("Please login.");
            request.getSession().setAttribute("message", message);
            response.sendRedirect("error.jsp");
        }
        else
        {
            String query = request.getParameter("availableQueries");
            if(query.equals("cityWithID"))
            {
                int cityID = Integer.parseInt(request.getParameter("elementName"));
                DatabaseConnection.connect();
                City city = DatabaseConnection.selectCity(cityID);
                DatabaseConnection.disconnect();
                ArrayList<City> cityList = new ArrayList<>();
                if(city != null)
                    cityList.add(city);
                request.getSession().setAttribute("cityInfo", cityList);
                response.sendRedirect("displayCity.jsp");
            }
            else if(query.equals("allCities"))
            {
                DatabaseConnection.connect();
                List<City> cityList = DatabaseConnection.selectAllCity();
                DatabaseConnection.disconnect();
                request.getSession().setAttribute("cityInfo", cityList);
                response.sendRedirect("displayCity.jsp");
            }
        //COUNT COUNTRIES
            if(query.equals("countCountry"))
            {
                DatabaseConnection.connect();
                int count = DatabaseConnection.countCountry();
                DatabaseConnection.disconnect();
                request.getSession().setAttribute("count", count);
                response.sendRedirect("displayCountry.jsp");
                
            }
       //Avg COUNTRIES Pop
            if(query.equals("avgCountryPop"))
            {
                DatabaseConnection.connect();
                int count = DatabaseConnection.avgCountryPop();
                DatabaseConnection.disconnect();
                request.getSession().setAttribute("count", count);
                response.sendRedirect("displayCountry.jsp");
            }
            
            //Avg City Pop
            if(query.equals("avgCityPop"))
            {
                DatabaseConnection.connect();
                int count = DatabaseConnection.avgCityPop();
                DatabaseConnection.disconnect();
                request.getSession().setAttribute("count", count);
                response.sendRedirect("displayCountry.jsp");
            }            
            
        //COUNT CITIES
            if(query.equals("countCity"))
            {
                DatabaseConnection.connect();
                int count = DatabaseConnection.countCity();
                DatabaseConnection.disconnect();
                request.getSession().setAttribute("count", count);
                response.sendRedirect("displayCountry.jsp");
                
            }
            
            else if(query.equals("allCountries"))
            {
                DatabaseConnection.connect();
                List<Country> countryList = DatabaseConnection.selectAllCountry();
                DatabaseConnection.disconnect();
                request.getSession().setAttribute("countryInfo", countryList);
                response.sendRedirect("displayCountry.jsp");
            }
        }
    }


}
