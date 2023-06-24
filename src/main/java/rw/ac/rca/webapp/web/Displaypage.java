package rw.ac.rca.webapp.web;

import rw.ac.rca.webapp.util.UserRole;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class Displaypage extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String pageRedirect = request.getParameter("direct");
        HttpSession httpSession = request.getSession();

//       switch case for matching
          switch (pageRedirect){
              case "student":
                  request.getRequestDispatcher("Liststudents.php").forward(request,response);
                  break;

              case "parent":
                  request.getRequestDispatcher("listparents.php").forward(request,response);
                  break;

              case  "user":
                  request.getRequestDispatcher("listuser.php").forward(request,response);
                  break;

              case "semester":
                  request.getRequestDispatcher("listsemester.php").forward(request,response);
                  break;

              case "enrollevel":
                  request.getRequestDispatcher("listenrolevel.php").forward(request , response);
                  break;

              case "enroll":
                  request.getRequestDispatcher("listenril.php").forward(request , response);
                  break;

              case "address":
                  request.getRequestDispatcher("listaddress.php").forward(request ,response);
                  break;
              case "courses":
                  request.getRequestDispatcher("listcourses.php").forward(request , response);
                  break;
              case "academic":
                  request.getRequestDispatcher("listacademic.php").forward(request , response);
              default:
                  break;

          }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
