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

import com.bia.web.model.Bill;
import com.bia.web.model.BillDetail;
import com.bia.web.model.Product;
import com.bia.web.repository.BillRepository;
import com.bia.web.repository.ProductRepository;
import com.bia.web.service.BillService;
import com.bia.web.service.ProductService;
import com.bia.web.utils.NumberTools;

/**
 * Servlet implementation class BillDetailController
 */
public class BillDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	 BillRepository billRepo;
	 BillService billService;
	 ProductRepository productRepo;
	 ProductService productService;
    public BillDetailController() {
    	  billRepo = new BillRepository();
          billService = new BillService(billRepo);
          productRepo = new ProductRepository();
          productService = new ProductService(productRepo); 
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			listBill(request, response);
			listBillDetail(request, response);
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/bill-detail.jsp");
		dispatcher.forward(request, response);
	}

	
	private void listBill(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		
		int id = NumberTools.parseIntWithFallback(request.getParameter("ID"));
		
		Bill bill = billService.getById(id);
		
		request.setAttribute("BILL", bill);
		
	}


	private void listBillDetail(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		
		List<BillDetail> billDetails = new ArrayList<>();
		
		int id = NumberTools.parseIntWithFallback(request.getParameter("ID"));
		
		Bill bill = billService.getById(id);
		
		billDetails = bill.getBillDetails();
		
		Product product = null;
		
		for(int i = 0; i < billDetails.size(); i++) {
			int productId = billDetails.get(i).getProduct().getId();
			product = productService.getById(productId);
			billDetails.get(i).setProduct(product);
		}
		
		request.setAttribute("BILLDETAIL_LIST", billDetails);
		
	}


}
