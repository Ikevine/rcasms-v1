package rw.ac.rca.webapp.web;

import rw.ac.rca.webapp.dao.CourseDAO;
import rw.ac.rca.webapp.dao.impl.CourseDAOImpl;
import rw.ac.rca.webapp.orm.Course;
import rw.ac.rca.webapp.orm.Student;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class UpdateCourse extends HttpServlet {
    private CourseDAO courseDAO = CourseDAOImpl.getInstance();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession httpSession = request.getSession();
        int id = Integer.parseInt(request.getParameter("id"));
        Course existing = courseDAO.getCourseById(id);
        request.setAttribute("exist" , existing);

        request.getRequestDispatcher("WEB-INF/upcourse.jsp").forward(request , response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String pageRedirect = request.getParameter("page");
        HttpSession httpSession = request.getSession();
        Object user = httpSession.getAttribute("authenticatedUser");

        if(pageRedirect != null){
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            if(pageRedirect.equals("createcourse")){
                Course course = null;
                try {
                    course = new Course(
                            request.getParameter("name"),
                            request.getParameter("code"),
                            Integer.parseInt(request.getParameter("min")),
                            Integer.parseInt(request.getParameter("max")),
                            simpleDateFormat.parse(request.getParameter("start")),
                            simpleDateFormat.parse(request.getParameter("end")),
                            false
                    );
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }

                // Saving the course;
                try {
                    courseDAO.updateCourse(course);
                    request.setAttribute("success" , "Successfully created the Course" );
                    request.getRequestDispatcher("listcourses.php").forward(request , response);
                }catch (Exception e){
                    request.setAttribute("error" , "Failed to create the Course" );
                    request.getRequestDispatcher("WEB-INF/createCourse.jsp").forward(request , response);
                }
            }else{
                request.getRequestDispatcher("WEB-INF/login.jsp").forward(request , response);
            }
        }else{
            request.getRequestDispatcher("WEB-INF/login.jsp").forward(request , response);
        }
    }
}
