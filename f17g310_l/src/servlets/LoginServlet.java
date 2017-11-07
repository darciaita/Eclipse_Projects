
package servlets;

import database.DatabaseConnection;
import java.io.IOException;
import java.io.Serializable;

import javax.annotation.ManagedBean;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@ManagedBean
@WebServlet(name = "LoginServlet", urlPatterns = {"/Login"})

public class LoginServlet extends HttpServlet implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userID;
    private String password;
    private String url="jdbc:mysql://131.193.209.54:3306/World";
    
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
        String enteredUserId = (String)request.getParameter("userId");
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LoginServlet(String userID, String password, String url) {
		super();
		this.userID = userID;
		this.password = password;
		this.url = url;
	}

}