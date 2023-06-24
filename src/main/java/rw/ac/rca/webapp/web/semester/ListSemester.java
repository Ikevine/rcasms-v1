package rw.ac.rca.webapp.web.semester;

import rw.ac.rca.webapp.dao.SemesterDAO;
import rw.ac.rca.webapp.dao.impl.SemesterDAOImpl;
import rw.ac.rca.webapp.orm.EnrollmentLevel;
import rw.ac.rca.webapp.orm.Semester;
import rw.ac.rca.webapp.orm.Student;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class ListSemester extends HttpServlet {
    private SemesterDAO semesterDAO = SemesterDAOImpl.getInstance();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String pageDirection = request.getParameter("page");
        HttpSession httpSession = request.getSession();
        try{
            List<Semester> semesters = semesterDAO.getallSemester();
            httpSession.setAttribute("sms",semesters);
            request.getRequestDispatcher("WEB-INF/viewsemester.jsp").forward(request , response);
        }
        catch (Exception e){
            httpSession.setAttribute("error", "Invalid Enrol Level. Try again!");
            e.printStackTrace();
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/createsemester.jsp");
            dispatcher.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     doGet(request , response);
    }
}
