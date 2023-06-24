package rw.ac.rca.webapp.web.enrolmentLevel;

import rw.ac.rca.webapp.dao.EnrollmentLevelDAO;
import rw.ac.rca.webapp.dao.impl.EnroLeveLDAOImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class DeleteLevel extends HttpServlet {
    private EnrollmentLevelDAO enrollmentLevelDAO = EnroLeveLDAOImpl.getInstance();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        try{
            enrollmentLevelDAO.deleteEnrolment(id);
            request.getRequestDispatcher("listenrolevel.php").forward(request , response);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
