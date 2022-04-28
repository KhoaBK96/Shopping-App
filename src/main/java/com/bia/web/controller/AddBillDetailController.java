package com.bia.web.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
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
 * Servlet implementation class AddBillDetailController
 */
public class AddBillDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;

		BillRepository billRepo;
		BillService billService;
		ProductRepository productRepo;
	    ProductService productService;
    public AddBillDetailController() {
    	billRepo = new BillRepository();
        billService = new BillService(billRepo);
        productRepo = new ProductRepository();
        productService = new ProductService(productRepo); 
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			loadBill(request, response);
			loadProduct(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/admin/add-bill-detail.jsp");
		requestDispatcher.forward(request, response);
	}

	
	private void loadProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		
		List<Product> products = new ArrayList<>();
		
		products = productService.getAll();
		
		request.setAttribute("PRODUCT_LIST", products);
		
	}


	private void loadBill(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		
		int billId = NumberTools.parseIntWithFallback(request.getParameter("id"));
	
		Bill bill = billService.getById(billId);
		
		request.setAttribute("UPDATE_BILL", bill);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			addBillDetail(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
	}

	private void addBillDetail(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int billId = NumberTools.parseIntWithFallback(request.getParameter("id"));
		int productId = NumberTools.parseIntWithFallback(request.getParameter("productId"));
		int productQuantity = NumberTools.parseIntWithFallback(request.getParameter("productQuantity"));
		
		Product product = productService.getById(productId);
				
		Bill bill = billService.getById(billId);
		
		BillDetail billDetail = new BillDetail(bill, product, productQuantity);
		
		List<BillDetail> billDetails = bill.getBillDetails();
		
		BillDetail exist = null;
		
		for(BillDetail bd : billDetails) {
			if(bd.getProduct().getId() == productId) {
				exist = bd;
				break;
			}
		}
		
		if(exist == null) {
			billService.addBillDetail(billDetail);
		}else {
			billService.updateBillDetail(billDetail);
		}
		response.sendRedirect(request.getContextPath()+"/BillDetail?ID="+ billId);
	}
}
