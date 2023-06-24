package rw.ac.rca.webapp.web.academicYear;

import rw.ac.rca.webapp.dao.AcademicYearDAO;
import rw.ac.rca.webapp.dao.impl.AcademcYearDAOImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class DeleteAcademic extends HttpServlet {
    private static AcademicYearDAO academicYearDAO = AcademcYearDAOImpl.getInstance();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        try{
            academicYearDAO.deleteAcademicYear(id);
            request.getRequestDispatcher("listacademic.php").forward(request , response);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
