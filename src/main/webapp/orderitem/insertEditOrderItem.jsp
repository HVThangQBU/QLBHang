<%@ page import="java.util.List" %>
<%@ page import="models.OrderItems" %><%--
  Created by IntelliJ IDEA.
  User: HOANG_THANG
  Date: 10/19/2022
  Time: 4:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
</head>
<body>
<% OrderItems orderItems = (OrderItems) request.getAttribute("orderItems");%>
<form method="POST" action="orderItemServlet">
  <input type="hidden" name="service" value="insertEdit">
  <table>
    <tr>
      <td>Order_id</td>
      <td><input type="hidden" name="order_id" value="<%=orderItems != null ? orderItems.getOrderId() : ""%>"></td>
    </tr>
    <tr>
      <td>item_id</td>
      <td><input type="hidden" name="item_id" value="<%=orderItems != null ? orderItems.getItemId() : ""%>"></td>
    </tr>
    <tr>
      <td>Product id</td>
      <td><input type="text" name="product_id" value="<%=orderItems != null ? orderItems.getProductId() : ""%>"></td>
    </tr>
    <tr>
      <td>Quanlity</td>
      <td><input type="text" name="quanlity" value="<%=orderItems != null ? orderItems.getQuanlity() : ""%>"></td>
    </tr>
    <tr>
      <td>List Price</td>
      <td><input type="text" name="listprice" value="<%=orderItems != null ? orderItems.getListPrice() : ""%>"></td>
    </tr>
    <tr>
      <td>Discount</td>
      <td><input type="text" name="discount" value="<%=orderItems != null ? orderItems.getDiscount() : ""%>"></td>
    </tr>
  </table>
</form>
</body>
</html>
