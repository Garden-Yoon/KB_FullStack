<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<%@include file="../layouts/header.jsp"%>
<h1 class="page-header my-4"><i class="far fa-file-alt"></i> ${board.title}</h1>
<div class="d-flex justify-content-between">
    <div><i class="fas fa-user"></i> ${board.writer}</div>
    <div>
        <i class="fas fa-clock"></i>
        <fmt:formatDate pattern="yyyy-MM-dd" value="${board.regDate}"/>
    </div>
</div>
<hr>
<div>
    ${board.content}
</div>

<div class="mt-4">
    <a href="list" class="btn btn-primary"><i class="fas fa-list"></i> 목록</a>
    <a href="update?no=${board.no}" class="btn btn-primary"><i class="far fa-edit"></i> 수정</a>
    <a href="delete?no=${board.no}" class="btn btn-primary"><i class="fas fa-trash-alt"></i> 삭제</a>
</div>
<%@include file="../layouts/footer.jsp"%>