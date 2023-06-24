package rw.ac.rca.webapp.web.address;

import rw.ac.rca.webapp.dao.AddressDAO;
import rw.ac.rca.webapp.dao.impl.AddressDAOImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class DeleteAddress extends HttpServlet {
    private AddressDAO addressDAO = AddressDAOImpl.getInstance();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        try{
            addressDAO.deleteAddress(id);
            request.getRequestDispatcher("listaddress.php").forward(request , response);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
