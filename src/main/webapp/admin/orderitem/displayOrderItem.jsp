<%@ page import="java.util.List" %>
<%@ page import="models.OrderItems" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Vector" %>
<%@ page import="models.Products" %><%--
  Created by IntelliJ IDEA.
  User: HOANG_THANG
  Date: 10/19/2022
  Time: 1:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
</head>
<body>
<% List<OrderItems> orderItemsList = (List<OrderItems>) request.getAttribute("orderItemsList");
  Vector<Products> productsVector = (Vector<Products>) request.getAttribute("productsVector");
%>
<div>
  <div><a href="admin-orderItemServlet?service=insertEdit">Insert</a></div>
  <% if(!orderItemsList.isEmpty()) {%>
  <table border="1">
    <caption></caption>
    <tr>
      <th>orderId</th>
      <th>itemId</th>
      <th>productId</th>
      <th>quanlity</th>
      <th>listPrice</th>
      <th>discount</th>
      <th>Update</th>
      <th>Delete</th>
    </tr>
    <%for (OrderItems orderItems :orderItemsList) {%>
    <tr>
      <td><%=orderItems.getOrderId()%></td>
      <td><%=orderItems.getItemId()%></td>
      <% for (Products products : productsVector) {
        if (orderItems.getProductId() == products.getProduct_id()) {%>
      <td><%=products.getProduct_name()%></td>
      <%}}%>
      <td><%=orderItems.getQuanlity()%></td>
      <td><%=orderItems.getListPrice()%></td>
      <td><%=orderItems.getDiscount()%></td>
      <td><a href="admin-orderItemServlet?service=insertEdit&idOItem=<%=orderItems.getItemId()%>&idOrder=<%=orderItems.getOrderId()%>">Update</a></td>
      <td><a href="admin-orderItemServlet?service=delete&idOItem=<%=orderItems.getItemId()%>&idOrder=<%=orderItems.getOrderId()%>">Delete</a></td>
    </tr>
    <%}%>
  </table>
  <%}%>
</div>
</body>
</html>
