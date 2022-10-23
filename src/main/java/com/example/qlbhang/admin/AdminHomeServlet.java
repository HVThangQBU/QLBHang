package com.example.qlbhang.admin;

import dals.Dispath;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "AdminHomeServlet", value = "/admin-homeservlet")
public class AdminHomeServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    Dispath dispath = new Dispath();

    dispath.dispath(request,response,"/admin/adminHome.jsp");
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

  }
}
