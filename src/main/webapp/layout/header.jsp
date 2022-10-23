<%@ page import="utils.SessionUtil" %>
<%@ page import="models.Customers" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div>
  <% if (SessionUtil.getInstance().getValue(request, "USER") == null ) {%>
  <a href="login">Login</a>
  <a href="register">Register</a>
  <%} else {
    Customers customers = (Customers) SessionUtil.getInstance().getValue(request, "USER");%>
  <a href="Xin chào">Xin chào <%=customers.getFirst_name() + customers.getLast_name()%></a>
  <a href=""> Đăng xuất</a>
  <%}%>
</div>
