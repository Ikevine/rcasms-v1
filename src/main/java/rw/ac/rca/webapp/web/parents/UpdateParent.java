package rw.ac.rca.webapp.web.parents;

import rw.ac.rca.webapp.dao.ParentsDAO;
import rw.ac.rca.webapp.dao.StudentDAO;
import rw.ac.rca.webapp.dao.impl.ParentsDAOImpl;
import rw.ac.rca.webapp.dao.impl.StudentDAOImpl;
import rw.ac.rca.webapp.orm.Parents;
import rw.ac.rca.webapp.orm.Semester;
import rw.ac.rca.webapp.orm.Student;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UpdateParent extends HttpServlet {
    private ParentsDAO parentsDAO = ParentsDAOImpl.getInstance();
    private StudentDAO studentDAO = StudentDAOImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession httpSession = request.getSession();
        int id = Integer.parseInt(request.getParameter("id"));
        Parents existing = parentsDAO.findParentById(id);
        request.setAttribute("exist" , existing);
        request.getRequestDispatcher("WEB-INF/upparent.jsp").forward(request , response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        HttpSession httpSession = request.getSession();

        int id = Integer.parseInt(request.getParameter("id"));
        Parents existingParent = parentsDAO.findParentById(id);

        String fullName = request.getParameter("name");
        Date dateOfBirth = null;
        try {
            dateOfBirth = simpleDateFormat.parse(request.getParameter("birth"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        //   my checkbox here

        String phoneNumber = request.getParameter("phone");

        int student_no = Integer.parseInt(request.getParameter("st_number"));
        Student student = studentDAO.getStudentById(student_no);

        existingParent.setFullName(fullName);
        existingParent.setPhoneNumber(phoneNumber);
        existingParent.setDateOfBirth(dateOfBirth);

        existingParent.setStudent(student);


        try {

            parentsDAO.updateParent(existingParent);

            request.setAttribute("s", "Parent is created successfully");
            request.getRequestDispatcher("listparents.php").forward(request, response);

        } catch (Exception e) {
            request.setAttribute("f", "Fail to create student");
            e.printStackTrace();
            System.out.println("Keke this is my name");
            request.getRequestDispatcher("WEB-INF/upparent.jsp").forward(request, response);
        }
    }
}
