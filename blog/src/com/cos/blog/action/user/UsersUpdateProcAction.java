package com.cos.blog.action.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cos.blog.action.Action;
import com.cos.blog.model.RoleType;
import com.cos.blog.model.Users;
import com.cos.blog.repository.UsersRepository;
import com.cos.blog.util.Script;

public class UsersUpdateProcAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("principal")==null) {
			Script.getMessage("잘못된 접근입니다.", response);
			return;
		}
		
		// 0. 유효성 검사
		if
		(
				//required를 걸었을건데 이게 날라오면 정상적인 접근이 아님
				//정상적인 접근이 아닌게 확실하니 걸러야함
				request.getParameter("username").equals("") ||
				request.getParameter("username") ==null ||
				request.getParameter("password").equals("") ||
				request.getParameter("password") ==null ||
				request.getParameter("email").equals("") ||
				request.getParameter("email") ==null ||
				request.getParameter("address").equals("") ||
				request.getParameter("address") ==null 
		) {
			//밑에 실행 안하고 바로 빠져나감
			//여기다가 return 하기전에 request.remote~를 Log를 남겨야함
			return;
		}
		
		// 1. 파라메터 받기 (x-www-form-urlencoded 라는 MIME타입 key=value)
		int id = Integer.parseInt(request.getParameter("id"));
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		
		// 2. User - 오브젝트 변환
		
		Users user = Users.builder()
				.id(id)
				.password(password)
				.email(email)
				.address(address)
				.build();
		
		
		// 3. DB연결 - UserRepositroy의 save() 호출
		UsersRepository usersRepository = UsersRepository.getInstance();
		int result = usersRepository.update(user);
		// 4. index.jsp 페이지로 이동
		if(result==1) {
			//여기
			Users principal = usersRepository.findById(id);
			session.setAttribute("principal", principal);
			Script.href("회원수정에 성공하였습니다.", "index.jsp", response);		
		}else {
			Script.back("회원수정에 실패하였습니다.", response);	
		}
	}
}
