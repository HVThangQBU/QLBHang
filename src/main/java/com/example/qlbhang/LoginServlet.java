package com.example.qlbhang;

import dals.CustomersDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import models.Customers;
import utils.SessionUtil;

import java.io.IOException;
import java.util.ResourceBundle;

public class LoginServlet extends HttpServlet {
  ResourceBundle resourceBundle = ResourceBundle.getBundle("message");
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String message = request.getParameter("message");
      String alert = request.getParameter("alert");
      if ( message != null && alert != null) {
        request.setAttribute("message", resourceBundle.getString(message));
        request.setAttribute("alert", resourceBundle.getString(alert));
        System.out.println("loi");}
        dispath(request,response,"/Login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      CustomersDAO customersDAO = new CustomersDAO();
      String username = request.getParameter("username");
      String password = request.getParameter("password");
      Customers customers = new Customers();
      customers = customersDAO.getUsernameCus(username, password);
      if (customers != null && customers.getCustomer_id() > 0 ) {
        SessionUtil.getInstance().putValue(request, "USER", customers);
        if (username.equals(customers.getUsername()) && password.equals(customers.getPassword()))  {
          if (customers.getRoleId() == 2) {
            response.sendRedirect("home");
          }
          else {
            response.sendRedirect("admin-homeservlet");
          }
        }
      }
      else {

        response.sendRedirect("login?message=username_password_invalid&alert=alert");

      }


    }
    public void dispath(HttpServletRequest request, HttpServletResponse response, String page)
            throws ServletException, IOException {
        //select jsp to view
        RequestDispatcher dispath
                = request.getRequestDispatcher(page);

        //run
        dispath.forward(request, response);
    }
}
