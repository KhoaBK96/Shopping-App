package com.bia.web.controller;

import java.io.IOException;
import java.sql.Date;
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
import com.bia.web.model.User;
import com.bia.web.repository.BillRepository;
import com.bia.web.repository.UserRepository;
import com.bia.web.service.BillService;
import com.bia.web.service.UserService;
import com.bia.web.utils.NumberTools;

/**
 * Servlet implementation class AddBillController
 */
public class AddBillController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
		BillRepository billRepo;
		BillService billService;
		UserRepository userRepo;
		UserService userService;
    public AddBillController() {
        billRepo = new BillRepository();
        billService = new BillService(billRepo);
        userRepo = new UserRepository();
        userService = new UserService(userRepo);
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			loadUser(request, response);
			loadBill(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/admin/add-bill.jsp");
		requestDispatcher.forward(request, response);
	}

	
	private void loadBill(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		int id = NumberTools.parseIntWithFallback(request.getParameter("ID"));
		Bill bill = billService.getById(id);
		
		request.setAttribute("UPDATE_BILL", bill);
	}


	private void loadUser(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		
		List<User> users = new ArrayList<>();
		
		users = userService.getAll();
		
		request.setAttribute("USER_LIST", users);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			addBill(request, response);
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		
	}


	private void addBill(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = NumberTools.parseIntWithFallback(request.getParameter("id"));
		int userId = NumberTools.parseIntWithFallback(request.getParameter("userId"));

		Date date = Date.valueOf(request.getParameter("date"));
		
		User user = new User(userId);
		
		List<BillDetail> billDetails = new ArrayList<>();
		
		Bill bill = new Bill(id, user, date, billDetails);
		
		if(id > 0 ) {
			billService.update(bill);
		}else {
			billService.add(bill);
		}
		
		response.sendRedirect(request.getContextPath()+"/BillList");
		
	}

}
