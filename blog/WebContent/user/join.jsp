<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/nav.jsp"%>


<!-- 주소 /를 적는다는건 최상단으로 감, method http://localhost:8000/blog/-->
<div class="container">
	<form action="/blog/user?cmd=joinProc" method="POST"
		class="was-validated">

		<div class="form-group">
			<label for=username>Username:</label> <input type="text"
				class="form-control" id="username" placeholder="Enter username"
				name="username" required>
			<div class="valid-feedback">Valid.</div>
			<div class="invalid-feedback">Please fill out this field.</div>
		</div>

		<div class="form-group">
			<label for="password">Password:</label> <input type="password"
				class="form-control" id="password" placeholder="Enter password"
				name="password" required>
			<div class="valid-feedback">Valid.</div>
			<div class="invalid-feedback">Please fill out this field.</div>
		</div>

		<div class="form-group">
			<label for="email">Email:</label> <input type="email"
				class="form-control" id="email" placeholder="Enter email"
				name="email" required>
			<div class="valid-feedback">Valid.</div>
			<div class="invalid-feedback">Please fill out this field.</div>
		</div>

		<div class="form-group">
			<label for="address">Address:</label> 
			<!-- button으로 type을 지정안하면  submit을 안함-->
			<!-- float-right 우측으로 배치 (내가 inline block일때 사용 가능) -->
			<!-- 어떻게 아는지는 마우스 우클릭해서 element - style에서 보면 확인 가능함 -->
			<!-- justify -->
			<button type="button" class="btn btn-warning float-right" onclick="goPopup()" >주소검색</button>

			<input type="text" class="form-control" id="address" placeholder="Enter address" name="address" required> 

			<div class="valid-feedback">Valid.</div>
			<div class="invalid-feedback">Please fill out this field.</div>
		</div>

		<button type="submit" class="btn btn-primary">회원가입</button>
	</form>
</div>

<script>
	//footer보다는 밑에 두지 말아야한다.
	function goPopup() {
		var pop = window.open("/blog/juso/jusoPopup.jsp", "pop",
				"width=570,height=420, scrollbars=yes, resizable=yes");
	}

	function jusoCallBack(address) {
		//document.form.address.value = address; - 구방식
		//document.getElementById("address").value = address; - 내가한거
		
		//요즘 방식
		var tfAddress = document.querySelector("#address");		
		tfAddress.value = address;	
	}
</script>

<%@ include file="../include/footer.jsp"%>