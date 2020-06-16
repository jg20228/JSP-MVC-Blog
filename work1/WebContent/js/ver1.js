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
	var item = `<li class="list-group-item">`;
	item += `<div>`;
	item += `${product.id} ${product.name} ${product.type} ${product.price} ${product.count}`;
	item += `</div>`;
	item += `</li>`;
	return item;
}
