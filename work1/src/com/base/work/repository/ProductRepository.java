package com.base.work.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.base.work.db.DBConn;
import com.base.work.model.Product;

public class ProductRepository {
	private static final String TAG = "ProductRepository : ";
	
	private static ProductRepository instance = new ProductRepository();
	private ProductRepository() {}
	
	public static ProductRepository getInstance() {
		return instance;
	}
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public int insertById(Product product) {
		final String SQL = "INSERT INTO product(id, name, type, price, count) "
				+ " VALUES(product_SEQ.NEXTVAL,?,?,?,0) ";
		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, product.getName());
			pstmt.setString(2, product.getType());
			pstmt.setInt(3, product.getPrice());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBConn.close(conn, pstmt);
		}
		return -1;
	}
	
	public int deleteById(int id) {
		final String SQL = "DELETE FROM product WHERE id = ?";
		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, id);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBConn.close(conn, pstmt);
		}
		return -1;
	}
	
	public List<Product> findAll(){
		final String SQL = "SELECT ID, NAME, TYPE, PRICE, COUNT FROM product";
		List<Product> products =null;
		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			products = new ArrayList<>();
			while(rs.next()) {
				Product product = Product.builder()
						.id(rs.getInt("ID"))
						.name(rs.getString("NAME"))
						.type(rs.getString("TYPE"))
						.price(rs.getInt("PRICE"))
						.count(rs.getInt("COUNT"))
						.build();
				products.add(product);
			}
			return products;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(conn, pstmt, rs);
		}
		return null;
	}
	
	public List<Product> findAllCountDesc(){
		final String SQL = "SELECT ID, NAME, TYPE, PRICE, COUNT"
				+ " FROM product ORDER BY COUNT DESC ";
		List<Product> products =null;
		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			
			products = new ArrayList<>();
			while(rs.next()) {
				Product product = Product.builder()
						.id(rs.getInt("ID"))
						.name(rs.getString("NAME"))
						.type(rs.getString("TYPE"))
						.price(rs.getInt("PRICE"))
						.count(rs.getInt("COUNT"))
						.build();
				products.add(product);
			}
			return products;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(conn, pstmt, rs);
		}
		return null;
	}
	
	public List<Product> findAllPriceDesc(){
		final String SQL = "SELECT ID, NAME, TYPE, PRICE, COUNT"
				+ " FROM product ORDER BY PRICE DESC ";
		List<Product> products =null;
		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			
			products = new ArrayList<>();
			while(rs.next()) {
				Product product = Product.builder()
						.id(rs.getInt("ID"))
						.name(rs.getString("NAME"))
						.type(rs.getString("TYPE"))
						.price(rs.getInt("PRICE"))
						.count(rs.getInt("COUNT"))
						.build();
				products.add(product);
			}
			return products;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(conn, pstmt, rs);
		}
		return null;
	}
}
