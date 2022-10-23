<%@ page import="models.Products" %>
<%@ page import="java.util.Vector" %><%--
  Created by IntelliJ IDEA.
  User: HOANG_THANG
  Date: 9/14/2022
  Time: 9:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%String titlepage=(String)request.getAttribute("titlepage"); %>
    <link rel="stylesheet" href="../../css/styleheader.css">
    <style>
        *{
            box-sizing: border-box;
            margin: 0;
        }

        .top{
            background-color: #edd785;
            height: 20vh;
            /*                position: fixed;
                            top: 0;
                            left: 0;
                            right: 0;*/
        }

        .header{
            text-align: center;
            height: 8vh;
            background-color: transparent;
        }

        .header h1{
            padding-top: 15px;
        }

        .header p{
            padding-top: 15px;
            color: red;
            font-weight: bold;
            font-size: 18px;
        }

        .nav{
            text-align: center;
            height: 10vh;
            background-color: transparent;
        }

        .nav a , .nav form{
            display: inline-block;
            text-decoration: none;
            margin-left: 50px;
            border: 1px solid burlywood;
            border-radius: 5px;
            width: 150px;
            height: 40px;
            padding: 10px 0px;
            background-color: white;
        }

        .nav a:hover, a:focus, a.active:link, a.active:visited{
            color: black;
            background: bisque;
        }

        .nav form{
            display: inline-block;
            width: 170px;

        }

        .nav form input{
            height: 20px;
            border: none;
            width: 10vw;
            background-color: white;
        }


        .left{
            float:  left;
            background-color: #eeefe9;
            width: 20%;
            text-align: center;
            height: 85vh;

        }

        .left a{
            margin: 0 auto;
            display: block;
            text-decoration: none;
            width: 150px;
            height: 40px;
            padding: 10px 0px;
        }

        .left a:first-child{
            margin-top: 2em;
        }

        .left a:hover, a:focus, a.active:link, a.active:visited{
            color: black;
            background: bisque;
            border-radius: 5px;
        }

        .right{
            float:  right;
            height: 85vh;
            /*background-color: blue;*/
            width: 80%;

        }

    </style>
    <title><%=titlepage %></title>
</head>
<body>
<%--&lt;%&ndash;&lt;%&ndash;%>--%>
<%--    String username=(String)session.getAttribute("username");--%>
<%--    Staffs staff=(Staffs)session.getAttribute(username);--%>
<%--    String fullname=staff.getFirst_name()+" "+staff.getLast_name();--%>
<%--    String rollnumber=String.valueOf(staff.getStaff_id());--%>

<%--&lt;%&ndash;%>&ndash;%&gt;--%>
<div class="top">
    <div class="header">
        <p style="color: orange"><span></span>--|-- <span> Welcome: </span></p>
    </div>
    <div class="nav">
        <a href="ControllerLogout">Logout</a>
    </div>
</div>
<div class="mid">
<%--    <div class="left">--%>
<%--        <a href="ControllerLogin?s=home">Home</a>--%>
<%--        <a href="ControllerCustomer">Customer Manager</a>--%>
<%--        <a href="ControllerProducts">Product Manager</a>--%>
<%--        <a href="ControllerOrders">Order Manager</a>--%>

<%--    </div>--%>
    <div class="right">
        <a href="admin-productservlet?service=insert">Insert Product</a>

        <%
            Vector<Products> vector =(Vector<Products>)request.getAttribute("product");
            String titletable=(String)request.getAttribute("titletable");
            String pname=(String)request.getAttribute("pname");
            String from=(String)request.getAttribute("from");
            String to=(String)request.getAttribute("to");
        %>
        <form action="admin-productservlet">
            <p>Search By Name: <input type="text" name="pname" value="<%=pname%>" />
                <input type="submit" name="search" value="search by name" />
            </p>
        </form>
<%--        <form action="productservlet">--%>
<%--            <p>Search by Price:--%>
<%--                from <input type="text" name="from" value="<%=from%>" />--%>
<%--                to <input type="text" name="to" value="<%=to%>" />--%>
<%--                <input type="submit" name="search" value="search by price" />--%>
<%--            </p>--%>
<%--        </form>--%>
        <%if(!vector.isEmpty()){%>
        <table border="1">
            <caption><%=titletable%></caption>
            <tr>
                <th>product_id</th>
                <th>product_name</th>
                <th>image</th>
                <th>model_year</th>
                <th>list_price</th>
                <th>brand_name</th>
                <th>category_name</th>
                <th>update</th>
                <th>delete</th>
            </tr>
            <%
                for (Products p : vector) {%>
            <tr>
                <td><%= p.getProduct_id() %></td>
                <td><%= p.getProduct_name() %></td>
                <td><%= p.getImage()%></td>
                <td><%= p.getModel_year() %></td>
                <td><%= p.getList_price() %></td>
                <td><%= p.getBrand_name() %></td>
                <td><%= p.getCategory_name() %></td>
                <td>  <a href="admin-productservlet?service=update&id=<%=p.getProduct_id() %>">Update</a></td>
                <td><a href="admin-productservlet?service=delete&id=<%=p.getProduct_id() %>">delete</a></td>
            </tr>
            <%            }
            %>
        </table>
        <%}else{%>
        <h3 style="color: red">Not found</h3>
        <%}%>
    </div>
</div>
</body>
</html>
