package rw.ac.rca.webapp.web.enrolmentLevel;

import rw.ac.rca.webapp.dao.EnrollmentLevelDAO;
import rw.ac.rca.webapp.dao.impl.EnroLeveLDAOImpl;
import rw.ac.rca.webapp.orm.EnrollmentLevel;
import rw.ac.rca.webapp.orm.Student;
import rw.ac.rca.webapp.orm.User;
import rw.ac.rca.webapp.util.UserRole;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class ListEnrolLevel extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private EnrollmentLevelDAO enrollmentLevelDAO = EnroLeveLDAOImpl.getInstance();

    public  ListEnrolLevel(){
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String pageDirection = request.getParameter("page");
        HttpSession httpSession = request.getSession();
        try{
            List<EnrollmentLevel> enrollmentLevelList = enrollmentLevelDAO.getAllLevels();
            httpSession.setAttribute("enrolLevel" , enrollmentLevelList);
            request.getRequestDispatcher("WEB-INF/viewenrollevel.jsp").forward(request , response);
        }
        catch (Exception e){
            httpSession.setAttribute("error", "Invalid Enrol Level. Try again!");
            e.printStackTrace();
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/viewenrollevel.jsp");
            dispatcher.forward(request, response);
        }
   }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request , response);
    }
}
