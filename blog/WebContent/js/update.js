
// jsuo.go.kr 라이브러리 함수 (시작) -----------------------------------
function goPopup() {
	window.open("/blog/juso/jusoPopup.jsp", "pop",
			"width=570,height=420, scrollbars=yes, resizable=yes");
}

function jusoCallBack(address) {
	// document.form.address.value = address; - 구방식
	// document.getElementById("address").value = address; - 내가한거

	// 요즘 방식
	var tfAddress = document.querySelector("#address");
	tfAddress.value = address;
}

