package com.cos.blog.action.board;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.blog.action.Action;
import com.cos.blog.repository.BoardRepository;
import com.cos.blog.util.Script;
public class BoardDeleteProcAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (
				request.getParameter("id") == null || 
				request.getParameter("id").equals("")
			) {
			return;
		}
		
		int id = Integer.parseInt(request.getParameter("id"));
		BoardRepository boardRepository = BoardRepository.getInstance();
		int result = boardRepository.deleteById(id);

		Script.outText(result+"", response);
		
//		PrintWriter out = response.getWriter();
//		out.print(result);
	}

}
