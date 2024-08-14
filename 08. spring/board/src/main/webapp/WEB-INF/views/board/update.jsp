<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<%@ include file="../layouts/header.jsp" %>

<h1 class="page-header my-4"><i class="far fa-edit"></i>글 수정</h1>

<div>
    <form role="form" method="post">
<%--        ${} 내에 있는 값들은 실제 DTO에 있는 프로퍼티여야 한다--%>
        <input type="hidden" name="no" value="${board.no}">
        <div>
            <label>제목</label>
            <input name="title" class="form-control" value="${board.title}">
        </div>
        
        <div>
            <label>작성자</label>
            <input name="writer" class="form-control" value="${board.writer}">
        </div>

        <div>
            <label>내용</label>
            <textarea class="form-control" name="content" rows="10">${board.writer}</textarea>
        </div>

<%--        submit 버튼은 클릭 시 action에 연결되어있는 링크로 이동, action 생략 시, 현재 주소 다시 호출--%>
        <button type="submit" class="btn btn-primary"><i class="fas fa-check"></i>확인</button>
<%--        reset 버튼은 form에 채워져있던 내용을 전부 초기화, 삭제--%>
        <button type="reset" class="btn btn-primary"><i class="fas fa-undo"></i>취소</button>
<%--        해당 링크는 누르면 상세 게시물 페이지로 이동--%>
        <a href="get?no=${board.no}" class="btn btn-primary"><i class="fas fa-list"></i>돌아가기</a>
    </form>
</div>

<%@ include file="../layouts/footer.jsp"%>