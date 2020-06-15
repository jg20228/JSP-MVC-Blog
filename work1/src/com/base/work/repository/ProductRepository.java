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
	
}
