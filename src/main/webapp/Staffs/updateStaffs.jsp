<%@ page import="java.util.Vector" %>
<%@ page import="models.Stores" %>
<%@ page import="java.util.List" %>
<%@ page import="models.Staffs" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: HOANG_THANG
  Date: 10/13/2022
  Time: 9:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
</head>
<body>
  <%
    Staffs staffs = (Staffs) request.getAttribute("staffs");
    List<Stores> listStore = ( List<Stores>) request.getAttribute("listStore");
    List<Staffs> listStaff = ( List<Staffs>) request.getAttribute("listStaff");
  %>

<form  method="POST" action="staffsServlet">
  <input type="hidden" name="service" value="update">
  <input type="hidden" name="staff_id" value="<%=staffs.getStaff_id()%>">

  <table>

    <tr>
      <td>First_Name</td>
      <td><input type="text" name="st_first_name" value="<%=staffs.getFirst_name()%>"></td>
    </tr>
    <tr>
      <td>Last_name</td>
      <td><input type="text" name="st_last_name" value="<%=staffs.getLast_name()%>"></td>
    </tr>
    <tr>
      <td>Email</td>
      <td><input type="text" name="stemail" value="<%=staffs.getEmail()%>"></td>
    </tr>
    <tr>
      <td>Phone</td>
      <td><input type="number" name="stphone" value="<%=staffs.getPhone()%>"></td>
    </tr>
    <tr>
      <td>Active</td>
      <td>
        <lable>No active</lable>
        <input type="radio"  name="active" value="0" <%= staffs.getActive() == 0 ? "checked" : "" %>>
        <lable>Active</lable>
        <input type="radio" name="active" value="1" <%= staffs.getActive() == 0 ? "" : "checked" %>>
      </td>
    </tr>
    <tr>
      <td>Store_id</td>
      <td>
        <select name="store_id">
          <% for(Stores store: listStore){ %>
          <option
            value="<%= store.getStore_id() %>"
            <%= staffs.getStore_id() == store.getStore_id() ? "selected" : "" %>
          >
            <%= store.getStore_name() %>
          </option>
          <% } %>
        </select>
      </td>
    </tr>
    <tr>
      <td>Manager name</td>
      <td>
        <select name="manager_id">
          <%for (Staffs staffs1: listStaff){%>
            <option
              value="<%= staffs1.getStaff_id()%>"
              <%= staffs.getManager_id() == staffs1.getStaff_id() ? "selected" : "" %>
            >
              <%=staffs1.getFirst_name()%>
            </option>
          <%}%>
        </select>
      </td>
    </tr>
    <tr>
      <td>Username</td>
      <td><input type="text" name="stusername" value="<%=staffs.getUsername()%>"></td>
    </tr>
    <tr>
      <td>Password</td>
      <td><input type="password" name="stpassword" value="<%=staffs.getPassword()%>"></td>
    </tr>
    <tr>
      <td><button type="submit">Submit</button></td>
      <td><button type="reset">Reset</button></td>
    </tr>
  </table>
</form>
</body>
</html>
