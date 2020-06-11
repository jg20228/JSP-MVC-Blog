package com.cos.blog.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cos.blog.action.Action;
import com.cos.blog.action.user.UsersJoinAction;
import com.cos.blog.action.user.UsersJoinProcAction;
import com.cos.blog.action.user.UsersLoginAction;
import com.cos.blog.action.user.UsersLoginProcAction;
import com.cos.blog.action.user.UsersLogoutAction;
import com.cos.blog.action.user.UsersProfileUploadAction;
import com.cos.blog.action.user.UsersProfileUploadProcAction;
import com.cos.blog.action.user.UsersUpdateAction;
import com.cos.blog.action.user.UsersUpdateProcAction;
import com.cos.blog.action.user.UsersUsernameCheckAction;
import com.cos.blog.util.Script;


// http://localhost:8000/blog/user
// 뒤에 주소를 붙여서 분기를 시킴
@WebServlet("/user")
public class UsersController extends HttpServlet {
	
	private final static String TAG = "UsersController : ";
	
	private static final long serialVersionUID = 1L;

    public UsersController() {
        super();

    }

    //종류가 4가지인데 두개만 쓴다. Get, Post
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//SELECT 는 doGet
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//DML 은 doPost
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Get과 Post에서 어떤 요청이 오든 이쪽으로 온다.
		//doProcess(request, response);
		
		HttpSession session = request.getSession();
		session.setAttribute("path", request.getContextPath());
		
		//http://localhost:/8000/blog/user?cmd=join
		//쿼리스트림(?)으로 분기를 나눈다
		String cmd = request.getParameter("cmd");
		System.out.println(TAG + "router() : "+cmd );
		//http://localhost:8000/blog/user?cmd=join
		
		//!!
		//팩토리 패턴
		Action action = router(cmd);
		action.execute(request, response);
		
	}
	
	public Action router(String cmd) {
		if(cmd.equals("join")) {
			// 회원 가입 페이지로 이동
			return new UsersJoinAction();
		}else if(cmd.equals("joinProc")) {
			// 회원 가입 진행 한 후 -> index.jsp로 이동
			return new UsersJoinProcAction();
		}else if(cmd.equals("update")) {
			// 회원 수정 페이지로 이동 (세션에 User 오브젝트를 가지고 있을 예정)
			return new UsersUpdateAction();
		}else if(cmd.equals("updateProc")) {
			// 회원 수정을 진행 한 후 -> index.jsp로 이동
			return new UsersUpdateProcAction();
		}else if(cmd.equals("delete")) {
			// 회원 삭제를 진행 한 후 -> 로그아웃을 하고(세션해지) -> index.jsp로 이동
			// 실제론 회원 탈퇴했는지 안했는지 값을 0이나 1로 바꿔서 표기함
		}else if(cmd.equals("login")) {
			// 회원 로그인 페이지로 이동
			return new UsersLoginAction();
		}else if(cmd.equals("loginProc")) {
			// 회원 로그인을 수행한 후 -> 세션에 등록을 하고 -> index.jsp로 이동
			return new UsersLoginProcAction();
		}else if(cmd.equals("logout")) {
			// 회원 로그아웃
			return new UsersLogoutAction();
		}else if(cmd.equals("usernameCheck")) {
			// 회원이름 중복 확인
			return new UsersUsernameCheckAction();
		}else if(cmd.equals("profileUpload")) {
			// 회원 프로필 업로드
			return new UsersProfileUploadAction();
		}else if(cmd.equals("profileUploadProc")) {
			// 회원 프로필 업로드
			return new UsersProfileUploadProcAction();
		}
		return null;
	}	
}
