function replyWrite(boardId, userId) {
	// key : value
	// value에 인수들이 들어감
	var data = {
		boardId : boardId,
		userId : userId,
		content : $("#reply__write__form").val()
	};

	$.ajax({
		type : "post",
		url : "/blog/reply?cmd=writeProc",
		data : JSON.stringify(data),
		contentType : "application/json; charset=utf-8",
		dataType : "json"
	}).done(function(result) {
		// 정상 응답
		// 1.reply__list를 찾아서 내부를 비우기
		if (result == -1 || result ==0) {
			alert("댓글 작성 실패1");
		}else{
			alert("댓글 작성 성공");
			// element 내용 지움
			// remove는 element를 지움
			$("#reply__list").empty();
			console.log(result);
			renderReplyList(result);
			$("#reply__write__form").val("");
		}
		// 2.ajax 재호출 findAll() select해서 들고온다.
		// 3.reply__list를 찾아서 내부에 채워주기
	}).fail(function(error) {
		alert("댓글 작성 실패");
	});
}

function renderReplyList(replyDtos){
	for(var replyDto of replyDtos){
		$("#reply__list").append(makeReplyItem(replyDto));
	}
}

function makeReplyItem(replyDto){
	var replyItem = `<li class="media">`;
	if(replyDto.userProfile == null){
		replyItem += `<img src="/blog/image/userProfile.png" class="img-circle">`;	
	}else{
		replyItem += `<img src="${replyDto.userProfile}" class="img-circle">`;
	}
	replyItem += `<div class="media-body">`;
	replyItem += `<strong class="text-primary">${replyDto.username}</strong>`;
	replyItem += `<p>${replyDto.reply.content}</p>`;
	replyItem += `</div>`;
	replyItem += `</li>`;
	return replyItem;
}

