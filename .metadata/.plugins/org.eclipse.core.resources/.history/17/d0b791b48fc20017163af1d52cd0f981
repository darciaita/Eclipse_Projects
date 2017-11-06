
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


    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(request.getSession().getAttribute("user")==null)
        {
            String message = ("You have logged out.");
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
            if(query.equals("countryWithCode"))
            {
                String countryCode = request.getParameter("elementName");
                DatabaseConnection.connect();
                Country country = DatabaseConnection.selectCountry(countryCode);
                DatabaseConnection.disconnect();
                
                ArrayList<Country> countryList = new ArrayList<>();
                
                if(country != null)
                    countryList.add(country);
                
                request.getSession().setAttribute("countryInfo", countryList);
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
