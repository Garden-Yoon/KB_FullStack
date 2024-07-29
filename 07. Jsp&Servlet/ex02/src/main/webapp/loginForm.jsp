<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 2024-07-29
  Time: 오전 10:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h1>session 내장 객체 실습</h1>
<form action="login.jsp" method="post">
    <fieldset>
        <legend>로그인폼</legend>
        <ul>
            <li>
                <label for="userid">아이디</label>
                <input type="text" name="userid">
            </li>
            <li>
                <label for="Password">비밀번호</label>
                <input type="password" name="Password">
            </li>
            <li><input type="submit" value="전송"></li>
        </ul>
    </fieldset>
</form>

</body>
</html>
