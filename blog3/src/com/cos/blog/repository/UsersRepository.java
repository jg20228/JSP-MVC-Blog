package com.cos.blog.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cos.blog.db.DBConn;
import com.cos.blog.model.Users;

// == DAO
public class UsersRepository {
	//싱글톤
	private static final String TAG = "UsersRepository : ";

	private static UsersRepository instance = new UsersRepository();
	private UsersRepository() {} 
	
	public static UsersRepository getInstance() {
		return instance;
	}
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public int save(Users user) {
		final String SQL ="INSERT INTO USERS(id, username, password, email, address, userRole,createDate)"
				+ "VALUES(USERS_seq.nextVAL,?,?,?,?,?,sysdate)";
		
		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(SQL);
			
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getEmail());
			pstmt.setString(4, user.getAddress());
			pstmt.setString(5, user.getUserRole());
			
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(TAG + "save : "+e.getMessage());
		}finally {
			DBConn.close(conn, pstmt);
		}
		return -1;
	}
	
	public int update(Users user) {
		final String SQL ="";
		
		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(SQL);
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(TAG + "update : "+e.getMessage());
		}finally {
			DBConn.close(conn, pstmt);
		}
		return-1;
	}
	
	public int deleteById(int id) {
		final String SQL ="";
		
		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(SQL);
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(TAG + "deleteById : "+e.getMessage());
		}finally {
			DBConn.close(conn, pstmt);
		}
		return -1;
	}
	
	public List<Users> findAll() {
		final String SQL ="";
		
		List<Users> users = new ArrayList<>();
		
		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			//물음표 완성
			
			//while 돌려서 rs->java 오브젝트에 집어넣기
			while(rs.next()) {
			}
			
			return users;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(TAG + "deleteById : "+e.getMessage());
		}finally {
			DBConn.close(conn, pstmt);
		}
		return null;
	}
	
	public Users findById(int id) {
		final String SQL ="";
		Users user = new Users();
		
		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			//물음표 완성
			
			if(rs.next()) {
				
			}

			
			return user;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(TAG + "deleteById : "+e.getMessage());
		}finally {
			DBConn.close(conn, pstmt);
		}
		return null;
	}
	
	
	
	
}
