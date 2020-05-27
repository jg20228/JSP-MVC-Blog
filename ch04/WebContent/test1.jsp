<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%--위의 charset 전송할때 dataType, 이 데이터를 받는 HTML에서 meta charset이 다르면 한글이 깨진다.
    	pageEncoding은 알려주는것이라 상관없다.
     --%>
<%
	Random r = new Random();
	int num = r.nextInt(5);//0~4
	String name = "홍길동";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"> <!-- 웹 브라우저가 해석 -->
<title>랜덤 값 알아보기</title>
</head>
<body>

<h1>랜덤 값은 : <%=num %></h1>
<h2>이름은 : <%=name %></h2>
</body>
</html>