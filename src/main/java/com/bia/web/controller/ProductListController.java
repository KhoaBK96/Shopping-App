package com.bia.web.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bia.web.model.Product;
import com.bia.web.repository.ProductRepository;
import com.bia.web.service.ProductService;

/**
 * Servlet implementation class ProductListController
 */
public class ProductListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	ProductRepository productRepo;
	ProductService productService;
	
    public ProductListController() {
       
    	productRepo = new ProductRepository();
    	productService = new ProductService(productRepo);
    	
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			listProduct(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/product-admin.jsp");
		dispatcher.forward(request, response);
		
	}

	private void listProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException {

		List<Product> products = new ArrayList<>();
		
		products = productService.getAll();
		
		request.setAttribute("PRODUCT_LIST", products);
	}

	

}
