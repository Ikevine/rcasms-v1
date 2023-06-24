package rw.ac.rca.webapp.web.enrolmentLevel;

import rw.ac.rca.webapp.dao.EnrollmentLevelDAO;
import rw.ac.rca.webapp.dao.impl.EnroLeveLDAOImpl;
import rw.ac.rca.webapp.orm.EnrollmentLevel;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class CreatenrolLevelServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private EnrollmentLevelDAO enrollmentLevelDAO = EnroLeveLDAOImpl.getInstance();

    public  CreatenrolLevelServlet(){
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pageRedirect = request.getParameter("page");
        HttpSession httpSession = request.getSession();
        request.getRequestDispatcher("WEB-INF/adenrollevel.jsp").forward(
                request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession httpSession = request.getSession();
        EnrollmentLevel enrollmentLevel = new EnrollmentLevel();
        String enrolName = request.getParameter("Ename");
        String enrolCode = request.getParameter("Ecode");

        try{
            enrollmentLevel.setCode(enrolCode);
            enrollmentLevel.setName(enrolName);

            enrollmentLevelDAO.saveLevel(enrollmentLevel);
            httpSession.setAttribute("success", "Created successfully");
            request.getRequestDispatcher("listenrolevel.php").forward(request , response);
        }
        catch (Exception e){
            httpSession.setAttribute("error", "Can't Create");
            request.getRequestDispatcher("WEB-INF/adenrollevel.jsp").forward(request, response);
        }
    }
}
