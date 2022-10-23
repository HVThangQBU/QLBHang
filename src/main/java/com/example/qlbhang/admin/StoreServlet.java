package com.example.qlbhang.admin;

import dals.Dispath;
import dals.StoreDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import models.Stores;

import java.io.IOException;
import java.util.Vector;

public class StoreServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    StoreDAO storeDAO = new StoreDAO();
    Dispath dispath = new Dispath();
    String service = request.getParameter("service");
    if (service == null){
      service = "display";
    }
    switch (service){
      case "display":
        Vector<Stores> vector = new Vector<>();
        String stname = request.getParameter("stname");
        if(stname == null){
          vector = storeDAO.getStore();
          request.setAttribute("stname","" );
        }
        else {
          vector = storeDAO.searchNameStore(stname);
          request.setAttribute("stname", stname);
        }
        request.setAttribute("store",vector);
        dispath.dispath(request,response,"admin/Stores/displayStore.jsp");
        break;
      case "insert":
        dispath.dispath(request,response,"admin/Stores/insertStore.jsp");
        break;
      case"update":
        String id = request.getParameter("id");
        StoreDAO storeDAO1 = new StoreDAO();
        Stores stores = storeDAO1.getStoreID(id);
        request.setAttribute("storeupdate",stores);
        dispath.dispath(request,response,"admin/Stores/updateStore.jsp");
        break;
      case"delete":
        id = request.getParameter("id");
        storeDAO1 = new StoreDAO();
        stores = storeDAO1.getStoreID(id);
        request.setAttribute("storedelete",stores);
        dispath.dispath(request,response,"admin/Stores/deleteStore.jsp");
    }
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String service = request.getParameter("service");
    switch (service){
      case"insert":
      String store_name = request.getParameter("stname");
      String phone = request.getParameter("stphone");
      String email = request.getParameter("stemail");
      String street = request.getParameter("ststreet");
      String city = request.getParameter("stcity");
      Stores stores = new Stores(store_name,phone,email,street,city);
      StoreDAO storeDAO = new StoreDAO();
      storeDAO.insertStore(stores);
      response.sendRedirect("admin-storeservlet");
      break;
      case"update":
        String store_id = request.getParameter("store_id");
        store_name = request.getParameter("stname");
        phone = request.getParameter("stphone");
        email = request.getParameter("stemail");
        street = request.getParameter("ststreet");
        city = request.getParameter("stcity");
        int store_id2 = Integer.parseInt(store_id);
        stores = new Stores(store_id2,store_name,phone,email,street,city);
        StoreDAO storeDAO1 = new StoreDAO();
        storeDAO1.updateStore(stores);
        response.sendRedirect("admin-storeservlet");
        break;
      case"delete":
        store_id = request.getParameter("store_id");
        storeDAO1 = new StoreDAO();
        storeDAO1.deleteStore(store_id);
        response.sendRedirect("admin-storeservlet");
        break;
    }
  }
}
