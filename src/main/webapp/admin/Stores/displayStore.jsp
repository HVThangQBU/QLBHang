<%@ page import="com.google.protobuf.ByteString" %>
<%@ page import="models.Stores" %>
<%@ page import="java.util.Vector" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <%String titlepage=(String)request.getAttribute("titlepage"); %>
  <title><%=titlepage %></title>
</head>
<body>
<%Vector<Stores> storesVector = (Vector<Stores>) request.getAttribute("store");
  String stname = (String) request.getAttribute("stname");
%>
<form action="admin-storeservlet">
  <p>Search By Name: <input type="text" name="stname" value="<%=stname%>" />
    <input type="submit" name="search" value="search by name" />
  </p>
</form>
<div>
  <a href="admin-storeservlet?service=insert">Insert Product</a>
</div>

  <div>
    <%if(!storesVector.isEmpty()){%>
    <table border="1">
      <tr>
        <th>store_id</th>
        <th>store_name</th>
        <th>phone</th>
        <th>email</th>
        <th>street</th>
        <th>city</th>
        <th>update</th>
        <th>delete</th>
      </tr>
      <%for (Stores st: storesVector){%>
        <tr>
          <td><%=st.getStore_id()%></td>
          <td><%=st.getStore_name()%></td>
          <td><%=st.getPhone()%></td>
          <td><%=st.getEmail()%></td>
          <td><%=st.getStreet()%></td>
          <td><%=st.getCity()%></td>
          <td><a href="admin-storeservlet?service=update&id=<%=st.getStore_id()%>">update</a></td>
          <td><a href="admin-storeservlet?service=delete&id=<%=st.getStore_id()%>">delete</a></td>
        </tr>
      <%}%>
    </table>
  <%}else{%>
  <h3 style="color: red">Not found</h3>
  <%}%>
  </div>
</body>
</html>
