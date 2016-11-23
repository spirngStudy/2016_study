<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ include file="/WEB-INF/views/common/include-header.jsp" %>
<script type="text/javascript">
	$(document).ready(function () {
		$("#list").on("click", function(e) {
			e.preventDefault();
			fn_openBoardList();
		});
		
		$("#update").on("click", function(e) {
			e.preventDefault();
			fn_openBoardUpdate();
		});
	});
	
	function fn_openBoardList() {
		var comSubmit = new ComSubmit();
		comSubmit.setUrl("<c:url value='/sample/openBoardList'/>");
		comSubmit.submit();		
	}
	function fn_openBoardUpdate() {
		var idx = "${map.IDX}";
		var comSubmit = new ComSubmit();
		comSubmit.setUrl("<c:url value='/sample/openBoardUpdate'/>");
		comSubmit.addParam("IDX", idx);
		comSubmit.submit();
	}
</script>
<div class="container">
	<table class="table">
		<colgroup>
			<col width="15%">
			<col width="35%">
			<col width="15%">
			<col width="35%">
		</colgroup>
		<caption>게시글 상세</caption>
		<tbody>
			<tr>
				<th scope="row">글 번호</th>
				<td>${map.IDX }</td>
				<th scope="row">조회수</th>
				<td>${map.HIT_CNT }</td>
			</tr>
			<tr>
				<th scope="row">작성자</th>
				<td>${map.CREA_ID }</td>
				<th scope="row">작성시간</th>
				<td>${map.CREA_DTM }</td>
			</tr>
			<tr>
				<th scope="row">제목</th>
				<td colspan="3">${map.TITLE}</td>
			</tr>
			<tr>
				<td colspan="4">${map.CONTENTS}</td>
			</tr>
		</tbody>
	</table>
	<div class="container">
		<div class="btn-group">
			<a href="#this" class="btn btn-primary" id="list" target="_self" ng-non-bindable>목록으로</a>
			<a href="#this" class="btn btn-primary" id="update" target="_self" ng-non-bindable>수정하기</a>
		</div>
	</div>
	<%@ include file="/WEB-INF/views/common/include-body.jsp" %>
</div>
