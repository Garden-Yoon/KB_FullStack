<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" import="java.util.*"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<%--    model에서 받아온 exception의 메세지 출력--%>
    <h4><c:out value="${exception.getMessage()}"></c:out></h4>
    <ul>
<%--        exception의 stacktrace를 돌면서 stack이라는 이름으로 가져와서 하나씩 출력한다--%>
        <c:forEach items="${exception.getStackTrace() }" var="stack">
            <li><c:out value="${stack}"></c:out></li>
        </c:forEach>
    </ul>
</body>
</html>
