package com.example.qlbhang;

import dals.CustomersDAO;
import dals.Dispath;
import dals.ProductsDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import models.Customers;
import models.Products;

import java.io.IOException;
import java.util.Vector;

@WebServlet(name = "CustomerServlet", value = "/CustomerServlet")
public class CustomerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CustomersDAO customersDAO = new CustomersDAO();
        Dispath dispath = new Dispath();
        String service = request.getParameter("service");
        if (service == null){
            service = "display";
        }
        switch (service){
            case "display":
                Vector<Customers> vector = new Vector<>();
                String cname = request.getParameter("cname");
                if (cname ==null){
                    vector = customersDAO.getCustomers();
                }
                else{
                    vector = customersDAO.searchNameCustomer(cname);
                }
                request.setAttribute("customer", vector);
                dispath.dispath(request,response,"/Customers/display.jsp");
                break;
            case"update":
                String id = request.getParameter("id");
                CustomersDAO customersDAO1 = new CustomersDAO();
                Customers customers = customersDAO1.getCusID(id);
                request.setAttribute("customerupdate",customers);
                dispath.dispath(request,response,"/Customers/updateCustomer.jsp");
                break;
            case "delete":
                String id2 = request.getParameter("id");
                CustomersDAO customersDAO2 = new CustomersDAO();
                Customers customers1 = customersDAO2.getCusID(id2);
                request.setAttribute("customerdelete",customers1);
                dispath.dispath(request,response,"/Customers/deleteCustomer.jsp");


        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String service = request.getParameter("service");
        switch (service){
            case "update":
                String customer_id = request.getParameter("customer_id");
                String first_name = request.getParameter("fname");
                String last_name = request.getParameter("lname");
                String phone = request.getParameter("phone");
                String email = request.getParameter("email");
                String street = request.getParameter("street");
                String city = request.getParameter("city");
                int cusId = Integer.parseInt(customer_id);
                Customers customers = new Customers(cusId,first_name,last_name,phone,email,street,city);
                CustomersDAO customersDAO = new CustomersDAO();
                customersDAO.updateCustomer(customers);
                response.sendRedirect("CustomerServlet");
                break;
            case "delete":
                String customerid = request.getParameter("customer_id");
                CustomersDAO customersDAO1 = new CustomersDAO();
                customersDAO1.deleteCustomer(customerid);
                response.sendRedirect("CustomerServlet");
                break;
        }
    }
}
