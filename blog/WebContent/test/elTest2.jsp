<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>elTest2.jsp</title>
</head>
<body>
<h1>elTest2.jsp 파일</h1>
<hr/>
<!-- request가 아닌 모든 것들은 Scope를 적는다 -->
유저네임 : ${username }<br/>
비밀번호 : ${sessionScope.password }<br/>
</body>
</html>

