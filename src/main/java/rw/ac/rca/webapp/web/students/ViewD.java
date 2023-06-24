package rw.ac.rca.webapp.web.students;

import rw.ac.rca.webapp.dao.AddressDAO;
import rw.ac.rca.webapp.dao.EnrolDAO;
import rw.ac.rca.webapp.dao.ParentsDAO;
import rw.ac.rca.webapp.dao.StudentDAO;
import rw.ac.rca.webapp.dao.impl.AddressDAOImpl;
import rw.ac.rca.webapp.dao.impl.EnrilDAOImpl;
import rw.ac.rca.webapp.dao.impl.ParentsDAOImpl;
import rw.ac.rca.webapp.dao.impl.StudentDAOImpl;
import rw.ac.rca.webapp.orm.Address;
import rw.ac.rca.webapp.orm.Enrol;
import rw.ac.rca.webapp.orm.Parents;
import rw.ac.rca.webapp.orm.Student;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class ViewD extends HttpServlet {
    private StudentDAO studentDAO = StudentDAOImpl.getInstance();
    private ParentsDAO parentsDAO = ParentsDAOImpl.getInstance();

    private  EnrolDAO enrolDAO = EnrilDAOImpl.getInstance();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //getting parent info
        int id = Integer.parseInt(request.getParameter("id"));
        Parents parents = parentsDAO.getStudent(id);
        request.setAttribute("pinf" , parents);
       // student info
        Student student = studentDAO.getStudentById(id);
        request.setAttribute("inf" , student);
        //enrollment
        List<Enrol> enrols = enrolDAO.getEnrolByStudent(id);
        request.setAttribute("einf" , enrols);

        request.getRequestDispatcher("WEB-INF/viewd.jsp").forward(request , response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request , response);
    }
}
