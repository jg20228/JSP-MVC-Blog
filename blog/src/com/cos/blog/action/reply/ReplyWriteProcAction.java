package com.cos.blog.action.reply;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.blog.action.Action;
import com.cos.blog.dto.ReplyResponseDto;
import com.cos.blog.model.Reply;
import com.cos.blog.repository.ReplyRepository;
import com.cos.blog.util.Script;
import com.google.gson.Gson;

public class ReplyWriteProcAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		//application/json
		BufferedReader br = request.getReader();
		StringBuffer sb = new StringBuffer();
		String input = null;
		while((input = br.readLine()) != null) {
			sb.append(input);
		}
		System.out.println("저장테스트"+sb.toString());
		Gson gson = new Gson();
		Reply reply = gson.fromJson(sb.toString(), Reply.class);

		//ReplyRepositroy 연결 save(reply)
		ReplyRepository replyRepository = ReplyRepository.getInstance();
		// save 성공하면 1, 실패하면 0 , -1
		int result = replyRepository.save(reply);
		if(result==1) {
			List<ReplyResponseDto> replyDtos = replyRepository.findAll(reply.getBoardId());
			String replyDtosJson = gson.toJson(replyDtos);
			Script.outJson(replyDtosJson, response);
		}else {
			Script.outText(result+"", response);
		}
	}
}
