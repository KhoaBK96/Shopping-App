package com.bia.web.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bia.web.model.Bill;
import com.bia.web.model.User;
import com.bia.web.repository.BillRepository;
import com.bia.web.repository.ProductRepository;
import com.bia.web.repository.UserRepository;
import com.bia.web.service.BillService;
import com.bia.web.service.ProductService;
import com.bia.web.service.UserService;

/**
 * Servlet implementation class HomeController
 */
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 BillRepository billRepo;
	 BillService billService;
	 ProductRepository productRepo;
	 ProductService productService;
	 UserRepository userRepo;
	 UserService userService;
	  public HomeController() {
	    	 billRepo = new BillRepository();
	         billService = new BillService(billRepo);
	         productRepo = new ProductRepository();
	         productService = new ProductService(productRepo); 
	         userRepo = new UserRepository();
	         userService = new UserService(userRepo);
	    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			showTotal(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/shop/index.jsp");
		dispatcher.forward(request, response);
	}

	
	private void showTotal(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		HttpSession session = request.getSession(true);
		String email = (String) session.getAttribute("EMAIL");
		
		if(email != null) {
			User user = userService.getUserByEmail(email);
			
			Bill bill = billService.getCurrentBill(user);
			
			int billId = bill.getId();
			
			double total = billService.getTotal(billId);
			
			request.setAttribute("TOTAL", total);	
		}		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
