function home(){
	alert("처음으로");
}

function price(){
	alert("가격순");
	$.ajax({

	}).done(function(result){

	}).fail(function(error){
		alert("실패")
	});
}

function count(){
	var sort = "count";
	
	alert("판매순");
	$.ajax({
		type : "post",
		url : "/work1/product?cmd=sort",
		data : "sort="+sort,
		contentType : "application/x-www-form-urlencoded; charset=utf-8",
		dataType : "json"
	}).done(function(result){
		alert(result);
		console.log(result);
		$("#product__list").empty();
		renderProductList(result);
	}).fail(function(error){
		alert("실패")
	});
}

function renderProductList(products){
	for(var product of products){
		$("#product__list").append(makeProductItem(product));
	}
}

function makeProductItem(product){

	var item = `<li>`;
	item += `<div>`;
	item += `${product.id} ${product.name} ${product.type} ${product.price} ${product.count}`;
	item += `</div>`;
	item += `</li>`;
	
	return item;
}
