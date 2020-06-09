<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../include/nav.jsp"%>
<!-- 자바스크립트의 백틱을 못쓴다 $랑 겹쳐서? -->
<div class="container">

	<!-- href 이동 이런것을 버튼으로 만들고 싶으면 class="btn btn-secondary" -->
	<!-- href에서도 자바스크립트 사용할려면  href="javascript:history.back();"-->
<!--<a class="btn btn-secondary" href="/blog/board?cmd=detail&id=1">이동</a>
	<a class="btn btn-secondary" href="javascript:history.back();">뒤로가기</a>  -->
	
	<!-- warning, danger -> 색깔만 바뀐것 -->
	<button class="btn btn-secondary" onclick="history.back()">뒤로가기</button>
	<c:if test="${sessionScope.principal.id == dto.board.userId }">
	<!-- dto를 들고가도 되지만 자바코드를 안쓰기 위해서 -->
	<!-- 동기화를 위해서 항상 SELECT를 사용 -->
	<!-- 상세보기->수정페이지 title과 content를 들고 가야한다.(모델에 들렀다가 데이터를 들고 가야함) -->
	<!-- Board가 들고있는 id를 들고 와야함-->
	<a href="/blog/board?cmd=update&id=${dto.board.id}" class="btn btn-warning">수정</a>
	
	<!-- 삭제하기 -->
	<!-- 삭제는 get이 아니라 post로 넘긴다. -->
	<button class="btn btn-danger" onclick="deleteById(${dto.board.id})">삭제</button>
	</c:if>
	
	<br/><br/>
	<h6>작성자 : <i>${dto.username}</i></h6>
	<h5>조회수 : ${dto.board.readCount}</h5>
	<br/>

	<h3><b>${dto.board.title}</b></h3>

	<div class="form-group">
		<div class="container p-3 my-3 border">${dto.board.content}</div>
	</div>
</div>


<script src="/blog/js/detail.js"></script>
<%@ include file="../include/footer.jsp"%>
