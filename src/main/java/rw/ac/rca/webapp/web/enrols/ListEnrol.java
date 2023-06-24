package rw.ac.rca.webapp.web.enrols;

import rw.ac.rca.webapp.dao.EnrolDAO;
import rw.ac.rca.webapp.dao.impl.EnrilDAOImpl;
import rw.ac.rca.webapp.orm.Enrol;
import rw.ac.rca.webapp.orm.Student;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class ListEnrol extends HttpServlet {
    private EnrolDAO enrolDAO = EnrilDAOImpl.getInstance();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String pageDirection = request.getParameter("page");
        HttpSession httpSession = request.getSession();
        List<Enrol> enrols = enrolDAO.getAllEnrols();
        httpSession.setAttribute("enrols",enrols);
        request.getRequestDispatcher("WEB-INF/viewenroll.jsp").forward(request ,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request , response);
    }
}
