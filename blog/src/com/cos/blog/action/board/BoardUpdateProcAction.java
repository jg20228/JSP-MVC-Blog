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

public class BoardUpdateProcAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 0번 인증 확인
		HttpSession session = request.getSession();
		if (session.getAttribute("principal") == null) {
			Script.getMessage("잘못된 접근입니다.", response);
			return;
		}

		// 1번 request에 title값과 content 값 null인지 공백인지 확인
		if (
				request.getParameter("id").equals("") || 
				request.getParameter("id") == null || 
				request.getParameter("title").equals("") || 
				request.getParameter("title") == null || 
				request.getParameter("content").equals("") || 
				request.getParameter("content") == null
		) {
			return;
		}

		// 2번 request에 title값과 content 값 받기
		int id = Integer.parseInt(request.getParameter("id"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");

		// 3번 값을 board 오브젝트에 담기		
		//requestDto, responseDto가 만들수 있으나
		//requestDto는 각 요청에 대한 Request를 만들면 나중에 터져나감
		//responseDto는 필수이다. 하나의 오브젝트로 만들어서 한번에 넘긴다.
		Board board = Board.builder()
				.id(id)
				.title(title)
				.content(content)
				.build();

		// 4번 BoardRepository 연결해서 update(board) 함수 호출
		BoardRepository boardRepository = BoardRepository.getInstance();
		int result = boardRepository.update(board);

		if (result == 1) {
			// 5번 result == 1이면 성공 로직(index.jsp로 이동)
			// 수정 성공하고 원래 보던 글로 돌아감
			Script.href("수정 성공", "/blog/board?cmd=detail&id="+id, response);
		} else {
			// 6번 result != 1이면 실패 로직(histroy.back())
			Script.back("수정 실패", response);
		}

	}
}
