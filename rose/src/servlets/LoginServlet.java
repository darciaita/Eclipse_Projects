package servlets;

import database.DatabaseConnection;
import java.io.IOException;

import javax.annotation.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@ManagedBean
@SessionScoped

@WebServlet(name = "LoginServlet", urlPatterns = {"/Login"})
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private final String userID="f17x321";
    private final String password="f17x321TS";

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
        String enteredUserId = (String)request.getParameter("userID");
        String enteredPassword = (String)request.getParameter("password");

        if(userID.equalsIgnoreCase(enteredUserId) && password.equals(enteredPassword))
        {
            DatabaseConnection.setUsernameAndPassword(userID, password);

            HttpSession session = request.getSession(true);
            session.setAttribute("user", enteredUserId);
            response.sendRedirect("home.jsp");
        }
        else
        {
            String message = "UserId or password is incorrect";
            HttpSession session = request.getSession(true);
            session.setAttribute("message", message);
            response.sendRedirect("error.jsp");
        }
    }
    

    public String logout() throws IOException {
        return("login.xhtml");
    	}

}
