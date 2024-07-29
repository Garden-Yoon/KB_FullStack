<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 2024-07-29
  Time: 오후 2:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--jsp에서 데이터 출력하는 방법 1) out.print()  2) <%=  %> --%>
<%
    String name="홍길동";
    out.print("이것은 out 내장 객체로 출력: "+name+"<br>");
%>
이것은 expression tag로 출력: <%= name %>

</body>
</html>
