package com.bia.web.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bia.web.repository.ProductRepository;
import com.bia.web.service.ProductService;
import com.bia.web.utils.NumberTools;

/**
 * Servlet implementation class DeleteProductController
 */
public class DeleteProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;       
		ProductRepository productRepo;
	    ProductService productService;
    public DeleteProductController() {
    	productRepo = new ProductRepository();
        productService = new ProductService(productRepo);
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			deleteProduct(request, response);
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
	}


	private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = NumberTools.parseIntWithFallback(request.getParameter("ID"));
		
		productService.delete(id);
		
		response.sendRedirect(request.getContextPath()+"/ProductList");
		
	}



}
