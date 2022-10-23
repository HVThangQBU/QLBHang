<%@ page import="models.Customers" %><%--
  Created by IntelliJ IDEA.
  User: HOANG_THANG
  Date: 9/18/2022
  Time: 9:47 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Update</title>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="css/styleRegister.css">
  <style>*{
    margin: 0;
    box-sizing: border-box;
  }

  body{
    height: 100vh;
    position: relative;
    background-color: #edd785;
  }

  form{
    position: absolute;
    top: 20%;
    left: 20%;
    border: 1px solid #edd785;
    border-radius: 8px;
    background-color: white;
    padding: 40px 10px;
    width: 35%;
  }

  form table caption{
    margin-bottom: 20px;
    font-size: 25px;
    font-weight: bold;
  }

  form table tr td:first-child{
    padding-right: 10px;
  }
  .sm{
    margin: 0 auto;
    margin-top: 15px;
  }

  button{
    margin-left: 50px;
    padding: 5px 50px;
  } </style>
</head>
<body>
<% Customers customers = (Customers) request.getAttribute("customerdelete");%>
<!-- <a href="ControllerCustomer">List All</a> -->
<form action="admin-customerServlet" method="POST">
  <input name="service" type="hidden" value="delete">
  <input type="hidden" name="customer_id" value="<%=customers.getCustomer_id()%>">
  <table>
    <caption>Register</caption>
    <tr>
      <td>First name</td>
      <td><input type="text" name="fname" value="<%=customers.getFirst_name()%>" required></td>
    </tr>
    <tr>
      <td>Last name</td>
      <td><input type="text" name="lname" value="<%=customers.getLast_name()%>" required></td>
    </tr>
    <tr>
      <td>Phone</td>
      <td><input type="text" name="phone" value="<%=customers.getPhone()%>" required></td>
    </tr>
    <tr>
      <td>Email</td>
      <td><input type="email" name="email" value="<%=customers.getEmail()%>" required></td>
    </tr>
    <tr>
      <td>Street</td>
      <td><input type="text" name="street" value="<%=customers.getStreet()%>" required></td>
    </tr>
    <tr>
      <td>City</td>
      <td><input type="text" name="city" value="<%=customers.getCity()%>" required></td>
    </tr>

    <input type="hidden" name="username" value="" required>
    <input type="hidden" name="password" value="" required>


  </table>
  <div class="sm">
    <button type="submit" name="submit">Submit</button>
  </div>
</form>
</body>
</html>
