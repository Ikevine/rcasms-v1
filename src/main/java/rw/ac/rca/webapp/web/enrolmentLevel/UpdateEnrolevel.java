package rw.ac.rca.webapp.web.enrolmentLevel;

import rw.ac.rca.webapp.dao.EnrollmentLevelDAO;
import rw.ac.rca.webapp.dao.impl.EnroLeveLDAOImpl;
import rw.ac.rca.webapp.orm.EnrollmentLevel;
import rw.ac.rca.webapp.orm.Parents;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class UpdateEnrolevel extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private EnrollmentLevelDAO enrollmentLevelDAO = EnroLeveLDAOImpl.getInstance();

    public  UpdateEnrolevel(){
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession httpSession = request.getSession();
        int id = Integer.parseInt(request.getParameter("id"));
        EnrollmentLevel existing = enrollmentLevelDAO.getEnrolmentLevel(id);
        request.setAttribute("exist" , existing);
        request.getRequestDispatcher("WEB-INF/uplevel.jsp").forward(request , response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession httpSession = request.getSession();

        String enrolName = request.getParameter("Ename");
        String enrolCode = request.getParameter("Ecode");


        int id = Integer.parseInt(request.getParameter("id"));
        EnrollmentLevel existinglevel = enrollmentLevelDAO.getEnrolmentLevel(id);;

        try{
            existinglevel.setCode(enrolCode);
            existinglevel.setName(enrolName);

            enrollmentLevelDAO.updateLevel(existinglevel);

            httpSession.setAttribute("success", "Created successfully");
            request.getRequestDispatcher("listenrolevel.php").forward(request , response);
        }
        catch (Exception e){
            httpSession.setAttribute("error", "Can't Create");
            request.getRequestDispatcher("WEB-INF/uplevel.jsp").forward(request, response);
        }
    }
}
