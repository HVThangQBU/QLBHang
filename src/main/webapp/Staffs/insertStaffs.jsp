<%@ page import="java.util.Vector" %>
<%@ page import="models.Stores" %>
<%@ page import="java.util.List" %>
<%@ page import="models.Staffs" %><%--
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
<form  method="POST" action="staffsServlet">
  <input type="hidden" name="service" value="insert">
  <table>
    <tr>
      <td>First_Name</td>
      <td><input type="text" name="st_first_name" value=""></td>
    </tr>
    <tr>
      <td>Last_name</td>
      <td><input type="text" name="st_last_name" value=""></td>
    </tr>
    <tr>
      <td>Email</td>
      <td><input type="text" name="stemail" value=""></td>
    </tr>
    <tr>
      <td>Phone</td>
      <td><input type="number" name="stphone"></td>
    </tr>
    <tr>
      <td>Active</td>
      <td>
        <input type="radio"  name="active" value="0">
        <input type="radio" name="active" value="1">
      </td>
    </tr>
    <tr>
      <% Vector<Stores> storesVector = (Vector<Stores>) request.getAttribute("store");%>
      <td>Store name (id)</td>
      <td><select name="store_id">
        <option value="" selected disabled hidden>Choose here</option>
        <%for (Stores stores: storesVector){%>
        <option value="<%=stores.getStore_id()%>"><%=stores.getStore_name()%></option>
        <%}%>
      </select>
      </td>
    </tr>
    <tr>
      <% List<Staffs> staffsList = (List<Staffs>) request.getAttribute("staffs");%>
    <td>Manager name</td>
      <td>
        <select name="manager_id">
          < <option value="" selected disabled hidden>Choose here</option>
          <%for (Staffs staffs: staffsList){%>
          <option value="<%=staffs.getStaff_id()%>"><%=staffs.getFirst_name()%></option>
          <%}%>
        </select>
      </td>
    </tr>
    <tr>
      <td>Username</td>
      <td><input type="text" name="stusername" value=""></td>
    </tr>
    <tr>
      <td>Password</td>
      <td><input type="text" name="stpassword" value=""></td>
    </tr>
    <tr>
      <td><button type="submit">Submit</button></td>
      <td><button type="reset">Reset</button></td>
    </tr>
  </table>
</form>
</body>
</html>
