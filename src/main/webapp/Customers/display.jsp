<%--
  Created by IntelliJ IDEA.
  User: HOANG_THANG
  Date: 9/14/2022
  Time: 7:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.Vector" %>
<%@ page import="models.Customers" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
</head>
<body>
<%
  Vector<Customers> customersVector = (Vector<Customers>) request.getAttribute("customer");
  String cname=(String)request.getAttribute("cname");
%>
<div><a href="CustomerServlet?service=insert">Insert Customer</a></div>
<form action="CustomerServlet">
  <p>Search By Name: <input type="text" name="cname" value="<%=cname%>" />
    <input type="submit" name="search" value="search by name" />
  </p>
</form>
<%if(!customersVector.isEmpty()){%>
<table border="1">
  <tr>
    <th>customer_id</th>
    <th>first_name</th>
    <th>last_name</th>
    <th>phone</th>
    <th>email</th>
    <th>street</th>
    <th>city</th>
    <th>update</th>
    <th>delete</th>
  </tr>
  <% for(Customers cus: customersVector){ %>

  <tr>
    <td><%=cus.getCustomer_id()%></td>
    <td><%= cus.getFirst_name()%></td>
    <td><%= cus.getLast_name()%></td>
    <td><%= cus.getPhone()%></td>
    <td><%= cus.getEmail()%></td>
    <td><%= cus.getStreet()%></td>
    <td><%= cus.getCity()%></td>
    <td><a href="CustomerServlet?service=update&id=<%=cus.getCustomer_id() %>">update</a></td>
    <td><a href="CustomerServlet?service=delete&id=<%=cus.getCustomer_id() %>">delete</a></td>
  </tr>


  <% } %>
</table>
<%}else{%>
<h3 style="color: red">Not found</h3>
<%}%>
</body>
</html>

