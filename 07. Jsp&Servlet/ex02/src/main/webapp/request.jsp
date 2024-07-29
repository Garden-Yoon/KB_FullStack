<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 2024-07-29
  Time: 오전 10:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h1>로그인 입력 화면</h1>
<%--action에 있는 경로는 form을 제출할 때 이동할 경로, 상대경로--%>
<%--현재 loginInfo.jsp는 이 파일과 같은 폴더에 위치한다--%>
<%--form의 메소드는 get, post 두가지이고, get 사용 시 뒤에 쿼리스트링이 붙는다--%>
<form action="loginInfo.jsp" method="get">
    <fieldset>
        <legend>로그인폼</legend>
        <ul>
            <li>
                <label for="userid">아이디</label>
<%--                id는 for와 연결되어있고, name은 쿼리스트링값과 연결되어있다--%>
                <input type="text" name="userid" id="userid">
            </li>
            <li>
                <label for="Password">비밀번호</label>
                <input type="password" name="Password">
            </li>
            <li>
                <label>연령</label>
                <input type="number" name="age">
            </li>
            <li><input type="submit" value="전송"></li>
        </ul>
    </fieldset>
</form>
</body>
</html>
