<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Ver1</title>
</head>
<body>
	<button onclick="home()">처음으로</button> 
	<button onclick="price()">가격순</button> 
	<button onclick="count()">판매순</button>
	
	<table style="border:1px;">
		<c:forEach var="product" items="${products}">
			<tr style="border:1px;">
				<td style="border:1px;">
				${product.id} ${product.name} ${product.type} 
				${product.price} ${product.count}
				</td>
			</tr>
		</c:forEach>
	</table>
</body>

<script>

function home(){
	alert("처음으로");
}

function price(){
	alert("가격순");
}

function count(){
	alert("판매순");
}

</script>

</html>