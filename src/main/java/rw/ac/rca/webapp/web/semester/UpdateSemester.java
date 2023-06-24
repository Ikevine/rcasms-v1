package rw.ac.rca.webapp.web.semester;

import rw.ac.rca.webapp.dao.SemesterDAO;
import rw.ac.rca.webapp.dao.impl.SemesterDAOImpl;
import rw.ac.rca.webapp.orm.Semester;
import rw.ac.rca.webapp.orm.Student;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UpdateSemester extends HttpServlet {
    private SemesterDAO semesterDAO = SemesterDAOImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession httpSession = request.getSession();
        int id = Integer.parseInt(request.getParameter("id"));
        Semester existing = semesterDAO.findBySemesterId(id);

        System.out.println(existing.getName() + "now here name");

        request.setAttribute("exist" , existing);
        request.getRequestDispatcher("WEB-INF/upsemester.jsp").forward(
                request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        HttpSession httpSession = request.getSession();


        int id = Integer.parseInt(request.getParameter("id"));
        Semester existingSemester = semesterDAO.findBySemesterId(id);

        Date Sdate = null;
        Date Edate = null;
        try {
            Sdate = simpleDateFormat.parse(request.getParameter("Sdate"));
            Edate = simpleDateFormat.parse(request.getParameter("Edate"));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }



        String name = request.getParameter("Sname");
        String code = request.getParameter("Scode");

        try{
            existingSemester.setCode(code);
            existingSemester.setName(name);
            existingSemester.setStartDate(Sdate);
            existingSemester.setEndDate(Edate);

            semesterDAO.updateSemester(existingSemester);
            httpSession.setAttribute("success", "Created successfully");

            request.getRequestDispatcher("listsemester.php").forward(request , response);
        }
        catch (Exception e){
            httpSession.setAttribute("error", "Can't Create");
            request.getRequestDispatcher("WEB-INF/upsemester.jsp").forward(request, response);
        }
    }
}
