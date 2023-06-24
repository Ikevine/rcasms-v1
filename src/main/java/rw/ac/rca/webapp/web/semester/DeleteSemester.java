package rw.ac.rca.webapp.web.semester;

import rw.ac.rca.webapp.dao.SemesterDAO;
import rw.ac.rca.webapp.dao.impl.SemesterDAOImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class DeleteSemester extends HttpServlet {
    private SemesterDAO semesterDAO = SemesterDAOImpl.getInstance();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        try{
            semesterDAO.deleteSemester(id);
            request.getRequestDispatcher("listsemester.php").forward(request , response);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
