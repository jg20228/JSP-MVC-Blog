package com.base.work.action.ver;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.base.work.action.Action;
import com.base.work.model.Product;
import com.base.work.repository.ProductRepository;
import com.base.work.util.Script;
import com.google.gson.Gson;

public class ProductPriceAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ProductRepository productRepository = ProductRepository.getInstance();
		List<Product> products = productRepository.findAllPriceDesc();
		Gson gson = new Gson();
		String productsJson = gson.toJson(products);
		Script.outJson(productsJson, response);
	}
}
