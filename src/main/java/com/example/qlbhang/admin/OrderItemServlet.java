package com.example.qlbhang.admin;

import dals.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
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
      dispath.dispath(request, response, "admin/orderitem/displayOrderItem.jsp");
      break;
      case "insertEdit":
        OrderItems orderItems = new OrderItems();
        String idOder = request.getParameter("idOrder");
        String idItem = request.getParameter("idOItem");
        ordersVector = orderDAO.getOrder();
        request.setAttribute("ordersVector", ordersVector);
        productsVector = productsDAO.getProducts();
        request.setAttribute("productsVector", productsVector);

        if (idOder != null && idItem != null) {
          orderItems = orderItemDAO.getOrderItemId(idItem, idOder );
          request.setAttribute("orderItems", orderItems);
        }
        dispath.dispath(request, response, "admin/orderitem/insertEditOrderItem.jsp");
        break;
      case "delete":
        idOder = request.getParameter("idOrder");
        idItem = request.getParameter("idOItem");
        ordersVector = orderDAO.getOrder();
        request.setAttribute("ordersVector", ordersVector);
        productsVector = productsDAO.getProducts();
        request.setAttribute("productsVector", productsVector);
        if (idOder != null && idItem != null) {
          orderItems = orderItemDAO.getOrderItemId(idItem, idOder );
          request.setAttribute("orderItems", orderItems);
        }
        dispath.dispath(request, response, "admin/orderitem/deleteOrderItem.jsp");
        break;
    }

  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String service = request.getParameter("service");
    switch (service) {
      case "insertEdit":
        String order_id = request.getParameter("order_id");
        String item_id = request.getParameter("item_id");
        String product_id = request.getParameter("product_id");
        String quanlity = request.getParameter("quanlity");
        String listprice = request.getParameter("listprice");
        String discount = request.getParameter("discount");
        OrderItems orderItems = new OrderItems(Integer.parseInt(order_id), Integer.parseInt(item_id), Integer.parseInt(product_id), Integer.parseInt(quanlity), Float.parseFloat(listprice), Float.parseFloat(discount));
        if (order_id == "" && item_id =="") {
//          orderItemDAO.insertOrderItem(orderItems);
          response.sendRedirect("admin-orderItemServlet");
        } else {
          orderItemDAO.update(orderItems);
          response.sendRedirect("admin-orderItemServlet");
        }
        break;
      case "delete":
        order_id = request.getParameter("order_id");
        item_id = request.getParameter("item_id");
        orderItemDAO.deleteOrderItem(item_id,order_id);
        response.sendRedirect("admin-orderItemServlet");
    }
  }
}
