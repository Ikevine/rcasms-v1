package rw.ac.rca.webapp.web.users;

import rw.ac.rca.webapp.dao.UserDAO;
import rw.ac.rca.webapp.dao.impl.UserDAOImpl;
import rw.ac.rca.webapp.orm.User;
import rw.ac.rca.webapp.util.UserRole;
import rw.ac.rca.webapp.util.Util;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Servlet implementation class CreateUser
 */
public class AddUser extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDAO userDAO = UserDAOImpl.getInstance();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUser() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pageRedirect = request.getParameter("page");
        HttpSession httpSession = request.getSession();
        UserRole[] userRoles = UserRole.values();
        httpSession.setAttribute("userRoles", userRoles);
        request.getRequestDispatcher("WEB-INF/aduser.jsp").forward(
                request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException , IOException {
        HttpSession httpSession = request.getSession();
        User user = new User();
        String usernameauth = request.getParameter("username");
        String passwordauth = request.getParameter("password");
        String userfullname = request.getParameter("userfullname");
        String email = request.getParameter("email");
        String userRole = request.getParameter("userRole");
        UserRole usrr = UserRole.valueOf(userRole);

        try {
            String hashedPsw = Util.generateHashed512(passwordauth);

            user.setUsername(usernameauth);
            user.setPassword(hashedPsw);
            user.setFullName(userfullname);
            user.setEmail(email);
            user.setUserRole(usrr);

            userDAO.saveOrUpdateUser(user);

            httpSession.setAttribute("success", "Created successfully");
            request.getRequestDispatcher("listuser.php").forward(request , response);

        }
        catch (Exception e) {
            httpSession.setAttribute("error", "Can't Create");
            request.getRequestDispatcher("WEB-INF/aduser.jsp").forward(
                    request, response);
        }

    }

}
