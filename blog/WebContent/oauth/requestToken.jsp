<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form id="form" method="post" action="https://kauth.kakao.com/oauth/token">
	<input type="hidden" name="grant_type" value="${grant_type}"/>
	<input type="hidden" name="client_id" value="${client_id}"/>
	<input type="hidden" name="redirect_uri" value="${redirect_uri}"/>
	<input type="hidden" name="code" value="${code}"/>
</form>
<script>
	//var form = $("#form").serialize();
	var a = form.submit();
	console.log(a);
	
	$.ajax({
		type : "POST",
		url : "https://kauth.kakao.com/oauth/token",
		data : data,
		content-type: "application/x-www-form-urlencoded; charset=utf-8;"
	}).done(function(resp){
		
		
	}).fail(function(resp){
		
	});
</script>
</body>
</html>