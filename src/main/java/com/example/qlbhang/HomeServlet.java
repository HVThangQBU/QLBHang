package com.example.qlbhang;

import dals.CustomersDAO;
import dals.Dispath;
import dals.ProductsDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import models.Customers;
import models.Products;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String title = "test";
        request.setAttribute("title",title);

        ProductsDAO productsDAO = new ProductsDAO();
        Vector<Products> vector = new Vector<>();
        String pname = request.getParameter("pname");
        if (pname == null){
          vector = productsDAO.getProducts();
        }
        else{
          vector = productsDAO.searchNameProduct(pname);
        }
        request.setAttribute("product",vector);
        dispath(request,response,"/Home.jsp");
        out.println("<html><body>");
        out.println("<h1>login here</h1>");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    public void destroy() {
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
