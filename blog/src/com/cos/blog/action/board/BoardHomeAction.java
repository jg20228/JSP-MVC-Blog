package com.cos.blog.action.board;

import java.io.IOException;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cos.blog.action.Action;
import com.cos.blog.model.Board;
import com.cos.blog.repository.BoardRepository;
import com.cos.blog.util.HtmlParser;

public class BoardHomeAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int page = Integer.parseInt(request.getParameter("page"));
		//1. DB연결해서 Board 목록 다 불러와서
		BoardRepository boardRepository =BoardRepository.getInstance();

		// 다 가져오기
		List<Board> count = boardRepository.findAll();
		int total = (count.size()/3);
		System.out.println(total);
		// 3건만 페이징하여 가져오기
		List<Board> boards = boardRepository.findAll(page);
		
		for (Board board : boards) {	
			String preview = HtmlParser.getContentPreview(board.getContent());
			board.setContent(preview);
		}

		//2. request에 담고
		request.setAttribute("boards", boards);
		request.setAttribute("total", total);
		
		HttpSession session = request.getSession();
		session.setAttribute("backPage", page);
		session.setAttribute("backKeyword", null);
		//3. 이동 home.jsp
		RequestDispatcher dis = request.getRequestDispatcher("home.jsp");
		dis.forward(request, response);	
	}
}

