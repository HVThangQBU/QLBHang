package com.example.qlbhang;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        dispath(request,response,"/Login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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
