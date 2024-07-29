<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 2024-07-29
  Time: 오후 3:40
  To change this template use File | Settings | File Templates.
--%>
<%--isErrorPage 속성으로 해당 페이지가 예외처리 페이지임을 명시--%>
<%@ page contentType="text/html;charset=UTF-8" isErrorPage="true" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>divide.jsp 발생된 예외를 처리하는 페이지</h1>
<%--발생한 예외를 받아와서 메세지 출력--%>
<%--발생된 예외는 :/ by zero--%>
<%
    out.print("발생된 예외는 :" + exception.getMessage());
%>
</body>
</html>
