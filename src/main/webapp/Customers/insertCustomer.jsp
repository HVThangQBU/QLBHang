<%--
  Created by IntelliJ IDEA.
  User: HOANG_THANG
  Date: 10/7/2022
  Time: 10:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
</head>
<body>
<form action="CustomerServlet" method="POST">
  <input name="service" type="hidden" value="insert">
  <table>
    <caption>Register</caption>
    <tr>
      <td>First name</td>
      <td><input type="text" name="fname"></td>
    </tr>
    <tr>
      <td>Last name</td>
      <td><input type="text" name="lname"></td>
    </tr>
    <tr>
      <td>Phone</td>
      <td><input type="text" name="phone"></td>
    </tr>
    <tr>
      <td>Email</td>
      <td><input type="email" name="email"></td>
    </tr>
    <tr>
      <td>Street</td>
      <td><input type="text" name="street"></td>
    </tr>
    <tr>
      <td>City</td>
      <td><input type="text" name="city"></td>
    </tr>
    <tr>
      <td>Username</td>
      <td><input type="text" name="cususename"></td>
    </tr>
    <tr>
      <td>Password</td>
      <td><input type="text" name="cuspass"></td>
    </tr>
    <tr>
      <td><button type="submit" name="submit">Submit</button></td>
      <td><button type="reset" onclick="location.href='CustomerServlet'">Reset</button></td>
    </tr>


  </table>
</form>
</body>
</html>
