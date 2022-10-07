<%@ page import="models.Products" %><%--
  Created by IntelliJ IDEA.
  User: HOANG_THANG
  Date: 9/18/2022
  Time: 6:49 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<% Products pro = (Products) request.getAttribute("productdelete");%>
<form method="POST" action="productservlet">
    <input type="hidden" name="service" value="delete">
    <input type="hidden" name="product_id" value="<%= pro.getProduct_id()%>">
    <table>

        <tr>
            <td>Product name</td>
            <td><input type="text" name="pname" value="<%= pro.getProduct_name()%>"></td>
        </tr>
        <tr>
            <td>Image</td>
            <td><input type="text" name="product_image" value="<%= pro.getImage()%>"></td>
        </tr>
        <tr>
            <td>Model year</td>
            <td><input type="number" name="model_year" value="<%= pro.getModel_year()%>"></td>
        </tr>
        <tr>
            <td>List price</td>
            <td><input type="number" name="list_price" value="<%= pro.getList_price()%>"></td>
        </tr>
        <tr>
            <td>Brand name</td>
            <td><input type="text" name="brand_name" value="<%= pro.getBrand_name()%>"></td>

        </tr>
        <tr>
            <td>Category Name</td>
            <td><input type="text" name="category_name" value="<%= pro.getCategory_name()%>"></td>
        </tr>
        <tr>
            <td><button type="submit"   name="submit">delete</button></td>

            <td>
            <td><button type="reset" onclick="location.href='productservlet'">Reset</button></td>
            </td>
        </tr>

    </table>
</form>
</body>
</html>
