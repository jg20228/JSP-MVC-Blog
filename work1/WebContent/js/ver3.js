function team(){
	$.ajax({
		type : "post",
		url : "/work1/baseball?cmd=team",
		contentType : "application/x-www-form-urlencoded; charset=utf-8",
		dataType : "json"
	}).done(function(result){
		$("#team__list").empty();
		$("#player__list").empty();
		$("#playerInfo__list").empty();
		renderTeamList(result);
	}).fail(function(error){
		alert("실패")
	});
}

function renderTeamList(teams){
	
	var item = `<li class="list-group-item active">`;
	item += `<div>`;
	item += `팀목록`;
	item += `<br/>`;
	item += `</div>`;
	item += `</li>`;
	$("#team__list").append(item);
	
	for(var team of teams){
		$("#team__list").append(makeTeamItem(team));
	}
}

function makeTeamItem(team){
	//id추가
	var item = `<li li class="list-group-item" id="team-${team.id}">`;
	//id추가 끝
	item += `<div onclick="list('${team.id}')">`;
	item += `${team.id} ${team.name}`;
	item += `</div>`;
	item += `</li>`;
	return item;
}

function list(id){
	$.ajax({
		type : "post",
		url : "/work1/baseball?cmd=player&id="+id,
		contentType : "application/x-www-form-urlencoded; charset=utf-8",
		dataType : "json"
	}).done(function(result){
		$("#playerInfo__list").empty();
		$("#player__list").empty();
		renderPlayerList(result);
	}).fail(function(error){
		alert("실패")
	});
}


function renderPlayerList(dtos){
	var item = `<li class="list-group-item active">`;
	item += `<div>`;
	item += `선수목록`;
	item += `<br/>`;
	item += `</div>`;
	item += `</li>`;
	$("#player__list").append(item);
	var count = 0;
	for(var dto of dtos){
		count++;
		$("#player__list").append(makeListItem(dto,count));
	}
}

function makeListItem(dto, count){
	//id추가
	var item = `<li class="list-group-item" id="dto-${dto.player.id}">`;
	//id추가 끝
	item += `<div onclick="playerInfo('${dto.player.id}')">`;
	item += count+` ${dto.player.name}`;
	item += `</div>`;
	item += `</li>`;
	return item;
}

function playerInfo(id){
	$.ajax({
		type : "post",
		url : "/work1/baseball?cmd=playerInfo&id="+id,
		contentType : "application/x-www-form-urlencoded; charset=utf-8",
		dataType : "json"
	}).done(function(result){
		$("#playerInfo__list").empty();

		makePlayerInfo(result);
	}).fail(function(error){
		alert("실패")
	});
}



function makePlayerInfo(player){
	var item = `<li class="list-group-item active">`;
	item += `<div>`;
	item += `선수정보`;
	item += `<br/>`;
	item += `</div>`;
	item += `</li>`;
	
	item += `<li class="list-group-item">`;
	item += `<div>`;
	item += `유니폼번호 ${player.uniformNumber}`;
	item += `<br/>`;
	item += `</div>`;
	item += `</li>`;
	
	item += `<li class="list-group-item">`;
	item += `<div>`;
	item += `이름 ${player.name}`;
	item += `</div>`;
	item += `</li>`;
	
	item += `<li class="list-group-item">`;
	item += `<div>`;
	item += `포지션 ${player.position} `;
	item += `</div>`;
	item += `</li>`;
	
	$("#playerInfo__list").append(item);
}