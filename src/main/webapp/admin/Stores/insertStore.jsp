<%--
  Created by IntelliJ IDEA.
  User: HOANG_THANG
  Date: 10/7/2022
  Time: 9:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>InsertStore</title>
</head>
<body>
<form method="POST" action="admin-storeservlet">
  <input type="hidden" name="service" value="insert">
  <table>
    <tr>
      <td>Store name</td>
      <td><input type="text" name="stname" value=""></td>
    </tr>
    <tr>
      <td>Phone</td>
      <td><input type="text" name="stphone" value=""></td>
    </tr>
    <tr>
      <td>Email</td>
      <td><input type="text" name="stemail" value=""></td>
    </tr>
    <tr>
      <td>Street</td>
      <td><input type="text" name="ststreet" value=""></td>
    </tr>
    <tr>
      <td>City</td>
      <td><input type="text" name="stcity" value=""></td>
    </tr>
    <tr>
      <td><button type="submit" name="submit">Submit</button></td>
      <td><button type="reset" onclick="location.href='admin-storeservlet'">Reset</button></td>
    </tr>
  </table>

</form>
</body>
</html>
