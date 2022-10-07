<%--
  Created by IntelliJ IDEA.
  User: HOANG_THANG
  Date: 9/14/2022
  Time: 3:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>JSP Page</title>
  <link rel="stylesheet" href="css/styleLogin.css">
  <style>

    *{
      margin: 0;
      box-sizing: border-box;
    }

    body{
      position: relative;
      height: 100vh;
      background-color: #edd785;
    }

    .login{
      width: 300px;
      height: 350px;
      text-align: center;
      position: absolute;
      left: 50%;
      top: 50%;
      transform: translate(-50%, -50%);
      background-color: white;
      padding:10px 10px;
      border: none;
      border-radius: 8px;
    }

    .login p{
      margin-bottom: 10px;
    }

    input{
      margin: 0 auto;
      display: block;
      padding: 14px 16px;
      width: 270px;
      border: 1px solid gainsboro;
      border-radius: 5px;
      margin-bottom: 10px;

    }

    button{
      background-color: yellow;
      color: white;
      padding: 0px 16px;
      width: 270px;
      height: 45px;
      border: none;
      border-radius: 5px;
      margin-top: 10px;
      color: black;
    }

    button:hover, button:focus{
      background-color: orange;
      color: white;
    }

    .line{
      border-bottom: 1px solid black;
      display: flex;
      text-align: center;
      margin: 20px 16px;
    }

    .bottom_form{
      padding-top: 20px;
      text-align: center;

    }

    .bottom_form a{
      width: 100px;
      background-color: greenyellow;
      padding: 12px 16px;
      border: none;
      border-radius: 8px;
    }

    .bottom_form a{
      text-decoration: none;
    }

    .bottom_form a:hover, .bottom_form a:focus{
      background-color: green;
      color: white;
    }

  </style>
</head>
<%
  String error = request.getParameter("error");
  String success= (String)request.getAttribute("success");
  String username=request.getParameter("username");

%>
<body>
<div class="login">
  <p <%if(error!=null ){ %>
          style="color: red"
          <%}else{%>
          style="color: green"
          <%}%>
  >
    <%if(error!=null ){ %>
    <%=error %>
    <%}else if(success!=null){%>
    <%=success %>
    <%}else{%>
    <%=""%>
    <%}%>
  </p>
  <form method="POST" action="login">
    <div class="top_form">
      <input type="hidden" name="s" value="processLogin">

      <input type="text" name="username" placeholder="User Name" value="<%=username!=null?username:"" %>" required>

      <input type="password" name="password" placeholder="Password" required>
    </div >
    <div class="button_login">
      <button>Login</button>
      <div class="line">
      </div>
      <div class="bottom_form">
        <a href="register">
          Create New Account
        </a>
      </div>
    </div>
  </form>
</div>
</body>
</html>
