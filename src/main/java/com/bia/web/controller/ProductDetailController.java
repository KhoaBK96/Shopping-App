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
import javax.servlet.http.HttpSession;

import com.bia.web.model.Bill;
import com.bia.web.model.BillDetail;
import com.bia.web.model.Product;
import com.bia.web.model.User;
import com.bia.web.repository.BillRepository;
import com.bia.web.repository.ProductRepository;
import com.bia.web.repository.UserRepository;
import com.bia.web.service.BillService;
import com.bia.web.service.ProductService;
import com.bia.web.service.UserService;
import com.bia.web.utils.NumberTools;

/**
 * Servlet implementation class ProductDetailController
 */
public class ProductDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 BillRepository billRepo;
	 BillService billService;
	 ProductRepository productRepo;
	 ProductService productService;
	 UserRepository userRepo;
	 UserService userService;
   
    public ProductDetailController() {
    	 billRepo = new BillRepository();
         billService = new BillService(billRepo);
         productRepo = new ProductRepository();
         productService = new ProductService(productRepo); 
         userRepo = new UserRepository();
         userService = new UserService(userRepo);
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			productDetail(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/shop/product-detail.jsp");
		dispatcher.forward(request, response);
	}

	
	


	private void productDetail(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		int productId = NumberTools.parseIntWithFallback(request.getParameter("productID"));
		
		Product product = productService.getById(productId);
		
		request.setAttribute("PRODUCT", product);
			
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
