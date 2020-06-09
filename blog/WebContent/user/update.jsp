<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../include/nav.jsp"%>
<%@ include file="../include/authentication.jsp"%>

<!-- 주소 /를 적는다는건 최상단으로 감, method http://localhost:8000/blog/-->
<div class="container">
	<form action="/blog/user?cmd=updateProc" method="POST" class="was-validated">
	
		<!-- id랑 title,content 3개를 넘겨야 수정이 가능하다. -->
		<input type="hidden" value="${sessionScope.principal.id}" name="id"/>

		<div class="form-group">		
			<label for=username>Username:</label> 
			
			<input type="text" value="${sessionScope.principal.username}"
			class="form-control" id="username" placeholder="Enter username" name="username" readonly>
			
			<div class="valid-feedback">Valid.</div>
			<div class="invalid-feedback">Please fill out this field.</div>
		</div>

		<div class="form-group">
			<label for="password">Password:</label> 
			
			<input type="password" class="form-control" id="password" placeholder="Enter password" name="password" required>
			
			<div class="valid-feedback">Valid.</div>
			<div class="invalid-feedback">Please fill out this field.</div>
		</div>

		<div class="form-group">
			<label for="email">Email:</label> 
			
			<input type="email" value="${sessionScope.principal.email}"
			class="form-control" id="email" placeholder="Enter email" name="email" required>
			
			<div class="valid-feedback">Valid.</div>
			<div class="invalid-feedback">Please fill out this field.</div>
		</div>

		<div class="form-group">
			<label for="address">Address:</label>
			<!-- button으로 type을 지정안하면  submit을 안함-->
			<!-- float-right 우측으로 배치 (내가 inline block일때 사용 가능) -->
			<!-- 어떻게 아는지는 마우스 우클릭해서 element - style에서 보면 확인 가능함 -->
			<!-- justify -->
			<button type="button" class="btn btn-warning float-right" onclick="goPopup()">주소검색</button>

			<input type="text" value="${sessionScope.principal.address}"
			class="form-control" id="address" placeholder="Enter address" name="address" required readonly>

			<div class="valid-feedback">Valid.</div>
			<div class="invalid-feedback">Please fill out this field.</div>
		</div>

		<button type="submit" class="btn btn-primary">수정 완료</button>
		
	</form>
</div>

<script src="/blog/js/update.js"></script>
<%@ include file="../include/footer.jsp"%>