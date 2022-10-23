<%@ page import="java.util.List" %>
<%@ page import="models.OrderItems" %>
<%@ page import="java.util.Vector" %>
<%@ page import="models.Products" %>
<%@ page import="models.Orders" %><%--
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
<% OrderItems orderItems = (OrderItems) request.getAttribute("orderItems");
  Vector<Products> productsVector = (Vector<Products>) request.getAttribute("productsVector");
  Vector<Orders> ordersVector = (Vector<Orders>) request.getAttribute("ordersVector");%>
<form method="POST" action="admin-orderItemServlet">
  <input type="hidden" name="service" value="insertEdit">
  <table>
    <tr>
      <td>Order_id</td>
<%--      <td>--%>
<%--      <select name="order_id">--%>
<%--        <% for (Orders orders : ordersVector) {%>--%>
<%--        <option value="<%=orders.getOrder_id()%>"<%=orderItems != null && orders.getOrder_id() == orderItems.getOrderId() ? "selected" : ""%>--%>
<%--        ><%=orders.getOrder_id()%></option>--%>
<%--        <%}%>--%>
<%--      </select>--%>
<%--      </td>--%>


      <td><input type="text" name="order_id" value="<%=orderItems != null ? orderItems.getOrderId() : ""%>"></td>
    </tr>
    <tr>
      <td>item_id</td>
      <td><input type="text" name="item_id" value="<%=orderItems != null ? orderItems.getItemId() : ""%>"></td>
    </tr>
    <tr>
      <td>Product id</td>
      <td>
        <select name="product_id">
            <%
              for (Products products : productsVector) {
              %>
          <option value="<%=products.getProduct_id() %>"
            <%=(orderItems != null && orderItems.getProductId() == products.getProduct_id())?"selected" : ""%>
          >
            <%=products.getProduct_name()%>
          </option>
          <%}%>
        </select>
      </td>

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
    <tr>
      <td><button type="submit" name="submit">Submit</button></td>
      <td><button type="reset" onclick="location.href='admin-orderItemServlet'">Reset</button></td>
      <td><button type="submit" name ="delete" value="delete">Delete</button></td>
    </tr>
  </table>
</form>
</body>
</html>
