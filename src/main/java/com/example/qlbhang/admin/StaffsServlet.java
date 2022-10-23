package com.example.qlbhang.admin;

import dals.Dispath;
import dals.StaffsDAO;
import dals.StoreDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import models.Staffs;
import models.Stores;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public class StaffsServlet extends HttpServlet {
  private final StaffsDAO staffsDAO1 = new StaffsDAO();
  private  static final StoreDAO storeDao = new StoreDAO();

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    Dispath dispath = new Dispath();
    String service = request.getParameter("service");

    Vector<Stores> storesVector = new Vector<>();
    StoreDAO storeDAO = new StoreDAO();
    storesVector = storeDAO.getStore();
    request.setAttribute("store",storesVector);
    if (service == null){
        service = "display";
    }
    switch (service){
      case "display":
        StaffsDAO staffsDAO = new StaffsDAO();
        List<Staffs>  staffsList = new ArrayList<>();
        String st_first_name = request.getParameter("st_first_name");
        if (st_first_name == null){
          request.setAttribute("name","");
          staffsList = staffsDAO.getStaffs();
        }else{
          staffsList = staffsDAO.searchNameStaff(st_first_name);
          request.setAttribute("name",st_first_name);
        }
        request.setAttribute("staffs",staffsList);
        request.setAttribute("titletable",Staffs.class.getSimpleName());
        dispath.dispath(request,response,"admin/Staffs/displayStaffs.jsp");
        break;
      case "insert":
        staffsDAO = new StaffsDAO();
        staffsList = staffsDAO.getStaffs();
        request.setAttribute("staffs",staffsList);
        dispath.dispath(request,response,"admin/Staffs/insertStaffs.jsp");
        break;
      case "update":
        String id = request.getParameter("id");
        Staffs staffs = this.staffsDAO1.getStaffId(id);

        List<Stores> listStore = this.storeDao.getStore();
        List<Staffs> listStaff = this.staffsDAO1.getListManager();

        request.setAttribute("staffs",staffs);
        request.setAttribute("listStaff",listStaff);
        request.setAttribute("listStore",listStore);
        dispath.dispath(request,response,"admin/Staffs/updateStaffs.jsp");
        break;
      case "delete":
        id = request.getParameter("id");
        staffs = this.staffsDAO1.getStaffId(id);
        listStore = this.storeDao.getStore();
        listStaff = this.staffsDAO1.getListManager();
        request.setAttribute("staffs",staffs);
        request.setAttribute("listStaff",listStaff);
        request.setAttribute("listStore",listStore);
        dispath.dispath(request,response,"admin/Staffs/deleteStaffs.jsp");

    }
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String service = request.getParameter("service");
    switch (service){
      case"insert":
        String first_name = request.getParameter("st_first_name");
        String last_name = request.getParameter("st_last_name");
        String email = request.getParameter("stemail");
        String phone = request.getParameter("stphone");
        String active = request.getParameter("active");
        String store_id = request.getParameter("store_id");
        String manager_id = request.getParameter("manager_id");
        String username = request.getParameter("stusername");
        String password = request.getParameter("stpassword");
        Staffs staffs = new Staffs(first_name,last_name,email,phone,Integer.parseInt(active),Integer.parseInt(store_id),Integer.parseInt(manager_id),username,password);
        StaffsDAO staffsDAO = new StaffsDAO();
        staffsDAO.insertStaffs(staffs);
        response.sendRedirect("admin-staffsServlet");
        break;
      case "update":
        String staff_id = request.getParameter("staff_id");
        first_name = request.getParameter("st_first_name");
        last_name = request.getParameter("st_last_name");
        email = request.getParameter("stemail");
        phone = request.getParameter("stphone");
        active = request.getParameter("active");
        store_id = request.getParameter("store_id");
        manager_id = request.getParameter("manager_id");
        username = request.getParameter("stusername");
        password = request.getParameter("stpassword");
        staffs = new Staffs(Integer.parseInt(staff_id),first_name,last_name,email,phone,Integer.parseInt(active),Integer.parseInt(store_id),Integer.parseInt(manager_id),username,password);
        this.staffsDAO1.updateStaff(staffs);
        response.sendRedirect("admin-staffsServlet");
        break;
      case "delete":
        staff_id = request.getParameter("staff_id");
        this.staffsDAO1.deleteStaff(staff_id);
        response.sendRedirect("admin-staffsServlet");
    }
  }
}
