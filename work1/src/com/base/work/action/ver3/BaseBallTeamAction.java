package com.base.work.action.ver3;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.base.work.action.Action;
import com.base.work.model.Team;
import com.base.work.repository.BaseBallRepository;
import com.base.work.util.Script;
import com.google.gson.Gson;

public class BaseBallTeamAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BaseBallRepository baseBallRepository = BaseBallRepository.getInstance();
		List<Team> teams = baseBallRepository.findAll();
		Gson gson = new Gson();
		String toJson = gson.toJson(teams);
		Script.outJson(toJson, response);
	}
}
