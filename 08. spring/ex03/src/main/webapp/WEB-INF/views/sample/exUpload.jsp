<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/sample/exUploadPost" method="POST" enctype="multipart/form-data">
         <div>
<%--             하나의 input에는 file 하나만 업로드--%>
            <input type="file" name="files" />
        </div>
        <div><input type="file" name="files" /> </div>
        <div><input type="file" name="files" /> </div>
        <div><input type="file" name="files" /> </div>
        <div><input type="file" name="files" /> </div>
        <div><input type="submit" /></div>
    </form>

</body>
</html>
