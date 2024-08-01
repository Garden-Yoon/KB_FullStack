<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>새 Todo 생성</h1>
    <form method="POST">
        <div>
            제목 : <input type="text" name="title"> <br>
            내용 : <textarea name="content" id="content" cols="30" rows="10"></textarea>
        </div>
        <input type="submit">
    </form>
</body>
</html>
