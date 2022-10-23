package com.example.qlbhang.admin;

import dals.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import models.Customers;
import models.Orders;
import models.Staffs;
import models.Stores;

import java.io.Console;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;


public class OrderServlet extends HttpServlet {
  private final OrderDAO orderDAO = new OrderDAO();

  private final CustomersDAO customersDAO = new CustomersDAO();
  private final StoreDAO storeDAO = new StoreDAO();
  private final StaffsDAO staffsDAO = new StaffsDAO();
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    Dispath dispath = new Dispath();

    Orders orders = new Orders();

    Vector<Orders> ordersVector = new Vector<>();

    Vector<Customers> customersVector = new Vector<>();

    Vector<Stores> storesVector = new Vector<>();

    List<Staffs> staffsList = new ArrayList<>();

    String service = request.getParameter("service");
    if (service == null) {
      service = "display";
    }
    switch (service) {
      case "display" :
        String name = request.getParameter("name");
        if (name == null) {
          request.setAttribute("name","");
          ordersVector = orderDAO.getOrder();
        }
        else {
          ordersVector = orderDAO.searchNameOrders(name);
          request.setAttribute("name",name);
        }
        staffsList = staffsDAO.getStaffs();
        request.setAttribute("staffList" ,staffsList);

        storesVector = storeDAO.getStore();
        request.setAttribute("storesVector" ,storesVector);

        customersVector = customersDAO.getCustomers();
        request.setAttribute("customersVector" ,customersVector);

        request.setAttribute("order", ordersVector);

        request.setAttribute("titletable", Orders.class.getSimpleName());
        dispath.dispath(request, response, "admin/Order/displayOrder.jsp");
        break;
      case "insertUpdate" :
        String id = request.getParameter("id");
        staffsList = staffsDAO.getStaffs();
        request.setAttribute("staffList" ,staffsList);

        storesVector = storeDAO.getStore();
        request.setAttribute("storesVector" ,storesVector);

        customersVector = customersDAO.getCustomers();
        request.setAttribute("customersVector" ,customersVector);

        ordersVector = orderDAO.getOrder();
        request.setAttribute("ordersVector", ordersVector);

        if ( id != null) {
          orders = this.orderDAO.getOrderId(id);
          request.setAttribute("order", orders);
        }
        dispath.dispath(request, response, "admin/Order/insertEditOrder.jsp");
        break;
      case "delete":
        id = request.getParameter("id");
        staffsList = staffsDAO.getStaffs();
        request.setAttribute("staffList" ,staffsList);

        storesVector = storeDAO.getStore();
        request.setAttribute("storesVector" ,storesVector);

        customersVector = customersDAO.getCustomers();
        request.setAttribute("customersVector" ,customersVector);

        ordersVector = orderDAO.getOrder();
        request.setAttribute("ordersVector", ordersVector);
        orders = this.orderDAO.getOrderId(id);
        request.setAttribute("order", orders);
        dispath.dispath(request,response,"admin/Order/deleteOrder.jsp");

    }


  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String service = request.getParameter("service");
    switch (service){
      case "insertUpdate":
      String  order_id = request.getParameter("order_id");
      String customer_id = request.getParameter("customer_id");
      String order_status = request.getParameter("order_status");
      String order_date = request.getParameter("order_date");
      String required_date = request.getParameter("required_date");
      String shipped_date = request.getParameter("shipped_date");
      String store_id = request.getParameter("store_id");
      String staff_id = request.getParameter("staff_id");
      if (order_id == "" ) {
        Orders orders = new Orders(Integer.parseInt(customer_id), Integer.parseInt(order_status), order_date, required_date, shipped_date
          , Integer.parseInt(store_id), Integer.parseInt(staff_id));
        this.orderDAO.insertOrder(orders);
        response.sendRedirect("admin-orderServlet");
      }
      else {
        Orders orders = new Orders(Integer.parseInt(order_id), Integer.parseInt(customer_id), Integer.parseInt(order_status), order_date, required_date, shipped_date
          , Integer.parseInt(store_id), Integer.parseInt(staff_id));
        this.orderDAO.editOrder(orders);
        //response.sendRedirect("orderServlet");
        String action = request.getParameter("delete");
        if ("delete".equalsIgnoreCase(action)){
          this.orderDAO.deleteOrder(order_id);
        }
        response.sendRedirect("admin-orderServlet");
      }
      break;
      case "delete":
        order_id = request.getParameter("order_id");
        this.orderDAO.deleteOrder(order_id);
        response.sendRedirect("admin-orderServlet");
    }


  }
}
