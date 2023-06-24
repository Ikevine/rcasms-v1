package rw.ac.rca.webapp.web.address;

import rw.ac.rca.webapp.dao.AddressDAO;
import rw.ac.rca.webapp.dao.impl.AddressDAOImpl;
import rw.ac.rca.webapp.orm.Address;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class CreateAddress extends HttpServlet {
    private AddressDAO addressDAO = AddressDAOImpl.getInstance();
    public CreateAddress(){}
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession httpSession = request.getSession();
        request.getRequestDispatcher("WEB-INF/adaddresss.jsp").forward(
                request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession httpSession = request.getSession();
        Address address = new Address();
        String country = request.getParameter("country");
        String streetCode  = request.getParameter("street");
        String city = request.getParameter("city");
        String postcode = request.getParameter("postal");
        try{
            address.setCountry(country);
            address.setCity(city);
            address.setStreetAddress(streetCode);
            address.setPostalCode(postcode);

            addressDAO.saveAddress(address);
            httpSession.setAttribute("success", "Created successfully");
            request.getRequestDispatcher("listaddress.php").forward(request,response);
        }
        catch (Exception e){
            httpSession.setAttribute("error", "Can't Create");
            request.getRequestDispatcher("WEB-INF/adaddresss.jsp").forward(
                    request, response);
        }
    }
}
