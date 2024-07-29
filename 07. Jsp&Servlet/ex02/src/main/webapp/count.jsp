<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 2024-07-29
  Time: 오후 2:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h1>방문자수 설정하기 화면</h1>
<%! int count; %>
<%--ServletContext 객체인 application을 이용해서 countValue라는 속성에 count값을 설정--%>
<%
    count++;
    application.setAttribute("countValue", count);
%>
현재 방문자 수 : <%= count %>
</body>
</html>
