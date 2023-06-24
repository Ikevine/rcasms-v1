package rw.ac.rca.webapp.web.address;

import rw.ac.rca.webapp.dao.AddressDAO;
import rw.ac.rca.webapp.dao.impl.AddressDAOImpl;
import rw.ac.rca.webapp.orm.Address;
import rw.ac.rca.webapp.orm.Parents;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class UpdateAddress extends HttpServlet {
    private AddressDAO addressDAO = AddressDAOImpl.getInstance();
    public UpdateAddress(){}
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession httpSession = request.getSession();
        int id = Integer.parseInt(request.getParameter("id"));
        Address existing = addressDAO.getAddressById(id);
        request.setAttribute("exist" , existing);
        request.getRequestDispatcher("WEB-INF/upaddress.jsp").forward(request , response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession httpSession = request.getSession();

        String country = request.getParameter("country");
        String streetCode  = request.getParameter("street");
        String city = request.getParameter("city");
        String postcode = request.getParameter("postal");

        int id = Integer.parseInt(request.getParameter("id"));
        Address existingaddress = addressDAO.getAddressById(id);

        try{
            existingaddress.setCountry(country);
            existingaddress.setCity(city);
            existingaddress.setStreetAddress(streetCode);
            existingaddress.setPostalCode(postcode);

            addressDAO.updateAddress(existingaddress);
            httpSession.setAttribute("success", "Created successfully");
            request.getRequestDispatcher("listaddress.php").forward(request,response);
        }
        catch (Exception e){
            httpSession.setAttribute("error", "Can't Create");
            request.getRequestDispatcher("WEB-INF/upaddress.jsp").forward(
                    request, response);
        }
    }
}
