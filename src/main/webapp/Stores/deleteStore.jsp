<%@ page import="models.Stores" %><%--
  Created by IntelliJ IDEA.
  User: HOANG_THANG
  Date: 10/8/2022
  Time: 12:32 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>DeleteStore</title>
</head>
<body>
<% Stores stores = (Stores) request.getAttribute("storedelete");%>
<form method="POST" action="storeservlet">
  <input type="hidden" name="service" value="delete">
  <input type="hidden" name="store_id" value="<%= stores.getStore_id()%>">
  <table>
    <tr>
      <td>Store name</td>
      <td><input type="text" name="stname" value="<%=stores.getStore_name()%>"></td>
    </tr>
    <tr>
      <td>Phone</td>
      <td><input type="text" name="stphone" value="<%=stores.getPhone()%>"></td>
    </tr>
    <tr>
      <td>Email</td>
      <td><input type="text" name="stemail" value="<%=stores.getEmail()%>"></td>
    </tr>
    <tr>
      <td>Street</td>
      <td><input type="text" name="ststreet" value="<%=stores.getStreet()%>"></td>
    </tr>
    <tr>
      <td>City</td>
      <td><input type="text" name="stcity" value="<%=stores.getCity()%>"></td>
    </tr>
    <tr>
      <td><button type="submit" name="submit">delete</button></td>
      <td><button type="reset" onclick="location.href='storeservlet'">Reset</button></td>
    </tr>
  </table>

</form>

</body>
</html>
