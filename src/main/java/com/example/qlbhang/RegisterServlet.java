package com.example.qlbhang;

import dals.CustomersDAO;
import dals.Dispath;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import models.Customers;

import java.io.IOException;

public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Dispath dispath = new Dispath();
        dispath.dispath(request,response,"/Register.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String first_name = request.getParameter("fname");
        String last_name = request.getParameter("lname");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String street = request.getParameter("street");
        String city = request.getParameter("city");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Customers cus = new Customers(first_name, last_name, phone, email, street, city, username, password);
        CustomersDAO customersDAO = new CustomersDAO();
        customersDAO.insertCustomer(cus);
        response.sendRedirect("login");
    }
}
