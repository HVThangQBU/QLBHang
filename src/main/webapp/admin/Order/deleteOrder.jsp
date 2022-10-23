<%@ page import="java.util.List" %>
<%@ page import="java.util.Vector" %>
<%@ page import="java.util.Map" %>
<%@ page import="models.*" %><%--
  Created by IntelliJ IDEA.
  User: HOANG_THANG
  Date: 10/19/2022
  Time: 1:44 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
</head>
<body>
<%
  List<Staffs> staffsList = (List<Staffs>) request.getAttribute("staffList");

  Vector<Stores> storesVector = (Vector<Stores>) request.getAttribute("storesVector");

  Vector<Orders> ordersVector = (Vector<Orders>) request.getAttribute("ordersVector");

  Vector<Customers> customersVector = (Vector<Customers>) request.getAttribute("customersVector");

  Orders orders = (Orders) request.getAttribute("order");

  String order_date, required_date, shipped_date, id, customer_id,
    order_status, store_id, staff_id;
  if ( orders != null && orders.getOrder_id() > 0) {
    id = String.valueOf(orders.getOrder_id());
    customer_id = String.valueOf(orders.getCustomer_id());
    order_status = String.valueOf(orders.getOrder_status());
    order_date = orders.getOrder_date();
    required_date = orders.getRequired_date();
    shipped_date = orders.getShipped_date();
    store_id = String.valueOf(orders.getStore_id());
    staff_id = String.valueOf(orders.getStaff_id());
  }else {
    id = "";
    customer_id = "";
    order_status ="";
    order_date = "";
    required_date = "";
    shipped_date = "";
    store_id = "";
    staff_id = "";
  }
%>
<form method="POST" action="admin-orderServlet">
  <input type="hidden" name="service" value="insertUpdate">
  <table>
    <tr>
      <td></td>
      <td><input type="hidden" name="order_id" value="<%=id%>" readonly></td>
    </tr>
    <tr>
      <td>customer_id</td>
      <td>
        <select name="customer_id">
          <% for (Customers customers: customersVector) {%>
          <option value="<%= customers.getCustomer_id() %>"
            <%= customer_id.equalsIgnoreCase(String.valueOf(customers.getCustomer_id())) ? "selected" : "" %>
          >
            <%=customers.getFirst_name() + customers.getLast_name()%>
          </option>
          <%}%>
        </select>
      </td>
    </tr>
    <tr>
      <td>order_status</td>
      <td>
        <select name="order_status">
          <%
            Map<String, String> map = OrderStatusEnum.getOrderStatusMap();
            for ( String oderKey : map.keySet() ) {
          %>
          <option value="<%=oderKey%>"
            <%=order_status.equalsIgnoreCase(oderKey) ? "selected" : ""%>>
            <%=map.get(oderKey)%>
          </option>
          <%
            }%>
        </select>
      </td>
    </tr>
    <tr>
      <td>order_date</td>
      <td><input type="date" name="order_date"
                 value="<%=order_date%>" required pattern="\d{2}-\d{2}-\d{4}"
                 min="2013-01-01" max="2050-12-31"></td>
    </tr>
    <tr>
      <td>required_date</td>
      <td><input type="date" name="required_date"
                 value="<%=required_date%>" required pattern="\d{2}-\d{2}-\d{4}"
                 min="2013-01-01" max="2050-12-31"></td>
    </tr>
    <tr>
      <td>shipped_date</td>
      <td><input type="date" name="shipped_date"
                 value="<%=shipped_date%>" required pattern="\d{2}-\d{2}-\d{4}"
                 min="2013-01-01" max="2050-12-31"></td>
    </tr>
    <tr>
      <td>store_id</td>
      <td>
        <select name="store_id">
          <% for (Stores stores : storesVector) {%>
          <option value="<%=stores.getStore_id()%>"<%=store_id.equalsIgnoreCase(String.valueOf(stores.getStore_id())) ? "selected" : ""%>>
            <%=stores.getStore_name()%>
          </option>
          <%}%>
        </select>
      </td>
    </tr>
    <tr>
      <td>staff_id</td>
      <td>
        <select name="staff_id">
          <% for (Staffs staffs : staffsList) {%>
          <option value="<%=staffs.getStaff_id()%>" <%=staff_id.equalsIgnoreCase(String.valueOf(staffs.getStaff_id())) ? "selected" : ""%>>
            <%=staffs.getFirst_name() + staffs.getLast_name()%>
          </option>
          <%}%>
        </select>
      </td>
    </tr>
    <tr>
      <td><button type="submit" name="submit">reset</button></td>
      <td><button type="submit" name ="delete" value="delete">Delete</button></td>
    </tr>

  </table>
</form>
</body>
</html>
