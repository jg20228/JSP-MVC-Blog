<%@page import="com.cos.blog.model.Users"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="include/nav.jsp"%>

<div class="container">

	<!-- 검색 -->
	<div class="d-flex m-2 justify-content-end">
		<form class="form-inline" style="display: inline-block !important" action="/blog/board">
			<input type="hidden" name="cmd" value="search" /> 
			<input type="hidden" name="page" value="0" /> 
			<input name="keyword" class="form-control mr-sm-2" type="text" placeholder="Search">
			<button class="btn btn-primary">검색</button>
		</form>
	</div>

	<!-- 게시글 -->
	<c:forEach var="board" items="${boards}">
		<div class="card m-2" style="width: 100%">
			<div class="card-body">
				<h4 class="card-title">${board.title}</h4>
				<p class="card-text">${board.content}</p>
				<a href="/blog/board?cmd=detail&id=${board.id}" class="btn btn-primary">상세보기</a>
			</div>
		</div>
	</c:forEach>
	<br />
	<%@ include file="/include/page.jsp"%>
</div>
<%@ include file="/include/footer.jsp"%>