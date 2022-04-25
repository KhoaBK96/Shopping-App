package com.bia.web.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bia.web.repository.BillRepository;
import com.bia.web.service.BillService;
import com.bia.web.utils.NumberTools;

/**
 * Servlet implementation class DeleteBillController
 */
public class DeleteBillController extends HttpServlet {
	private static final long serialVersionUID = 1L;
		BillRepository billRepo;
		BillService billService;
		
    public DeleteBillController() {
    	billRepo = new BillRepository();
        billService = new BillService(billRepo);    
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			deleteBill(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	private void deleteBill(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		
		int id = NumberTools.parseIntWithFallback(request.getParameter("ID"));
		
		billService.delete(id);
		
		response.sendRedirect(request.getContextPath()+"/BillList");
	}


}
