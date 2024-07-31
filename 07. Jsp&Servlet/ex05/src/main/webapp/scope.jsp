<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 2024-07-31
  Time: 오전 10:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>scope 데이터 보기 </h1>

<%--    각 scope들을 돌면서 scope에 저장해둔 값을 가져온다--%>
    pageScope의 속성 값은 : ${pageScope.scopeName}<br>
    requestScope의 속성 값은 : ${requestScope.scopeName}<br>
    sessionScope의 속성 값은 : ${sessionScope.scopeName}<br>
    applicationScope의 속성 값은 : ${applicationScope.scopeName}<br>

<%--    모든 scope에 scopeName이 있지만, 가장 작은 범위부터 찾기 때문에 requestScope 값이 들어간다    --%>
    scopeName 자동 찾기 : ${scopeName}<br>
    member: ${member.name}(${member.userid})<br>

</body>
</html>
