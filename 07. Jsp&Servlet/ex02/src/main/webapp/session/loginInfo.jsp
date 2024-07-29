<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 2024-07-29
  Time: 오전 10:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h1>로그인 정보 보기</h1>
<%
    String id = (String) session.getAttribute("userid");
    if(id == null){
        response.sendRedirect("loginForm.html");
    } else {
    String pw = (String) session.getAttribute("Password");
    out.print("사용자 아이디 값: " + id + "<br>");
    out.print("사용자 비밀번호 값: " + pw + "<br>");
    out.print("<a href='logout.jsp'>로그아웃</a>");
    }
%>
</body>
</html>
