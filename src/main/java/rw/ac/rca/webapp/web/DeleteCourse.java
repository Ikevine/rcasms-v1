package rw.ac.rca.webapp.web;

import rw.ac.rca.webapp.dao.CourseDAO;
import rw.ac.rca.webapp.dao.StudentDAO;
import rw.ac.rca.webapp.dao.impl.CourseDAOImpl;
import rw.ac.rca.webapp.dao.impl.StudentDAOImpl;
import rw.ac.rca.webapp.orm.Course;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class DeleteCourse extends HttpServlet {
    private CourseDAO courseDAO = CourseDAOImpl.getInstance();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        try{
            Course course = courseDAO.getCourseById(id);
            boolean e = courseDAO.deleteCourse(course);
            request.getRequestDispatcher("Liststudents.php").forward(request ,response);
        }
        catch (Exception e){
            System.out.println("result+++");
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
