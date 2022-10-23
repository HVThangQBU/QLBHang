package com.example.qlbhang.filter;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Customers;
import utils.SessionUtil;

import java.io.IOException;

public class AuthorizationFilter implements Filter {
  private ServletContext context;

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
    this.context = filterConfig.getServletContext();
  }

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
    HttpServletRequest request = (HttpServletRequest) servletRequest;
    HttpServletResponse response = (HttpServletResponse) servletResponse;
    String url = request.getRequestURI();
    if (url.startsWith("/QLBHang_war_exploded/admin")) {
      Customers customers = (Customers) SessionUtil.getInstance().getValue(request, "USER");
      if (customers != null && customers.getCustomer_id() > 0 ) {
          if (customers.getRoleId() == 1) {
            filterChain.doFilter(servletRequest, servletResponse);
          }
          else if (customers.getRoleId() ==2) {
            response.sendRedirect("login?message=not_permission&alert=alert");
          }
      } else {
        response.sendRedirect("login?message=not_login&alert=alert");
      }
    } else {
      filterChain.doFilter(servletRequest, servletResponse);
    }
  }

  @Override
  public void destroy() {
    Filter.super.destroy();
  }
}
