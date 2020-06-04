package com.cos.blog.action.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cos.blog.action.Action;
import com.cos.blog.model.Board;
import com.cos.blog.model.Users;
import com.cos.blog.repository.BoardRepository;
import com.cos.blog.util.Script;

public class BoardWriteProcAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 0번 인증 확인
		HttpSession session = request.getSession();
		if (session.getAttribute("principal") == null) {
			Script.getMessage("잘못된 접근입니다.", response);
			return;
		}
		//세션에서 값 가져오기
		Users principal = (Users) session.getAttribute("principal");

		// 1번 request에 title값과 content 값 null인지 공백인지 확인
		if (request.getParameter("title").equals("") || 
				request.getParameter("title") == null|| 
				request.getParameter("content").equals("") || 
				request.getParameter("content") == null) {
			return;
		}

		
		// 2번 request에 title값과 content 값 받기
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		
		// 3번 title값과 content, principal.getID() 값을 board 오브젝트에 담기
		Board board = Board.builder()
				.userId(principal.getId())
				.title(title)
				.content(content)
				.readCount(0)
				.build();

		// 4번 BoardRepository 연결해서 save(board) 함수 호출
		BoardRepository boardRepository = BoardRepository.getInstance();
		int result = boardRepository.save(board);

		if (result == 1) {
			// 5번 result == 1이면 성공 로직(index.jsp로 이동)
			Script.href("글쓰기 성공", "index.jsp", response);
		} else {
			// 6번 result != 1이면 실패 로직(histroy.back())
			Script.back("글쓰기 실패", response);
		}

	}
}
