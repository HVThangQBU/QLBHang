<%@ page import="java.util.Vector" %>
<%@ page import="com.mysql.cj.x.protobuf.MysqlxCrud" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="models.*" %><%--
  Created by IntelliJ IDEA.
  User: HOANG_THANG
  Date: 10/16/2022
  Time: 12:48 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
</head>
<body>
<div><a href="admin-orderServlet?service=insertUpdate" name="cu">Insert</a></div>
<% List<Staffs> staffsList = (List<Staffs>) request.getAttribute("staffList");

  Vector<Stores> storesVector = (Vector<Stores>) request.getAttribute("storesVector");

  Vector<Customers> customersVector = (Vector<Customers>) request.getAttribute("customersVector");

//  Orders orders = (Orders) request.getAttribute("order");
  Vector<Orders> ordersVector = (Vector<Orders>) request.getAttribute("order");

  String titleable = (String) request.getAttribute("titletable");
  String st_first_name = (String) request.getAttribute("name");%>
<form action="admin-orderServlet">
  <p> Search By Name <input type="text" name="name" placeholder="Search" value="<%=st_first_name%>">
    <input type="submit" name="search" value="search by name"></p>
</form>
<%if (!ordersVector.isEmpty()){%>
<table border="1">
  <caption><%=titleable%></caption>
  <tr>
    <th>order_id</th>
    <th>customer_id</th>
    <th>order_status</th>
    <th>order_date</th>
    <th>required_date</th>
    <th>shipped_date</th>
    <th>store_id</th>
    <th>staff_id</th>
    <th>update</th>
    <th>delete</th>
  </tr>

  <%for (Orders order: ordersVector){%>
  <tr>
    <td><%=order.getOrder_id()%></td>

    <% for (Customers customers: customersVector) {
    if (order.getCustomer_id() == customers.getCustomer_id()) { %>

    <td><%=customers.getFirst_name() + " " + customers.getLast_name()%></td>

    <% break;}}%>

    <%Map<String, String> map = OrderStatusEnum.getOrderStatusMap();
      for ( String oderKey : map.keySet() ) {
        if (order.getOrder_status() == Integer.parseInt(oderKey)) {
    %>
    <td><%=map.get(oderKey)%></td>
    <%}}%>
    <td><%=order.getOrder_date()%></td>
    <td><%=order.getRequired_date()%></td>
    <td><%=order.getShipped_date()%></td>

    <% for (Stores stores: storesVector) {
          if (order.getStore_id() == stores.getStore_id()) {
    %>
    <td><%=stores.getStore_name()%></td>
    <%}}%>
    <% for (Staffs staffs : staffsList) {
        if (order.getStaff_id() == staffs.getStaff_id()) {
    %>
    <td><%=staffs.getFirst_name() +" " + staffs.getLast_name()%></td>
    <%}}%>
    <td><a href="admin-orderServlet?service=insertUpdate&id=<%=order.getOrder_id()%>">Update</a></td>
    <td><a href="admin-orderServlet?service=delete&id=<%=order.getOrder_id()%>">Delete</a></td>
  </tr>
  <%}%>
</table>
<%}else{%>
<h3 style="color: red">Not found</h3>
<%}%>
</body>
</html>
