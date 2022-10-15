package com.example.qlbhang;

import dals.Dispath;
import dals.OrderDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import models.Orders;

import java.io.Console;
import java.io.IOException;
import java.util.Vector;

public class OrderServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    OrderDAO orderDAO = new OrderDAO();
    Vector<Orders> ordersVector = new Vector<>();
    ordersVector = orderDAO.getOrder();
    System.out.println(ordersVector);
    log("aa");
    Dispath dispath = new Dispath();
    dispath.dispath(request, response, "/Order/displayOrder.jsp");
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

  }
}
