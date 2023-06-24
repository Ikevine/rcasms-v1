package rw.ac.rca.webapp.web.parents;

import rw.ac.rca.webapp.dao.ParentsDAO;
import rw.ac.rca.webapp.dao.impl.ParentsDAOImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class Deleteparent extends HttpServlet {
    private ParentsDAO parentsDAO = ParentsDAOImpl.getInstance();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       int id =Integer.parseInt(request.getParameter("id"));
       try{
           parentsDAO.deleteParent(id);
           request.getRequestDispatcher("listparents.php").forward(request , response);
       }
       catch (Exception e){
           e.printStackTrace();
       }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
