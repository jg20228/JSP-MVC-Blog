package com.base.work.action.product;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.base.work.action.Action;
import com.base.work.model.Product;
import com.base.work.repository.ProductRepository;

public class ProductHomeAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			ProductRepository productRepository = ProductRepository.getInstance();
			List<Product> products = productRepository.findAll();
			
			request.setAttribute("products", products);
			RequestDispatcher dis = request.getRequestDispatcher("/product/Ver1.jsp");
			dis.forward(request, response);	
	}
}
