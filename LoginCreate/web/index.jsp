<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 6/5/2020
  Time: 2:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Login</title>
  </head>
  <body>
  <h2>Login Form</h2>
  <form action= "LoginController" method="post">
    UserName: <input type="text" name="username"><br/>
    PassWord: <input type="password" name="password"><br/>
    <input type="submit" value="Login">
  </form>
  </body>
</html>
