<%@ page import="java.util.List" %>
<%@ page import="models.Staffs" %><%--
  Created by IntelliJ IDEA.
  User: HOANG_THANG
  Date: 10/13/2022
  Time: 8:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
</head>
<body>
<div><a href="staffsServlet?service=insert">Insert</a></div>
<% List<Staffs> staffsList = (List<Staffs>) request.getAttribute("staffs");
String titleable = (String) request.getAttribute("titletable");
String st_first_name = (String) request.getAttribute("name");%>
<form action="staffsServlet">
  <p> Search By Name <input type="search" name="st_first_name" placeholder="Search" value="<%=st_first_name%>">
    <input type="submit" name="search" value="search by name"></p>
</form>
<%if (!staffsList.isEmpty()){%>
<table border="1">
  <caption><%=titleable%></caption>
  <tr>
    <th>staff_id</th>
    <th>first_name</th>
    <th>last_name</th>
    <th>email</th>
    <th>phone</th>
    <th>active</th>
    <th>store_id</th>
    <th>manager_id</th>
    <th>username</th>
    <th>password</th>
    <th>Update</th>
    <th>Delete</th>
  </tr>
  <%for (Staffs staffs: staffsList){%>
  <tr>
    <td><%=staffs.getStaff_id()%></td>
    <td><%=staffs.getFirst_name()%></td>
    <td><%=staffs.getLast_name()%></td>
    <td><%=staffs.getEmail()%></td>
    <td><%=staffs.getPhone()%></td>
    <td><%=staffs.getActive()%></td>
    <td><%=staffs.getStore_id()%></td>
    <td><%=staffs.getManager_id()%></td>
    <td><%=staffs.getUsername()%></td>
    <td><%=staffs.getPassword()%></td>
    <td><a href="staffsServlet?service=update&id=<%=staffs.getStaff_id()%>">Update</a></td>
    <td><a href="staffsServlet?service=delete&id=<%=staffs.getStaff_id()%>">Delete</a></td>
  </tr>
  <%}%>
</table>
<%}else{%>
<h3 style="color: red">Not found</h3>
<%}%>
</body>
</html>
