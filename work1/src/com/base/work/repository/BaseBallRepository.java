package com.base.work.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.base.work.db.DBConn;
import com.base.work.dto.PlayerListResponseDto;
import com.base.work.model.Player;
import com.base.work.model.Product;
import com.base.work.model.Team;

public class BaseBallRepository {
	private static final String TAG = "ProductRepository : ";
	
	private static BaseBallRepository instance = new BaseBallRepository();
	private BaseBallRepository() {}
	
	public static BaseBallRepository getInstance() {
		return instance;
	}
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	
	public Player findById(int id) {
		final String SQL = "SELECT ID, TEAMID, UNIFORMNUMBER, NAME, POSITION FROM player WHERE id = ?";
		Player player = null;
		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				player = Player.builder()
						.id(rs.getInt("ID"))
						.teamId(rs.getInt("TEAMID"))
						.uniformNumber(rs.getInt("UNIFORMNUMBER"))
						.name(rs.getString("NAME"))
						.position(rs.getString("POSITION"))
						.build();
			}
			return player;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(conn, pstmt, rs);
		}
		return null;
	}
	
		
	public List<Team> findAll(){
		final String SQL = "SELECT ID, NAME FROM team";
		List<Team> teams =null;
		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			teams = new ArrayList<>();
			while(rs.next()) {
				Team team = Team.builder()
						.id(rs.getInt("ID"))
						.name(rs.getString("NAME"))
						.build();
				teams.add(team);
			}
			return teams;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(conn, pstmt, rs);
		}
		return null;
	}
	
	public List<PlayerListResponseDto> findAll(int teamId){
		StringBuffer sb = new StringBuffer();
		sb.append(" SELECT player.ID, player.TEAMID, player.UNIFORMNUMBER, "
				+ " player.NAME, player.POSITION , team.id, team.name ");
		sb.append(" FROM player INNER JOIN team ");
		sb.append(" ON team.id = player.teamid ");
		sb.append(" WHERE team.id = ?");
		final String SQL = sb.toString();
		List<PlayerListResponseDto> dtoLists =null;
		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, teamId);
			rs = pstmt.executeQuery();
			dtoLists = new ArrayList<>();
			while(rs.next()) {
				Player player = Player.builder()
						.id(rs.getInt(1))
						.teamId(rs.getInt(2))
						.uniformNumber(rs.getInt(3))
						.name(rs.getString(4))
						.position(rs.getString(5))
						.build();
				PlayerListResponseDto dto = PlayerListResponseDto.builder()
							.teamId(rs.getInt(6))
							.player(player)
							.build();
				dtoLists.add(dto);
			}
			return dtoLists;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(conn, pstmt, rs);
		}
		return null;
	}
	
}
