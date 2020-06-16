function home(){
	$.ajax({
		type : "post",
		url : "/work1/product?cmd=home",
		contentType : "application/x-www-form-urlencoded; charset=utf-8",
		dataType : "json"
	}).done(function(result){
		$("#product__list").empty();
		renderProductList(result);
	}).fail(function(error){
		alert("실패")
	});
}

function price(){
	$.ajax({
		type : "post",
		url : "/work1/product?cmd=price",
		contentType : "application/x-www-form-urlencoded; charset=utf-8",
		dataType : "json"
	}).done(function(result){
		$("#product__list").empty();
		renderProductList(result);
	}).fail(function(error){
		alert("실패")
	});
}

function count(){
	$.ajax({
		type : "post",
		url : "/work1/product?cmd=count",
		contentType : "application/x-www-form-urlencoded; charset=utf-8",
		dataType : "json"
	}).done(function(result){
		$("#product__list").empty();
		renderProductList(result);
	}).fail(function(error){
		alert("실패")
	});
}

function renderProductList(products){
	
	var item = `<li class="list-group-item active">`;
	item += `<div>`;
	item += `번호 이름 종류 가격 판매수`;
	item += `</div>`;
	item += `</li>`;
	$("#product__list").append(item);
	
	for(var product of products){
		$("#product__list").append(makeProductItem(product));
	}
}

function makeProductItem(product){
	// id추가
	var item = `<li class="list-group-item" id="product-${product.id}">`;
	// id추가 끝
	item += `<div>`;
	item += `${product.id} ${product.name} ${product.type} ${product.price} ${product.count}`;
	// 삭제 추가
	item += ` <i class="material-icons i__btn" onclick="productDelete(${product.id})">delete</i>`;
	// 삭제 추가 끝
	item += `</div>`;
	item += `</li>`;
	return item;
}

function productDelete(productId){	
	$.ajax({
		type : "post",
		url : "/work1/product?cmd=deleteProc&id="+productId,
		contentType : "application/x-www-form-urlencoded; charset=utf-8",
		dataType : "text"
	}).done(function() {
		alert("성공");
		var productItem = $("#product-"+productId);
		productItem.remove();
	}).fail(function() {
		alert("실패");
	});
}

function insert(){
	var id = 0;
	var count = 0;
	var name = document.getElementById("name").value;
	var type = document.getElementById("type").value;
	var price = document.getElementById("price").value;
	
	console.log(name);
	console.log(type);
	console.log(price);
	if(name===""||type===""||price===""){
		alert("빈 값이 있습니다.");
		return;
	}
	
	var data = {
			id : id,
			name : name,
			type : type,
			price : price,
			count : count
	}
	
	$.ajax({
		type : "post",
		url : "/work1/product?cmd=insert",
		data : JSON.stringify(data),
		contentType : "application/json; charset=utf-8",
		dataType : "text"
	}).done(function() {
		alert("성공");
		home();
	}).fail(function() {
		alert("실패");
	});
	
}