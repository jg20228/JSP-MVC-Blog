package com.base.work.action.ver2;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.base.work.action.Action;
import com.base.work.model.Product;
import com.base.work.repository.ProductRepository;
import com.base.work.util.Script;
import com.google.gson.Gson;

public class ProductInsertProcAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BufferedReader br = request.getReader();
		StringBuffer sb = new StringBuffer();
		String input = null;
		while((input = br.readLine())!=null) {
			sb.append(input);
		}
		Gson gson = new Gson();
		Product product = gson.fromJson(sb.toString(), Product.class);
		
		ProductRepository productRepository = ProductRepository.getInstance();
		int result = productRepository.insertById(product);
		Script.outJson(result+"", response);
	}
}
