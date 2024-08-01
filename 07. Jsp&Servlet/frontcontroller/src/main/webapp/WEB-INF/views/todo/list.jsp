<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--forEach쓰려면 jstl 필요--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
  <title>Title</title>
</head>
<body>
<h1>Todo 목록 보기</h1>
<div>
<%--  EL을 사용해서 todoList 접근--%>
<%--  ${todoList}--%>
<%--  forEach문으로 todoList 접근--%>
  <c:forEach var="todo" items="${todoList}" varStatus="state">
      ${todo}<br>
  </c:forEach>



<%--  상대경로기때문에 todo 폴더를 접근할 필요 없음--%>
  <a href="view">상세보기</a>
</div>
<div>
  <a href="create">새 Todo</a>
</div>

</body>
</html>




<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<!DOCTYPE html>--%>
<%--<html>--%>
<%--<head>--%>
<%--  <title>Todo 목록</title>--%>
<%--  <style>--%>
<%--    body {--%>
<%--      font-family: 'Arial', sans-serif;--%>
<%--      background-color: #f7f9fc;--%>
<%--      color: #444;--%>
<%--      margin: 0;--%>
<%--      padding: 0;--%>
<%--      display: flex;--%>
<%--      justify-content: center;--%>
<%--      align-items: center;--%>
<%--      height: 100vh;--%>
<%--      text-align: center;--%>
<%--    }--%>
<%--    .container {--%>
<%--      width: 100%;--%>
<%--      max-width: 700px;--%>
<%--      padding: 20px;--%>
<%--      background-color: #ffffff;--%>
<%--      border-radius: 10px;--%>
<%--      box-shadow: 0 6px 12px rgba(0, 0, 0, 0.1);--%>
<%--    }--%>
<%--    h1 {--%>
<%--      color: #2c3e50;--%>
<%--      margin-bottom: 20px;--%>
<%--      font-size: 2em;--%>
<%--    }--%>
<%--    .todo-list {--%>
<%--      margin: 20px 0;--%>
<%--      text-align: left;--%>
<%--    }--%>
<%--    .todo-item {--%>
<%--      padding: 15px;--%>
<%--      margin-bottom: 15px;--%>
<%--      background-color: #eaf0f1;--%>
<%--      border-radius: 8px;--%>
<%--      border: 1px solid #d0d9de;--%>
<%--      box-shadow: 0 3px 6px rgba(0, 0, 0, 0.1);--%>
<%--    }--%>
<%--    .todo-item a {--%>
<%--      color: #3498db;--%>
<%--      text-decoration: none;--%>
<%--      font-weight: bold;--%>
<%--    }--%>
<%--    .todo-item a:hover {--%>
<%--      text-decoration: underline;--%>
<%--    }--%>
<%--    .button {--%>
<%--      display: inline-block;--%>
<%--      padding: 12px 24px;--%>
<%--      font-size: 16px;--%>
<%--      color: #ffffff;--%>
<%--      background-color: #e74c3c;--%>
<%--      border: none;--%>
<%--      border-radius: 5px;--%>
<%--      text-decoration: none;--%>
<%--      margin: 10px;--%>
<%--      transition: background-color 0.3s, transform 0.3s;--%>
<%--    }--%>
<%--    .button:hover {--%>
<%--      background-color: #c0392b;--%>
<%--      transform: translateY(-2px);--%>
<%--    }--%>
<%--    .button-secondary {--%>
<%--      background-color: #2ecc71;--%>
<%--    }--%>
<%--    .button-secondary:hover {--%>
<%--      background-color: #27ae60;--%>
<%--    }--%>
<%--  </style>--%>
<%--</head>--%>
<%--<body>--%>
<%--<div class="container">--%>
<%--  <h1>Todo 목록 보기</h1>--%>
<%--  <div class="todo-list">--%>
<%--    <!-- 예시로 세 개의 투두 항목을 추가 -->--%>
<%--    <div class="todo-item">--%>
<%--      <a href="view">투두 항목 1</a>--%>
<%--    </div>--%>
<%--    <div class="todo-item">--%>
<%--      <a href="view">투두 항목 2</a>--%>
<%--    </div>--%>
<%--    <div class="todo-item">--%>
<%--      <a href="view">투두 항목 3</a>--%>
<%--    </div>--%>
<%--  </div>--%>
<%--  <div>--%>
<%--    <a href="create" class="button">새 Todo</a>--%>
<%--    <a href="other" class="button button-secondary">다른 페이지</a>--%>
<%--  </div>--%>
<%--</div>--%>
<%--</body>--%>
<%--</html>--%>
