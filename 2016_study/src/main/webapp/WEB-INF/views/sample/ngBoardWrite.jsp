<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/include-header.jsp" %>
<script type="text/javascript">
	$(document).ready(function(){
	    $("#list").on("click", function(e){ //목록으로 버튼
	        e.preventDefault();
	        fn_openBoardList();
	    });
	     
	    $("#write").on("click", function(e){ //작성하기 버튼
	        e.preventDefault();
	        fn_insertBoard();
	    });
	});
	 
	function fn_openBoardList(){
	    var comSubmit = new ComSubmit();
	    comSubmit.setUrl("<c:url value='/sample/openBoardList' />");
	    comSubmit.submit();
	}
	 
	function fn_insertBoard(){
	    var comSubmit = new ComSubmit("frm");
	    comSubmit.setUrl("<c:url value='/sample/insertBoard' />");
	    comSubmit.submit();
	}
</script>
<div class="container">
    <form id="frm">
        <table class="table">
            <colgroup>
                <col width="15%">
                <col width="*"/>
            </colgroup>
            <caption>게시글 작성</caption>
            <tbody>
                <tr>
                    <th scope="row">제목</th>
                    <td><input type="text" id="TITLE" name="TITLE"></input></td>
                </tr>
                <tr>
                    <td colspan="2" class="view_text">
                        <textarea rows="20" cols="100" title="내용" id="CONTENTS" name="CONTENTS"></textarea>
                    </td>
                </tr>
            </tbody>
        </table>
        <div class="btn-group">
	        <a href="#this" class="btn btn-primary" id="write" >작성하기</a>
	        <a href="#this" class="btn btn-primary" id="list" >목록으로</a>
        </div>
    </form>
</div>
    <%@ include file="/WEB-INF/views/common/include-body.jsp" %>
