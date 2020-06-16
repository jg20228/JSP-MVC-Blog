package com.base.work.action.ver3;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.base.work.action.Action;
import com.base.work.model.Player;
import com.base.work.repository.BaseBallRepository;
import com.base.work.util.Script;
import com.google.gson.Gson;

public class BaseBallPlayerInfoAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int playerId = Integer.parseInt(request.getParameter("id"));
		BaseBallRepository baseBallRepository = BaseBallRepository.getInstance();
		Player player = baseBallRepository.findById(playerId);
		
		Gson gson = new Gson();
		String toJson = gson.toJson(player);
		Script.outJson(toJson, response);
	}

}
