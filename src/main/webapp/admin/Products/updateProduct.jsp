<%@ page import="models.Products" %>
<%@ page import="dals.ProductsDAO" %><%--
  Created by IntelliJ IDEA.
  User: HOANG_THANG
  Date: 9/17/2022
  Time: 8:22 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <% Products products = (Products) request.getAttribute("productupdate");%>
<form method="POST" action="admin-productservlet">
  <input type="hidden" name="service" value="update">
  <input type="hidden" name="product_id" value="<%= products.getProduct_id()%>">
  <table>

    <tr>
      <td>Product name</td>
      <td><input type="text" name="pname" value="<%= products.getProduct_name()%>"></td>
    </tr>
    <tr>
      <td>Image</td>
      <td><input type="text" name="product_image" value="<%= products.getImage()%>"></td>
    </tr>
    <tr>
      <td>Model year</td>
      <td><input type="number" name="model_year" value="<%= products.getModel_year()%>"></td>
    </tr>
    <tr>
      <td>List price</td>
      <td><input type="number" name="list_price" value="<%= products.getList_price()%>"></td>
    </tr>
    <tr>
      <td>Brand name</td>
      <td><input type="text" name="brand_name" value="<%= products.getBrand_name()%>"></td>

    </tr>
    <tr>
      <td>Category Name</td>
      <td><input type="text" name="category_name" value="<%= products.getCategory_name()%>"></td>
    </tr>
    <tr>
      <td><button type="submit"name="submit">Submit</button></td>
      <td><button type="reset" onclick="location.href='admin-productservlet'">Reset</button></td>
    </tr>

  </table>
</form>
</body>
<script>
   function alo(event) {
     console.log(1);
     event.preventDefault();
   }
</script>
</html>
