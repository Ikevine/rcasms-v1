package rw.ac.rca.webapp.web.enrols;

import rw.ac.rca.webapp.dao.EnrolDAO;
import rw.ac.rca.webapp.dao.impl.EnrilDAOImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class DeleteEnrol extends HttpServlet {
    private EnrolDAO enrolDAO = EnrilDAOImpl.getInstance();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        try{
            enrolDAO.deleteEnrol(id);
            request.getRequestDispatcher("listenril.php").forward(request , response);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
