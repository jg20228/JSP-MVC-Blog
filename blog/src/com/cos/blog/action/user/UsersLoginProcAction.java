package com.cos.blog.action.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cos.blog.action.Action;
import com.cos.blog.model.RoleType;
import com.cos.blog.model.Users;
import com.cos.blog.repository.UsersRepository;
import com.cos.blog.util.Script;

public class UsersLoginProcAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 0. 유효성 검사
		if
		(
				request.getParameter("username").equals("") ||
				request.getParameter("username") ==null ||
				request.getParameter("password").equals("") ||
				request.getParameter("password") ==null 
		) {
			//밑에 실행 안하고 바로 빠져나감
			//여기다가 return 하기전에 request.remote~를 Log를 남겨야함
			return;
		}
		
		// 1. 파라메터 받기 (x-www-form-urlencoded 라는 MIME타입 key=value)
		String username = request.getParameter("username");
		String password = request.getParameter("password");
	
		// 2. DB연결 - UserRepositroy의 save() 호출
		UsersRepository usersRepository = UsersRepository.getInstance();
		Users user = usersRepository.findByUsernameAndPassword(username, password);
		
		if(user != null) {
			//로그인 성공
			//session은 request가 들고 있다.
			HttpSession session = request.getSession();
			
			//6.1 로그인시 기억하기 체크관련 추가
			if(request.getParameter("remember") != null) {
				Cookie cookie = new Cookie("remember", user.getUsername());
				response.addCookie(cookie);
			}else {
				Cookie cookie = new Cookie("remember", null);
				cookie.setMaxAge(0);
				response.addCookie(cookie);
			}

			//인증 주체  = principal
			//session의 principal에 저장
			//유저마다 Jsession의 아이디마다 principal이 어떤애인지 찾음
			//자기만의 principal이 된다.	
			
			session.setAttribute("principal", user);
			
			Script.href("로그인 성공", "/blog/board?cmd=home", response);
		}else {
			//로그인 실패
			Script.back("로그인 실패", response);
		}
	}
}
