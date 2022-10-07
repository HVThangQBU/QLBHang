package com.example.qlbhang;

import dals.Dispath;
import dals.ProductsDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import models.Products;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Vector;

public class ProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Dispath dispath = new Dispath();
        String service = request.getParameter("service");
        if (service == null){
            service = "display";
        }
        switch(service){
            case "display":
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
                dispath.dispath(request,response,"/Products/displayProduct.jsp");
                break;
            case "insert":
                dispath.dispath(request,response,"/Products/InsertProduct.jsp");
                break;
            case "update" :
                String id = request.getParameter("id");
                ProductsDAO productsDAO1 = new ProductsDAO();
                Products products1 = productsDAO1.getProID(id);
                request.setAttribute("productupdate",products1);
                dispath.dispath(request,response,"/Products/updateProduct.jsp");
                break;
            case "delete":
                String id2 = request.getParameter("id");
                ProductsDAO productsDAO2 = new ProductsDAO();
                products1 = productsDAO2.getProID(id2);
                request.setAttribute("productdelete",products1);
                dispath.dispath(request,response,"/Products/deleteProduct.jsp");
                break;

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String service = request.getParameter("service");
        switch (service){
            case "insert":
                String product_name = request.getParameter("pname");
                String image = request.getParameter("product_image");
                int model_year = Integer.parseInt(request.getParameter("model_year"));
                double list_price = Double.parseDouble(request.getParameter("list_price"));
                String brand_name = request.getParameter("brand_name");
                String category_name = request.getParameter("category_name");
                Products products = new Products(product_name, image,model_year,list_price,brand_name,category_name);
                ProductsDAO productsDAO = new ProductsDAO();
                productsDAO.insertProduct(products);
                response.sendRedirect("productservlet");
                break;
            case "update":
                String product_id = request.getParameter("product_id");
                product_name = request.getParameter("pname");
                image = request.getParameter("product_image");
                model_year = Integer.parseInt(request.getParameter("model_year"));
                list_price = Double.parseDouble(request.getParameter("list_price"));
                brand_name = request.getParameter("brand_name");
                category_name = request.getParameter("category_name");
                int product_id2 = Integer.parseInt(product_id);
                products = new Products(product_id2, product_name, image, model_year, list_price, brand_name, category_name);
                ProductsDAO productsDAO1 = new ProductsDAO();
                productsDAO1.updateProduct(products);
                response.sendRedirect("productservlet");
                break;
            case"delete":
                String product_id3 = request.getParameter("product_id");
                ProductsDAO productsDAO2 = new ProductsDAO();
                productsDAO2.deleteProduct(product_id3);
                response.sendRedirect("productservlet");
                break;

        }


       // response.sendRedirect("productservlet");

    }
}
