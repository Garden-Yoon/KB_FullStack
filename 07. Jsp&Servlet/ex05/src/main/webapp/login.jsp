<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 2024-07-31
  Time: 오전 9:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>EL 실습</h1>
<%--    requestScope에서 해당 데이터를 찾아온다--%>
    사용자 아이디: ${userid}<br>
    사용자 비밀번호 : ${passwd} <br>

<%--    Map이나 JavaBean으로 접근할 때는 .으로 안쪽 프로퍼티 사용 가능--%>
    <%-- login 키를 통해 username과 password라는 key의 값을 출력, key 이름 제시 --%>
    <%-- name을 접근할때는 getName() 함수를 이용해서 접근한다 --%>
    ${login.name}, ${login.password}
</body>
</html>
