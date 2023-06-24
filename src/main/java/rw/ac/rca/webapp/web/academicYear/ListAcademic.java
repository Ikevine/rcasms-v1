package rw.ac.rca.webapp.web.academicYear;

import rw.ac.rca.webapp.dao.AcademicYearDAO;
import rw.ac.rca.webapp.dao.impl.AcademcYearDAOImpl;
import rw.ac.rca.webapp.orm.AcademicYear;
import rw.ac.rca.webapp.orm.EnrollmentLevel;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class ListAcademic extends HttpServlet {

    private static AcademicYearDAO academicYearDAO = AcademcYearDAOImpl.getInstance();
    public ListAcademic(){}
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String pageDirection = request.getParameter("page");
        HttpSession httpSession = request.getSession();
        try{
            List<AcademicYear> academicYears = academicYearDAO.getAllAcademicYears();
            httpSession.setAttribute("academic" , academicYears);
            request.getRequestDispatcher("WEB-INF/viewacademic.jsp").forward(request , response);
        }
        catch (Exception e){
            httpSession.setAttribute("error", "Invalid Academic year Level. Try again!");
            e.printStackTrace();
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/viewacademic.jsp");
            dispatcher.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request , response);
    }
}
