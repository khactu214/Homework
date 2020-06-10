<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 6/10/2020
  Time: 1:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" isErrorPage="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transittional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Error page</title>
</head>
<body>
    <h1>Error</h1>
    <h2><%=exception.getMessage()%><br/></h2>
</body>
</html>
