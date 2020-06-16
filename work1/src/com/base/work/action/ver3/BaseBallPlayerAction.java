package com.base.work.action.ver3;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.base.work.action.Action;
import com.base.work.dto.PlayerListResponseDto;
import com.base.work.repository.BaseBallRepository;
import com.base.work.util.Script;
import com.google.gson.Gson;

public class BaseBallPlayerAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int teamId = Integer.parseInt(request.getParameter("id"));
		System.out.println(teamId);
		BaseBallRepository baseBallRepository = BaseBallRepository.getInstance();
		List<PlayerListResponseDto> dtos =baseBallRepository.findAll(teamId);
		
		Gson gson = new Gson();
		String toJson = gson.toJson(dtos);
		Script.outJson(toJson, response);
	}
}
