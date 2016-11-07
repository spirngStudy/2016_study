<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/include-header.jsp" %>
<script type="text/javascript">
	$(document).ready(function () {
		$("#list").on("click", function(e) {
			e.preventDefault();
			fn_openBoardList();
		});
		
		$("#update").on("click", function(e) {
			e.preventDefault();
			fn_updateBoard();
		});

		$("#delete").on("click", function(e) {
			e.preventDefault();
			fn_deleteBoard();
		});
	});
	
	function fn_openBoardList() {
		var comSubmit = new ComSubmit();
		comSubmit.setUrl("<c:url value='/sample/openBoardList'/>");
		comSubmit.submit();		
	}
	function fn_updateBoard() {
		var comSubmit = new ComSubmit("frm");
		comSubmit.setUrl("<c:url value='/sample/updateBoard'/>");
		comSubmit.submit();
	}
	function fn_deleteBoard() {
		var comSubmit = new ComSubmit();
		comSubmit.setUrl("<c:url value='/sample/deleteBoard'/>");
		comSubmit.addParam("IDX", $("#IDX").val());
		comSubmit.submit();		
	}
</script>
<div class="container">
	<form id="frm">
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
					<td>
						${map.IDX }
						<input type="hidden" id="IDX" name="IDX" value="${map.IDX }" >
					</td>
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
					<td colspan="3">
						<input type="text" id="TITLE" name="TITLE" class="wdp_90" value="${map.TITLE }">
					</td>
				</tr>
				<tr>
					<td colspan="4">
						<input type="text" id="CONTENTS" name="CONTENTS" class="wdp_90" value="${map.CONTENTS}">
					</td>
				</tr>
			</tbody>
		</table>
	</form>
	<div class="btn-group">
		<a href="#this" class="btn btn-primary" id="list">목록으로</a>
		<a href="#this" class="btn btn-primary" id="update">저장히기</a>
		<a href="#this" class="btn btn-primary" id="delete">삭제하기</a>
	</div>
	<%@ include file="/WEB-INF/views/common/include-body.jsp" %>
</div>