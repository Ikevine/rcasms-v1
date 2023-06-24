package rw.ac.rca.webapp.web.students;


import rw.ac.rca.webapp.dao.AddressDAO;
import rw.ac.rca.webapp.dao.StudentDAO;
import rw.ac.rca.webapp.dao.impl.AddressDAOImpl;
import rw.ac.rca.webapp.dao.impl.StudentDAOImpl;
import rw.ac.rca.webapp.orm.Address;
import rw.ac.rca.webapp.orm.Student;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CreateStudent extends HttpServlet {
private StudentDAO studentDAO = StudentDAOImpl.getInstance();
private AddressDAO addressDAO = AddressDAOImpl.getInstance();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pageDirection = request.getParameter("page");
        HttpSession httpSession = request.getSession();
        request.getRequestDispatcher("WEB-INF/adstudent.jsp").forward(request , response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        HttpSession httpSession = request.getSession();
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

//        take the student address
        Address address = new Address();
        String country = request.getParameter("country");
        String streetCode  = request.getParameter("street");
        String city = request.getParameter("city");
        String postcode = request.getParameter("postal");

        address.setCountry(country);
        address.setCity(city);
        address.setStreetAddress(streetCode);
        address.setPostalCode(postcode);

        student.setFullName(fullName);
        student.setDateOfBirth(dateOfBirth);
        student.setPhoneNumber(phoneNumber);
        student.setRepeating(repeat);
        student.setInternational(inter);
        student.setPartTime(part);
        student.setAddress(address);
            try {

                addressDAO.saveAddress(address);
                Student s1 = studentDAO.saveStudent(student);
                request.setAttribute("s", "Student is created successfully");
                request.getRequestDispatcher("Liststudents.php").forward(request, response);

            } catch (Exception e) {
                request.setAttribute("f", "Fail to create student");
                request.getRequestDispatcher("WEB-INF/adstudent.jsp").forward(request, response);
            }
        }
    }

