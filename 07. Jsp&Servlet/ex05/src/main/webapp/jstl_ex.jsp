<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 2024-07-31
  Time: 오전 11:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>JSTL 테스트</h1>

<%--    로그인 / 로그아웃  로직   --%>
<%--    전 페이지에서 보여야하므로 navbar로 빼서 include 시킬 것임--%>
<%--    <hr>--%>
<%--    user값이 null이라면 로그인, 회원가입 화면 보여주기--%>
<%--    <c:if test="${empty user}">--%>
<%--        <a href="/login_form.jsp">로그인</a> | <a href="#">회원가입</a>--%>
<%--    </c:if>--%>

<%--    user값이 null이 아니라면 유저이름, 로그아웃 화면 보여주기--%>
<%--    <c:if test="${!empty user}">--%>
<%--        ${user.name} | <a href="/logout.jsp">로그아웃</a>--%>
<%--    </c:if>--%>

<%--    1. directive로 하는 방법--%>
    <%@include file="navbar.jsp"%>

<%--    2. 표준 action 태그로 하는 방법--%>
<%--    <jsp:include page="navbar.jsp" />--%>

<hr>
<%--    c:if : test에 있는 조건이 True인 경우, 해당 요소가 보여진다--%>
<%--    권한이 관리자인 경우--%>
    <c:if test="${role =='ADMIN'}">관리자</c:if>
    <c:if test="${role !='ADMIN'}">일반회원</c:if>

    <table>
<%--        members 리스트를 하나씩 꺼내와서 member라는 이름으로 사용하겠다--%>
<%--        state라는 이름으로 루프 내부의 정보를 사용 가능--%>
        <c:forEach var="member" items="${members}" varStatus="state">
            <tr>
<%--                index는 라이브러리에 내장되어있는 속성, 내가 만든 변수 아님--%>
                <td>${state.index}</td>
<%--    내가 만든 Member 클래스로 접근하는 변수--%>
                <td>${member.name}</td>
                <td>${member.userid}</td>
            </tr>
        </c:forEach>
    </table>

    <br>
    <hr>
    ${today}<br>
    <fmt:formatDate value="${today}" type="date"/><br>
    <fmt:formatDate value="${today}" type="time"/><br>
    <fmt:formatDate value="${today}" type="both"/><br>
    <fmt:formatDate value="${today}" type="both" dateStyle="short" timeStyle="long"/><br>
    <fmt:formatDate value="${today}" type="both" dateStyle="long" timeStyle="short"/><br>
    <fmt:formatDate value="${today}" pattern="YYYY-MM-dd HH:mm:ss" /><br>
    <fmt:formatDate value="${today}" pattern="YYYY-MM-dd a hh:mm:ss" /><br>

</body>
</html>
