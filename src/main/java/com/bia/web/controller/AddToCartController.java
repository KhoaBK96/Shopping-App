package com.bia.web.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

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
	
	

	public class AddToCartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
		ProductRepository productRepo;
		ProductService productService;
		UserRepository userRepo;
		UserService userService;
		BillRepository billRepo;
		BillService billService;
  
    public AddToCartController() {
    	productRepo = new ProductRepository();
    	productService = new ProductService(productRepo);
    	userRepo = new UserRepository();
        userService = new UserService(userRepo);
        billRepo = new BillRepository();
        billService = new BillService(billRepo);  
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			addtocart(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	private void addtocart(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int addtocartID = NumberTools.parseIntWithFallback(request.getParameter("addtocartID"));
		
		HttpSession session = request.getSession(true);
		String email = (String) session.getAttribute("EMAIL");
		User user = userService.getUserByEmail(email);
									
		if(user == null) {
			response.sendRedirect(request.getContextPath()+"/Signin");
		}else {
			Product product = productService.getById(addtocartID);
			
			Bill bill = billService.getCurrentBill(user);
			if(bill == null) {
				bill = new Bill();
				bill.setUser(user);
				Date date = new Date(System.currentTimeMillis());
				bill.setDate(date);	
				billService.add(bill);
			}
			
			int billId = bill.getId();
			
			Bill fullBill = billService.getById(billId);
						
			BillDetail billDetail = new BillDetail();	
			
			billDetail.setBill(fullBill);
			
			bill.setUser(user);
			
			boolean existProduct = false;
			
			for(int i = 0; i< fullBill.getBillDetails().size(); i++) {
				if(fullBill.getBillDetails().get(i).getProduct().getId() == product.getId()) {	
					existProduct = true;
				} 												   
			} 
			if(existProduct == false) {
				billDetail.setProduct(product);
				billDetail.setProductQuantity(1);		
				billService.addBillDetail(billDetail);
			}			
			response.sendRedirect(request.getContextPath()+"/Shop");
		}
		
	}

}
