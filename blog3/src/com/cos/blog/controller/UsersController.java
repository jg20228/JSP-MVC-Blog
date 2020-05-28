package com.cos.blog.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.blog.action.Action;
import com.cos.blog.action.user.UsersJoinAction;
import com.cos.blog.action.user.UsersJoinProcAction;


@WebServlet("/user")
public class UsersController extends HttpServlet {
	
	private final static String TAG = "UsersController : ";
	
	private static final long serialVersionUID = 1L;
       

    public UsersController() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String cmd = request.getParameter("cmd");
		System.out.println(TAG + "router() : "+cmd);
		
		
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
		}
		return null;
	}
	
}
