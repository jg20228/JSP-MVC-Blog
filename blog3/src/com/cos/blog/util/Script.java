package com.cos.blog.util;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

public class Script {
	public static void back(String msg, HttpServletResponse response) {
		
		try {
			response.setCharacterEncoding("utf-8");
			
			response.setContentType("text/html;charset=utf-8");
			
			PrintWriter out = response.getWriter();
			
			out.println("<script>");
			out.println("alert('"+msg+"');");
			//UX 측면에서 중요함
			out.println("history.back();");
			out.println("</script>");
			
		} catch (Exception e) {
			
		}

	}
}
