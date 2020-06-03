<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../include/nav.jsp"%>


<!-- 주소 /를 적는다는건 최상단으로 감, method http://localhost:8000/blog/-->
<div class="container">
	<form action="/blog/user?cmd=joinProc" method="POST" class="was-validated" onsubmit="return validate()">

		<div class="form-group">
			<button type="button" class="btn btn-warning float-right" onclick="usernameCheck()">중복확인</button>
			<label for=username>Username:</label> <input type="text" class="form-control" id="username" placeholder="Enter username" name="username" required>
			<div class="valid-feedback">Valid.</div>
			<div class="invalid-feedback">Please fill out this field.</div>
		</div>

		<div class="form-group">
			<label for="password">Password:</label> <input type="password" class="form-control" id="password" placeholder="Enter password" name="password" required>
			<div class="valid-feedback">Valid.</div>
			<div class="invalid-feedback">Please fill out this field.</div>
		</div>

		<div class="form-group">
			<label for="email">Email:</label> <input type="email" class="form-control" id="email" placeholder="Enter email" name="email" required>
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

			<input type="text" class="form-control" id="address" placeholder="Enter address" name="address" required readonly>

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

<script>
	var isCheckedUsername = false;

	function validate() {
		if (!isCheckedUsername) {
			alert('username 중복체크를 해주세요');
		}
		return isCheckedUsername;
	}

	

	function usernameCheck() {
		//성공
		var tfUsername = $('#username').val();
		//디버깅 1.alert, 2.console.log
		alert(tfUsername);
		console.log(tfUsername);
		
		//ajax
		$.ajax({
			type : 'get',
			url : '/blog/user?cmd=usernameCheck&username='+tfUsername
		}).done(function(result){
			console.log(result);
			//자바스크립트 2개는 값만비교, 3개는 타입,값까지 비교함 if(result!==)
			if(result==1){
				alert('아이디가 중복되었습니다');
			}else if(result==0){
				alert('사용하실 수 있는 아이디입니다.');
				isCheckedUsername = true;
			}else{
				//개발중에만 console로 찍어보고 배포할때 다 지워버림
				console.log('develop : 서버 오류');
			}
		//이 함수의 이름을 실행 할것이 아니기 때문에 이름이 필요없다.
		//function()을  ()=> 로 표시한다. - 람다식
		//자바에서 람다식을 쓰는 이유는 타입을 몰라도 되서 쓴다.
		//여기서 =>를 쓰는 이유는 this라는게 있다.
		//자바는 class 별로 this가 있는데 
		//자바스크립트는 this가 다르다.

		//var a = {name : '주호', play : function(){} }
		//a.play();

		//자바 스크립트는 모든 것이 오브젝트라서 this가 엄청 헷갈리게 되어있다.
		//<script> var my = this; </scr> - 전역으로 선언해서 사용함  
		//this를 매핑을 시켜놔서 - this 쓸대마다 다르니까  위로 사용함

		//그래서 .done=>를 사용하면 this가 해당 안에서만
		}).fail(function(error){
			console.log(error);
		});

		//위에 ajax를 로딩하고 있는 동안 다른것들 하고 있음 ==비동기
		//동기적으로 (위에 밑으로 내려갈려면) 설정을 하면된다.
		//-> async : false를 ajax안에서 설정하면 된다.
		//단 이 설정을하면 이 통신을 하고 있는 동안 다른것들을 못함 + done이 불필요 , fail만 있으면 됨
		
		
		//비동기 할때는 I/O하는게 대부분이여야함
		//done()이 항상 실행되기 때문에 여기에
		
		//isCheckedUsername = true;
		var oldVal = null;
		$("#username").on("propertychange change keyup paste input", function() {
		    var currentVal = $(this).val();
		    if(currentVal == oldVal) {
		        return;
		    }
		 	if(isCheckedUsername){
		 		isCheckedUsername=false;
			 }
		    oldVal = currentVal;
		    alert("changed!");
		});
	}
</script>


<%@ include file="../include/footer.jsp"%>