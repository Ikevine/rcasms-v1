package rw.ac.rca.webapp.web.students;

import rw.ac.rca.webapp.dao.AddressDAO;
import rw.ac.rca.webapp.dao.StudentDAO;
import rw.ac.rca.webapp.dao.impl.AddressDAOImpl;
import rw.ac.rca.webapp.dao.impl.StudentDAOImpl;
import rw.ac.rca.webapp.orm.Address;
import rw.ac.rca.webapp.orm.Student;
import rw.ac.rca.webapp.orm.User;
import rw.ac.rca.webapp.util.UserRole;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UpdateStudent extends HttpServlet {
    private StudentDAO studentDAO = StudentDAOImpl.getInstance();
    private AddressDAO addressDAO = AddressDAOImpl.getInstance();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession httpSession = request.getSession();
        int id = Integer.parseInt(request.getParameter("id"));
        Student existing = studentDAO.getStudentById(id);
        request.setAttribute("exist" , existing);
        request.getRequestDispatcher("WEB-INF/upstudent.jsp").forward(request , response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //        getting the student
        int id = Integer.parseInt(request.getParameter("id"));
        Student existing = studentDAO.getStudentById(id);

        Address existingAddress = existing.getAddress();

        HttpSession httpSession = request.getSession();

        System.out.println(existing.getFullName() + "my fullname here kevine");
        System.out.println(existing.getAddress().getCountry() + "my country");


        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Student student = new Student();
        String fullName = request.getParameter("fullName");

        Date dateOfBirth = null;
        try {
            dateOfBirth = simpleDateFormat.parse(request.getParameter("birth"));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        //   my checkbox here
        boolean inter = Boolean.parseBoolean(request.getParameter("inter"));
        boolean part = Boolean.parseBoolean(request.getParameter("part"));
        boolean repeat = Boolean.parseBoolean(request.getParameter("repeat"));
        String phoneNumber = request.getParameter("phone");


//        update student
        String country = request.getParameter("country");
        String streetCode  = request.getParameter("street");
        String city = request.getParameter("city");
        String postcode = request.getParameter("postal");



        try {
            existingAddress.setPostalCode(postcode);
            existingAddress.setCity(city);
            existingAddress.setCountry(country);
            existingAddress.setStreetAddress(streetCode);

             existing.setAddress(existingAddress);
             existing.setFullName(fullName);
             existing.setInternational(inter);
             existing.setRepeating(repeat);
             existing.setPhoneNumber(phoneNumber);
             existing.setDateOfBirth(dateOfBirth);
             existing.setPartTime(part);

            Student s1 = studentDAO.updateStudent(existing);
            addressDAO.updateAddress(existingAddress);
            request.setAttribute("s", "Student is created successfully");
            request.getRequestDispatcher("Liststudents.php").forward(request, response);

        } catch (Exception e) {
            request.setAttribute("f", "Fail to create student");
            e.printStackTrace();
            request.getRequestDispatcher("WEB-INF/upstudent.jsp").forward(request, response);
        }
    }
}
