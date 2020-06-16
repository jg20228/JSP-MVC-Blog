<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/include/nav.jsp"%>


<body onload="home()">
	<div class="container">
		<button onclick="home()">처음으로</button> 
		<button onclick="price()">가격순</button> 
		<button onclick="count()">판매순</button>
	</div>
	<nav>	
	 	<div class="container">
	      <div class="row">
	        <div class="col-12">
				<ul id="product__list" class="list-group m-2">
				</ul>
	        </div>
	      </div>
	    </div>	
    </nav>
</body>
<script src="/work1/js/ver1.js"></script>
<%@ include file="/include/footer.jsp"%>

