<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>

	<h1>elTest6.jsp</h1>
	
	이름 : ${name }
	<br/>
	이름 : ${param.name }
	<br/>
	<!-- 연산이 가능함 -->
	금액 : ${param.money+5000}
	<br/>
	<!-- empty == true, false 같은것 -->
	<!-- null 혹은 값("")이 비어있는지 검사해줌-->
	금액 : ${empty param.money}

	<script>
		var num = 100;
		//숫자로 받게됨
		var m = ${param.money};
		console.log(m);
		//''를 씌워서 문자열로 바꿈
		var ms = '${param.money}';
		console.log(ms);

		var sum = num+${param.money};
		console.log(sum);
	</script>
</body>
</html>

