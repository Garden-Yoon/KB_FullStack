<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 2024-07-29
  Time: 오후 4:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>include 액션 태그 실습</h1>
현재 시간을 구하는 예제, 다음 줄에 삽입 <br>
<%--header.jsp를 가져와서 해당 부분에 동적으로 삽입해준다--%>
<%--flush="true" : 현재 페이지의 버퍼를 비워준다--%>
<jsp:include page="header.jsp" flush="true" />
</body>
</html>
