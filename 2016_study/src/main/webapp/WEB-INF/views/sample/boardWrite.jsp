<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/include-header.jsp" %>
<script type="text/javascript">
	$(document).ready(function(){
		// 부트스트랩
		$(":file").filestyle({classButton: "btn btn-primary"});
		
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
    <form id="frm" name="frm" enctype="multipart/form-data">
    <div class="panel panel-success">
    	<div class="panel-body">
    		<span>제목</span>
    		<input type="text" id="TITLE" name="TITLE" class="form-control"></input>
    	</div>
    	<div class="panel-body">
    		<span>작성자</span>
    		<input type="text" id="CREA_ID" name="CREA_ID" class="form-control"></input>
    	</div>
    	<div class="panel-body">
    		<span>내용</span>
    		<textarea title="내용" id="CONTENTS" name="CONTENTS" rows="20" cols="100" class="form-control" ></textarea>
    	</div>
        <div class="form-group">
	      		<input name="file" type="file" class="filestyle" data-classButton="btn btn-primary">
      	</div>
    </div>
    <div class="container" style="text-align: right;">
        <div class="btn-group">
	        <a href="#this" class="btn btn-primary" id="write" >작성하기</a>
	        <a href="#this" class="btn btn-primary" id="list" >목록으로</a>
        </div>
    </div>
    </form>
</div>
    <%@ include file="/WEB-INF/views/common/include-body.jsp" %>
