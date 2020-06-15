<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<meta charset="UTF-8">
<title>Ver1</title>
</head>
<body>
	<button onclick="home()">처음으로</button> 
	<button onclick="price()">가격순</button> 
	<button onclick="count()">판매순</button>
	
	<ul id="product__list">
		<c:forEach var="product" items="${products}">
			<li>
				<div>
				${product.id} ${product.name} ${product.type} ${product.price} ${product.count}
				</div>
			</li>
		</c:forEach>
	</ul>
</body>

<script src="/work1/js/ver1.js"></script>
</html>