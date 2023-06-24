package rw.ac.rca.webapp.web.address;

import rw.ac.rca.webapp.dao.AddressDAO;
import rw.ac.rca.webapp.dao.impl.AddressDAOImpl;
import rw.ac.rca.webapp.orm.Address;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ListAddress extends HttpServlet {
    private AddressDAO addressDAO = AddressDAOImpl.getInstance();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      HttpSession httpSession = request.getSession();
      try {
          List<Address>addresses = addressDAO.getAllAddresses();
          httpSession.setAttribute("addresses" , addresses);

          httpSession.setAttribute("success" , "Look the list");
          request.getRequestDispatcher("WEB-INF/viewaddress.jsp").forward(request , response);
      }
      catch (Exception e){
          httpSession.setAttribute("error" , "Sorry we failed to do it");
          request.getRequestDispatcher("WEB-INF/viewaddress.jsp");
      }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
