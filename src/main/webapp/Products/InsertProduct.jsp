<%--
  Created by IntelliJ IDEA.
  User: HOANG_THANG
  Date: 9/14/2022
  Time: 8:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>
<body>

<form method="POST" action="productservlet">
    <input type="hidden" name="service" value="insert">
    <table>
        <tr>
            <td>Product id</td>
            <td><input type="number" name="product_id" value="" readonly></td>
        </tr>
        <tr>
            <td>Product name</td>
            <td><input type="text" name="pname" value=""></td>
        </tr>
        <tr>
            <td>Image</td>
            <td><input type="text" name="product_image" value=""></td>
        </tr>
        <tr>
            <td>Model year</td>
            <td><input type="number" name="model_year" value=""></td>
        </tr>
        <tr>
            <td>List price</td>
            <td><input type="number" name="list_price" value=""></td>
        </tr>
        <tr>
            <td>Brand name</td>
            <td><input type="text" name="brand_name" value=""></td>
        </tr>
        <tr>
            <td>Category Name</td>
            <td><input type="text" name="category_name" value=""></td>
        </tr>
        <tr>
            <td><button type="submit" name="submit">Submit</button></td>
            <td><button type="reset" onclick="location.href='productservlet'">Reset</button></td>
        </tr>

    </table>
</form>
</body>
</html>
