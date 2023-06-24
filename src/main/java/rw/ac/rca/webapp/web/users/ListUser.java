package rw.ac.rca.webapp.web.users;

import rw.ac.rca.webapp.dao.UserDAO;
import rw.ac.rca.webapp.dao.impl.UserDAOImpl;
import rw.ac.rca.webapp.orm.User;
import rw.ac.rca.webapp.util.UserRole;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class ListUser
 */
public class ListUser extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private UserDAO userDAO = UserDAOImpl.getInstance();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListUser() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pageRedirect = request.getParameter("page");

		HttpSession httpSession = request.getSession();
		Object user = httpSession.getAttribute("authenticatedUser");
		System.out.println("The user in session is: " + user);

		try{
			List<User> users = userDAO.getAllUsers();
			httpSession.setAttribute("users", users);
			UserRole[] userRoles = UserRole.values();
			httpSession.setAttribute("userRoles", userRoles);
			request.getRequestDispatcher("WEB-INF/viewuser.jsp").forward(request , response);
		}
		catch(Exception e){
			httpSession.setAttribute("error", "Invalid User. Try again!");
			e.printStackTrace();
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/adduser.jsp");
			dispatcher.forward(request, response);
		}
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
