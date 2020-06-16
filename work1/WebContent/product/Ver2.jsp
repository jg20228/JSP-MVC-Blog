<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include/nav.jsp"%>
<body onload="home()">
	<div class="container">
		<button onclick="home()">처음으로</button>
		<button onclick="price()">가격순</button>
		<button onclick="count()">판매순</button>

		<div class="row">
			<div class="col-12">
				<ul id="product__list" class="media-list">
				</ul>
			</div>
		</div>
	</div>
		<div class="container">
			<input type="hidden" class="form-control" id="id" name="id" value="0">
			<input type="hidden" class="form-control" id="count" name="count" value="0">
			이름<input type="text" class="form-control" id="name" placeholder="Enter name" name="name" required>
			타입<input type="text" class="form-control" id="type" placeholder="Enter type" name="type" required>
			가격<input type="text" class="form-control" id="price" placeholder="Enter price" name="price" required> 
			<br>
			<button onclick="insert()" class="btn btn-primary float-right">추가</button>
		</div>

</body>
<script src="/work1/js/ver2.js"></script>
<%@ include file="/include/footer.jsp"%>