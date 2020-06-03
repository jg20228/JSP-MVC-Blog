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

	private static final String TAG = "UsersRepository : ";

	// 싱글톤
	private static UsersRepository instance = new UsersRepository();

	private UsersRepository() {
	}

	public static UsersRepository getInstance() {
		return instance;
	}

	// 전역으로 설정
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	//카운트 값을 return 할 예정
	//오브젝트로(users) 해도 상관은 없음
	public int findByUsername(String username) {
		final String SQL = "SELECT count(*) FROM users WHERE username = ?";
		Users user = null;

		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(SQL);
			// 물음표 완성
			pstmt.setString(1, username);
			// if 돌려서 rs-> java오브젝트에 집어넣기
			rs = pstmt.executeQuery();
			if(rs.next()) {
				//첫번째 컬럼 index가 0이 아니라 1부터 시작
				return rs.getInt(1);
			}	
		} catch (Exception e) {
			e.printStackTrace();
			// 오류나면 이 TAG로 찾아가면 된다.
			System.out.println(TAG + "findByUsername : " + e.getMessage());
		} finally {
			DBConn.close(conn, pstmt, rs);
		}
		return -1;
	}

	public Users findByUsernameAndPassword(String username, String password) {
		//패스워드는 꺼내지 않는다
		final String SQL = "SELECT id, username, email, address, userProfile ,userRole, createDate FROM users WHERE username = ? AND password = ?";
		//null
		Users user = null;

		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(SQL);
			// 물음표 완성
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			// if 돌려서 rs-> java오브젝트에 집어넣기
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				//SELECT로 찾았다는건 
				user = new Users();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setEmail(rs.getString("email"));
				user.setAddress(rs.getString("address"));
				user.setUserProfile(rs.getString("userProfile"));
				user.setUserRole(rs.getString("userRole"));
				user.setCreateDate(rs.getTimestamp("createDate"));
			}
			return user;
		} catch (Exception e) {
			e.printStackTrace();
			// 오류나면 이 TAG로 찾아가면 된다.
			System.out.println(TAG + "findByUsernameAndPassword : " + e.getMessage());
		} finally {
			DBConn.close(conn, pstmt, rs);
		}
		//로그인 실패
		return null;
	}

	public int save(Users user) {
		// 유저 받아서 insert하면 끝
		final String SQL = "INSERT INTO USERS(id, username, password, email, address, userRole, createDate) "
				+ "VALUES(USERS_SEQ.nextval, ?,?,?,?,?,sysdate) ";
		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getEmail());
			pstmt.setString(4, user.getAddress());
			pstmt.setString(5, user.getUserRole());
			// 물음표 완성
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			// 오류나면 이 TAG로 찾아가면 된다.
			System.out.println(TAG + "save : " + e.getMessage());
		} finally {
			DBConn.close(conn, pstmt);
		}
		return -1;
	}

	public int update(Users user) {
		final String SQL = "";
		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(SQL);
			// 물음표 완성
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			// 오류나면 이 TAG로 찾아가면 된다.
			System.out.println(TAG + "update : " + e.getMessage());
		} finally {
			DBConn.close(conn, pstmt);
		}
		return -1;
	}

	public int deleteById(int id) {
		final String SQL = "";
		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(SQL);
			// 물음표 완성
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			// 오류나면 이 TAG로 찾아가면 된다.
			System.out.println(TAG + "deleteById : " + e.getMessage());
		} finally {
			DBConn.close(conn, pstmt);
		}
		return -1;
	}

	// 관리자를 위함
	public List<Users> findAll() {
		final String SQL = "";
		List<Users> users = new ArrayList<>();

		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(SQL);
			// 물음표 완성

			// while 돌려서 rs-> java오브젝트에 집어넣기
			return users;
		} catch (Exception e) {
			e.printStackTrace();
			// 오류나면 이 TAG로 찾아가면 된다.
			System.out.println(TAG + "findAll : " + e.getMessage());
		} finally {
			DBConn.close(conn, pstmt, rs);
		}
		return null;
	}

	public Users findById(int id) {
		final String SQL = "";
		Users user = new Users();

		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(SQL);
			// 물음표 완성

			// if 돌려서 rs-> java오브젝트에 집어넣기
			return user;
		} catch (Exception e) {
			e.printStackTrace();
			// 오류나면 이 TAG로 찾아가면 된다.
			System.out.println(TAG + "findById : " + e.getMessage());
		} finally {
			DBConn.close(conn, pstmt, rs);
		}
		return null;
	}
}
