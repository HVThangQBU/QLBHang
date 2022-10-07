<%@ page import="java.util.Vector" %>
<%@ page import="models.Customers" %><%--
  Created by IntelliJ IDEA.
  User: HOANG_THANG
  Date: 9/14/2022
  Time: 8:12 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <%String title = (String) request.getAttribute("title");
      Vector<Customers> customersVector = (Vector<Customers>) request.getAttribute("customer");
  %>
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
          <td><a href="">update</a></td>
          <td><a href="">delete</a></td>
      </tr>


      <% } %>
  </table>
  <p><%= title %></p>
</body>
</html>
