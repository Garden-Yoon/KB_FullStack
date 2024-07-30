<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 2024-07-30
  Time: 오후 4:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    username 값 : <%= request.getAttribute("username") %><br>
    useraddress 값 : <%= request.getAttribute("useraddress")%><br>
</body>
</html>
