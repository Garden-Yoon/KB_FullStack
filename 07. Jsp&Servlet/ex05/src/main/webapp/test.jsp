<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 2024-07-31
  Time: 오전 9:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--    <% %> : 스크립트릿, 안에 java문장 사용   --%>
<%
//    int age = 10;     // 지역변수
    Integer age = null;   // 지역변수, null 넣으려면 Integer 형태여야한다
    request.setAttribute("age", null);    // requestScope
%>

<html>
<head>
    <title>Title</title>
</head>
<body>
<%-- 스크립트립 언어, 지역변수를 가져온다.
     변수에 null 넣으면 문자 그대로 'null'이 출력된다  --%>
    변수 age : <%= age%><br>
<%-- EL(Expression Language), page - request - session - application 순으로 변수를 찾는다.
     변수가 null일 경우 아무것도 출력되지 않는다. (공백) --%>
    EL age : ${age}
</body>
</html>