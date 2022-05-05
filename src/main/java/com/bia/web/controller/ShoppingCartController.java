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


public class ShoppingCartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
		 BillRepository billRepo;
		 BillService billService;
		 ProductRepository productRepo;
		 ProductService productService;
		 UserRepository userRepo;
		 UserService userService;
    
    public ShoppingCartController() {
    	 billRepo = new BillRepository();
         billService = new BillService(billRepo);
         productRepo = new ProductRepository();
         productService = new ProductService(productRepo); 
         userRepo = new UserRepository();
         userService = new UserService(userRepo);
    }
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			showBillDetails(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/shop/shopping-cart.jsp");
		dispatcher.forward(request, response);
	}

	



	private void showBillDetails(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		List<BillDetail> billDetails = new ArrayList<>();
		
		HttpSession session = request.getSession(true);
		String email = (String) session.getAttribute("EMAIL");
		User user = userService.getUserByEmail(email);
		
		Bill bill = billService.getBill(user);
		
		int billId = bill.getId();
		
		bill = billService.getById(billId);
		
		billDetails = bill.getBillDetails();
		
		Product product = null;
		
		for(int i = 0; i < billDetails.size(); i++) {
			int productId = billDetails.get(i).getProduct().getId();
			product = productService.getById(productId);
			billDetails.get(i).setProduct(product);
		}
		
		request.setAttribute("BILLDETAIL_LIST", billDetails);
		
		
		
		double total = billService.getTotal(billId);
		
		request.setAttribute("TOTAL", total);
	}
}	