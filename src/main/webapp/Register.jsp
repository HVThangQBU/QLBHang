<%--
  Created by IntelliJ IDEA.
  User: HOANG_THANG
  Date: 9/14/2022
  Time: 3:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="dals.CustomersDAO"%>
<%@page import="java.sql.ResultSet"%>
<%@ page import="models.Customers" %>
<%@ page import="static com.sun.org.apache.xalan.internal.xsltc.compiler.sym.error" %>
<!DOCTYPE html>
<html>
<head>
    <title>Register</title>
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

<!-- <a href="ControllerCustomer">List All</a> -->
<form action="register" method="POST">
    <input name="s" type="hidden" value="insert">
    <table>
        <caption>Register</caption>
        <tr>
            <td>First name</td>
            <td><input type="text" name="fname" value="" required></td>
        </tr>
        <tr>
            <td>Last name</td>
            <td><input type="text" name="lname" value="" required></td>
        </tr>
        <tr>
            <td>Phone</td>
            <td><input type="text" name="phone" value="" required></td>
        </tr>
        <tr>
            <td>Email</td>
            <td><input type="email" name="email" value="" required></td>
        </tr>
        <tr>
            <td>Street</td>
            <td><input type="text" name="street" value="" required></td>
        </tr>
        <tr>
            <td>City</td>
            <td><input type="text" name="city" value="" required></td>
        </tr>
        <tr>
            <td>Username</td>
            <td><input type="text" name="username" value="" required>
                <span style="color: red"></span>
            </td>
        </tr>
        <tr>
            <td>Password</td>
            <td><input type="password" name="password" value="" required>
                <span></span>
            </td>
        </tr>
    </table>
    <div class="sm">
        <button type="submit" name="submit">Submit</button>
    </div>
</form>
</body>
</html>

