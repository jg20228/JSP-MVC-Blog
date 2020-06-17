package com.cos.blog.action.kakao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.blog.action.Action;
import com.sun.net.ssl.HttpsURLConnection;

public class KakaoCallbackAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code = request.getParameter("code");
		//자바에서 기본적으로 url 커넥션해서 post하는것
		/*
		 * String grant_type = "authorization_code"; 
		 * String client_id ="7c7845f76f818e5e8ccd157573374296"; 
		 * String redirect_uri = "http://localhost:8000/blog/oauth/kakao?cmd=callback"; 
		 * //식별자를 요청하기때문에 uri가맞다.
		 * 
		 * request.setAttribute("code", code); request.setAttribute("grant_type",
		 * grant_type); request.setAttribute("client_id", client_id);
		 * request.setAttribute("redirect_uri", redirect_uri);
		 * 
		 * RequestDispatcher dis = request.getRequestDispatcher("/oauth/requestToken.jsp"); 
		 * dis.forward(request, response);
		 */
		//------------------------------------------------------------------
		//POST요청, x-www-form-urlencoded
		
		String endpoint = "https://kauth.kakao.com/oauth/token";
		URL url = new URL(endpoint);
		
		//StringBuilder bodyData = new StringBuilder();
		//append로 넣으면 Enter키가 들어간다.
		//없앨려면 URLEncoder.~으로 넣어야함
		//bodyData.append("");
		
		String bodyData="";
		bodyData+="grant_type=authorization_code&";
		bodyData+="client_id=7c7845f76f818e5e8ccd157573374296&";
		bodyData+="redirect_uri=http://localhost:8000/blog/oauth/kakao?cmd=callback&";
		bodyData+="code="+code;
		
		//conn을 만들었다.
		HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
		conn.getOutputStream().write(bodyData.getBytes("UTF-8")); 
		//요청 + 직렬화 할때 UTF-8로
		//Buffered 읽어서 요청할때 카카오 에는 이미 JSON이 있음
		BufferedReader br = new BufferedReader(
				new InputStreamReader(conn.getInputStream(), "UTF-8"));
		String input = "";
		StringBuilder sb = new StringBuilder();
		while((input = br.readLine())!=null) {
			sb.append(input);
		}
		System.out.println(sb.toString());
		//Gson으로 파싱
	}
}
