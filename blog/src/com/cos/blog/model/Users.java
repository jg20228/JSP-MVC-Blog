package com.cos.blog.model;



import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Users {
	private int id;
	private String username;
	private String password;
	private String email;
	private String address;
	private String userProfile;
	private String userRole; //->enum
	private Timestamp createDate; 
	//local 데이터를 timestamp로 변환해서 넣음
}
