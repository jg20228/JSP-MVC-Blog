package com.cos.blog.dto;

import com.cos.blog.model.Board;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DetailResponseDto {
	//유저객체까지 받으면 낭비가 발생한다.
	//필요한 데이터만 받는다!
	private Board board;
	private String username;
}
