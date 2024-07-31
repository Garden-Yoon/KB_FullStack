<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 2024-07-29
  Time: 오전 11:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h1>getParameter 실습</h1>
<%--login만 명시한 것은 서블릿과 연결해주겠다는 의미--%>
<jsp:include page="navbar.jsp" />
<form action="login" method="get">
    <fieldset>
        <legend>로그인 폼</legend>
        <ul>
            <li>
                <label for="userid">아이디</label>
                <input type="text" id="userid" name="userid">
            </li>
            <li>
                <label for="passwd">비밀번호</label>
                <input type="password" id="passwd" name="passwd">
            </li>
            <li><input type="submit" value="전송"></li>
        </ul>
    </fieldset>
</form>

</body>
</html>
