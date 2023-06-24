package rw.ac.rca.webapp.web.users;

import rw.ac.rca.webapp.dao.UserDAO;
import rw.ac.rca.webapp.dao.impl.UserDAOImpl;
import rw.ac.rca.webapp.orm.User;
import rw.ac.rca.webapp.util.UserRole;
import rw.ac.rca.webapp.util.Util;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class UpdateUser extends HttpServlet {
    private UserDAO userDAO = UserDAOImpl.getInstance();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession httpSession = request.getSession();
        int id = Integer.parseInt(request.getParameter("id"));
        User existing = userDAO.getUserById(id);
        UserRole[] userRoles = UserRole.values();
        httpSession.setAttribute("userRoles", userRoles);
        request.setAttribute("exist" , existing);
        request.getRequestDispatcher("WEB-INF/upuser.jsp").forward(request , response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        getting the user
        int id = Integer.parseInt(request.getParameter("id"));
        User existing = userDAO.getUserById(id);
        HttpSession httpSession = request.getSession();

        String usernameauth = request.getParameter("username");
        String passwordauth = request.getParameter("password");
        String userfullname = request.getParameter("userfullname");
        String email = request.getParameter("email");
        String userRole = request.getParameter("userRole");
        UserRole usrr = UserRole.valueOf(userRole);

        try {
            String hashedPsw = Util.generateHashed512(passwordauth);

            existing.setUsername(usernameauth);
            existing.setPassword(hashedPsw);
            existing.setFullName(userfullname);
            existing.setEmail(email);
            existing.setUserRole(usrr);

            userDAO.updateUser(existing);

            httpSession.setAttribute("success", "Created successfully");
            request.getRequestDispatcher("listuser.php").forward(request , response);

        }
        catch (Exception e) {
            httpSession.setAttribute("error", "Can't Create");
            request.getRequestDispatcher("WEB-INF/updateuser.jsp").forward(
                    request, response);
        }

    }

}
