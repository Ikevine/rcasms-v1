package rw.ac.rca.webapp.web.parents;



import rw.ac.rca.webapp.dao.ParentsDAO;
import rw.ac.rca.webapp.dao.impl.ParentsDAOImpl;
import rw.ac.rca.webapp.orm.Parents;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class ListParents extends HttpServlet {
    private ParentsDAO parentsDAO = ParentsDAOImpl.getInstance();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String pageDirection = request.getParameter("page");
        HttpSession httpSession = request.getSession();
        try {
            List<Parents>parentsList = parentsDAO.getAllParents();
            httpSession.setAttribute("parents",parentsList);
            request.getRequestDispatcher("WEB-INF/viewparent.jsp").forward(request ,response);
        }
        catch (Exception e){
            System.out.println("eeeeerooo");
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request , response);
    }
}
