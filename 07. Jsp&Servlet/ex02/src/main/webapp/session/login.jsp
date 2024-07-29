<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 2024-07-29
  Time: 오전 10:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h1>로그인 정보 세션 저장</h1>
<%
    String id = request.getParameter("userid");
    if (id == null || id.equals("")) {
        // id가 null이거나 입력되지 않은 경우, loginForm.html로 다시 이동하도록 리다이렉트 설정
        response.sendRedirect("loginForm.html");
    } else {
//        id가 입력됐을 경우
        String pw = request.getParameter("Password");
        session.setAttribute("userid", id);
        session.setAttribute("Password", pw);
        out.print("안녕하세요" + id);
        out.print("<a href='loginInfo.jsp'>정보보기</a>");
    }
%>

</body>
</html>
