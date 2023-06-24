package rw.ac.rca.webapp.web.parents;

import rw.ac.rca.webapp.dao.ParentsDAO;
import rw.ac.rca.webapp.dao.StudentDAO;
import rw.ac.rca.webapp.dao.impl.ParentsDAOImpl;
import rw.ac.rca.webapp.dao.impl.StudentDAOImpl;
import rw.ac.rca.webapp.orm.Parents;
import rw.ac.rca.webapp.orm.Student;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CreateParents extends HttpServlet {

     private ParentsDAO parentsDAO = ParentsDAOImpl.getInstance();
     private StudentDAO studentDAO = StudentDAOImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pageDirection = request.getParameter("page");
        HttpSession httpSession = request.getSession();
        request.getRequestDispatcher("WEB-INF/adparent.jsp").forward(request , response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        HttpSession httpSession = request.getSession();
        Parents parents = new Parents();

        String fullName = request.getParameter("name");
        Date dateOfBirth = null;
        try {
            dateOfBirth = simpleDateFormat.parse(request.getParameter("birth"));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        //   my checkbox here

        String phoneNumber = request.getParameter("phone");

        int student_no = Integer.parseInt(request.getParameter("st_number"));
        Student student = studentDAO.getStudentById(student_no);
        System.out.println(student.getFullName() + "Keke this is my name");

        parents.setFullName(fullName);
        parents.setPhoneNumber(phoneNumber);
        parents.setDateOfBirth(dateOfBirth);

        parents.setStudent(student);


        try {

            parentsDAO.saveParent(parents);
            request.setAttribute("s", "Parent is created successfully");
            request.getRequestDispatcher("listparents.php").forward(request, response);

        } catch (Exception e) {
            request.setAttribute("f", "Fail to create student");
            e.printStackTrace();
            System.out.println("Keke this is my name");
            request.getRequestDispatcher("WEB-INF/adparent.jsp").forward(request, response);
        }
    }
}
