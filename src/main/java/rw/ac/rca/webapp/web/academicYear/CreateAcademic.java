package rw.ac.rca.webapp.web.academicYear;

import rw.ac.rca.webapp.dao.AcademicYearDAO;
import rw.ac.rca.webapp.dao.impl.AcademcYearDAOImpl;
import rw.ac.rca.webapp.orm.AcademicYear;
import rw.ac.rca.webapp.orm.EnrollmentLevel;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class CreateAcademic extends HttpServlet {

    private static AcademicYearDAO academicYearDAO = AcademcYearDAOImpl.getInstance();
    public CreateAcademic(){
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String pageRedirect = request.getParameter("page");
        HttpSession httpSession = request.getSession();
        request.getRequestDispatcher("WEB-INF/addacademic.jsp").forward(
                request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession httpSession = request.getSession();

        AcademicYear academicYear = new AcademicYear();
        String code = request.getParameter("Acode");
        String name = request.getParameter("Aname");
        try{
             academicYear.setCode(code);
             academicYear.setName(name);
             academicYearDAO.saveAcademicYear(academicYear);

            httpSession.setAttribute("success", "Created successfully");
            request.getRequestDispatcher("listacademic.php").forward(request , response);
        }
        catch (Exception e){
            httpSession.setAttribute("error", "Can't Create");
            request.getRequestDispatcher("WEB-INF/addacademic.jsp").forward(request, response);
        }
    }
}
