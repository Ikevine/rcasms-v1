package rw.ac.rca.webapp.web.enrols;

import rw.ac.rca.webapp.dao.*;
import rw.ac.rca.webapp.dao.impl.*;
import rw.ac.rca.webapp.orm.*;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class CreateEnrol extends HttpServlet {

    private EnrolDAO enrolDAO = EnrilDAOImpl.getInstance();
    private AcademicYearDAO academicYearDAO = AcademcYearDAOImpl.getInstance();
    private StudentDAO studentDAO = StudentDAOImpl.getInstance();

    private EnrollmentLevelDAO enrollmentLevelDAO = EnroLeveLDAOImpl.getInstance();
    private SemesterDAO semesterDAO = SemesterDAOImpl.getInstance();
    private  CourseDAO courseDAO = CourseDAOImpl.getInstance();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String pageDirection = request.getParameter("page");

        HttpSession httpSession = request.getSession();

        List<Student> studentsI = studentDAO.getAllStudents();
        List<Semester>semesters = semesterDAO.getallSemester();
        List<Course>courses= courseDAO.getAllCourses();
        List<EnrollmentLevel> enrollmentLevelList = enrollmentLevelDAO.getAllLevels();
        List<AcademicYear>academicYears = academicYearDAO.getAllAcademicYears();

        httpSession.setAttribute("students",studentsI);
        httpSession.setAttribute("semesters" , semesters);
        httpSession.setAttribute("courses" , courses);
        httpSession.setAttribute("level" , enrollmentLevelList);
        httpSession.setAttribute("academics" , academicYears);

        request.getRequestDispatcher("WEB-INF/adenrol.jsp").forward(request , response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        HttpSession httpSession = request.getSession();

        Enrol enrol = new Enrol();
        double grade =Double.parseDouble(request.getParameter("grade"));

        Date enrolDate = null;

        try {
            enrolDate = simpleDateFormat.parse(request.getParameter("Edate"));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        String academic_year = request.getParameter("academic");

        String course_id = request.getParameter("course");
        String enrolLevel_id = request.getParameter("enrolLevel");
        String semester = request.getParameter("semeter");
        int student_id =Integer.parseInt(request.getParameter("student_id"));

        AcademicYear academicYear = academicYearDAO.getByName(academic_year);
        System.out.println(academicYear + "see name acade");
        Course course = courseDAO.getByName(course_id);
        EnrollmentLevel enrollmentLevel = enrollmentLevelDAO.getByName(enrolLevel_id);
        Semester semester1 = semesterDAO.getByName(semester);
        Student student = studentDAO.getStudentById(student_id);

        enrol.setEnrollmentDate(enrolDate);
        enrol.setCourse(course);
        enrol.setAcademicYear(academicYear);
        enrol.setStudent(student);
        enrol.setGrade(grade);
        enrol.setEnrollmentLevel(enrollmentLevel);
        enrol.setSemester(semester1);

        try {

            Enrol E1 = enrolDAO.saveEnrol(enrol);
            request.setAttribute("s", "Student is created successfully");
            request.getRequestDispatcher("listenril.php").forward(request, response);

        } catch (Exception e) {
            request.setAttribute("f", "Fail to create student");
            request.getRequestDispatcher("WEB-INF/adenrol.jsp").forward(request, response);
        }
    }
}
