package com.cos.blog2.model;

import com.sun.jmx.snmp.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reply {
	private int id;
	private int userId;
	private int boardId;
	private String content;
	private Timestamp createDate;
}