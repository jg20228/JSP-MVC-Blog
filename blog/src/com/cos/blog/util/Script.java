package com.cos.blog.util;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

public class Script {
	public static void back(String msg, HttpServletResponse response) {
		try {
			
			//들고가는 데이터를 셋팅 ->이거는 web.xml에서 설정해도 된다.
			response.setCharacterEncoding("utf-8");
			
			//alert의 한글이 깨질껀데 이미 type을 알려준다.
			//이 밑에건 json 타입도 있어서 web.xml에서 설정하면 안됨
			response.setContentType("text/html; charset=utf-8");
			
			PrintWriter out = response.getWriter();
			
			out.println("<script>");
			
			//메세지를 동적으로 보여줄 수 있음
			out.println("alert('"+msg+"');");
			
			//UX 측면에서 history.back 매우 중요함
			out.println("history.back();");
			out.println("</script>");
		} catch (Exception e) {

		}

	}
}
