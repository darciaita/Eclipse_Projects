
package beans;

import database.DatabaseConnection;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "LogoutServlet", urlPatterns = {"/Logout"})
public class LogoutServlet extends HttpServlet {


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
        String message = "Thank you for your visit.\n You have successfully logged out.";
        HttpSession session = request.getSession(false);
        session.removeAttribute("user");
        session.removeAttribute("cityInfo");
        session.removeAttribute("countryInfo");
        session.setMaxInactiveInterval(0);
        DatabaseConnection.setUsernameAndPassword("", "");
        DatabaseConnection.setUsernameAndPassword("", "");
        request.setAttribute("message", message);
        response.sendRedirect("index.jsp");
    }

}
