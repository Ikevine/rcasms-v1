package rw.ac.rca.webapp.web.students;

import rw.ac.rca.webapp.dao.StudentDAO;
import rw.ac.rca.webapp.dao.impl.StudentDAOImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class DeleteStudent extends HttpServlet {
    private StudentDAO studentDAO = StudentDAOImpl.getInstance();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       int id = Integer.parseInt(request.getParameter("id"));
       try{
           boolean e = studentDAO.deleteStudent(id);
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
