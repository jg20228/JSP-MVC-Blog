package com.cos.blog.action.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cos.blog.action.Action;
import com.cos.blog.util.Script;

public class BoardWriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// write.jsp에서 자바 코드를 안넣을려면 여기서 처리해야한다.
		HttpSession session = request.getSession();
		if (session.getAttribute("principal") == null) {
			// 주소로 들어왔을때를 대비
			Script.getMessage("잘못된 접근입니다.", response);
			return;
		} else {
			RequestDispatcher dis = request.getRequestDispatcher("board/write.jsp");
			dis.forward(request, response);
		}
	}
}
