package com.base.work.action.product;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.base.work.action.Action;
import com.base.work.model.Product;
import com.base.work.repository.ProductRepository;
import com.google.gson.Gson;

public class ProductSortAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String sort = request.getParameter("sort");
		ProductRepository productRepository = ProductRepository.getInstance();
		List<Product> products = productRepository.findAll(sort);
		Gson gson = new Gson();
		try {
			String productsJson = gson.toJson(products);
			response.setCharacterEncoding("utf-8");
			response.setContentType("application/json; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.print(productsJson);
			
		} catch (Exception e) {
		}
	}
}
