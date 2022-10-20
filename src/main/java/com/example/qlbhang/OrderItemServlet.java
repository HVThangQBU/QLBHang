package com.example.qlbhang;

import dals.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import models.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class OrderItemServlet extends HttpServlet {
  private final OrderDAO orderDAO = new OrderDAO();
  Vector<Orders> ordersVector = new Vector<>();
  private final CustomersDAO customersDAO = new CustomersDAO();
  Vector<Customers> customersVector = new Vector<>();
  private final StoreDAO storeDAO = new StoreDAO();
  Vector<Stores> storesVector = new Vector<>();
  private final StaffsDAO staffsDAO = new StaffsDAO();
  List<Staffs> staffsList = new ArrayList<>();
  private final OrderItemDAO orderItemDAO = new OrderItemDAO();
  List<OrderItems> orderItemsList = new ArrayList<>();
  private final ProductsDAO productsDAO = new ProductsDAO();
  Vector<Products> productsVector = new Vector<>();
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    Dispath dispath = new Dispath();
    String service = request.getParameter("service");
    if (service == null) {
      service = "display";
    }
    switch (service) {
      case "display":
      productsVector = productsDAO.getProducts();
      orderItemsList = orderItemDAO.getAllOrderItem();
      request.setAttribute("productsVector", productsVector);
      request.setAttribute("orderItemsList", orderItemsList);
      dispath.dispath(request, response, "/orderitem/displayOrderItem.jsp");
      break;
      case "insertEdit":
        String idOder = (String) request.getAttribute("idOrder");
        String idItem = (String) request.getAttribute("idItem");
        OrderItems orderItems = new OrderItems();
        if ( idOder != null && idItem !=null) {
          orderItems = orderItemDAO.getOrderItemId(idOder, idItem);
          request.setAttribute("orderItems", orderItems);
        }
        dispath.dispath(request, response, "/orderitem/insertEditOrderItem.jsp");
        break;
    }

  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

  }
}
