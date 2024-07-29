<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 2024-07-29
  Time: 오후 3:39
  To change this template use File | Settings | File Templates.
--%>
<%--예외가 발생했을 경우 error.jsp 호출, errorPage 속성에 명시--%>
<%@ page contentType="text/html;charset=UTF-8" errorPage="error.jsp" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    //0으로 나누어 예외 발생
    int n = 4/0;
%>

</body>
</html>
