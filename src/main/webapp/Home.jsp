<%@ page import="utils.SessionUtil" %>
<%@ page import="models.Customers" %>
<%@ page import="models.Products" %>
<%@ page import="java.util.Vector" %><%--
  Created by IntelliJ IDEA.
  User: HOANG_THANG
  Date: 9/14/2022
  Time: 2:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
 <%@ include file="layout/header.jsp"%>
<div>
<%--  <a href="">Products</a>--%>
<%--  <%--%>
<%--    Vector<Products> vector =(Vector<Products>)request.getAttribute("product");--%>
<%--    String titletable=(String)request.getAttribute("titletable");--%>
<%--    String pname=(String)request.getAttribute("pname");--%>
<%--    String from=(String)request.getAttribute("from");--%>
<%--    String to=(String)request.getAttribute("to");--%>
<%--  %>--%>
<%--  <form action="productservlet">--%>
<%--    <p>Search By Name: <input type="text" name="pname" value="<%=pname%>" />--%>
<%--      <input type="submit" name="search" value="search by name" />--%>
<%--    </p>--%>
<%--  </form>--%>
<%--  <%if(!vector.isEmpty()){%>--%>
<%--  <table border="1">--%>
<%--    <caption><%=titletable%></caption>--%>
<%--    <tr>--%>
<%--      <th>product_id</th>--%>
<%--      <th>product_name</th>--%>
<%--      <th>image</th>--%>
<%--      <th>model_year</th>--%>
<%--      <th>list_price</th>--%>
<%--      <th>brand_name</th>--%>
<%--      <th>category_name</th>--%>
<%--      <th>update</th>--%>
<%--      <th>delete</th>--%>
<%--    </tr>--%>
<%--    <%--%>
<%--      for (Products p : vector) {%>--%>
<%--    <tr>--%>
<%--      <td><%= p.getProduct_id() %></td>--%>
<%--      <td><%= p.getProduct_name() %></td>--%>
<%--      <td><%= p.getImage()%></td>--%>
<%--      <td><%= p.getModel_year() %></td>--%>
<%--      <td><%= p.getList_price() %></td>--%>
<%--      <td><%= p.getBrand_name() %></td>--%>
<%--      <td><%= p.getCategory_name() %></td>--%>
<%--      <td>  <a href="productservlet?service=update&id=<%=p.getProduct_id() %>">Update</a></td>--%>
<%--      <td><a href="productservlet?service=delete&id=<%=p.getProduct_id() %>">delete</a></td>--%>
<%--    </tr>--%>
<%--    <%            }--%>
<%--    %>--%>
<%--  </table>--%>
<%--  <%}else{%>--%>
<%--  <h3 style="color: red">Not found</h3>--%>
<%--  <%}%>--%>
  <%@ include file="admin/Products/displayProduct.jsp"%>
</div>
</body>
</html>
