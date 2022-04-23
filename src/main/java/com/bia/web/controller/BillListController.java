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
import com.bia.web.repository.BillRepository;
import com.bia.web.service.BillService;

/**
 * Servlet implementation class BillListController
 */
public class BillListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    BillRepository billRepo;
    BillService billService;
    public BillListController() {
        billRepo = new BillRepository();
        billService = new BillService(billRepo);
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			listBill(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/bill-admin.jsp");
		dispatcher.forward(request, response);
	}


	private void listBill(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		
		Collection<Bill> bills = new ArrayList<>();
		
		bills = billService.getAll();
		
		request.setAttribute("BILL_LIST", bills);
		
	}

}
