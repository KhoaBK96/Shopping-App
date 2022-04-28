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

import com.bia.web.model.User;
import com.bia.web.repository.UserRepository;
import com.bia.web.service.UserService;

/**
 * Servlet implementation class UserListController
 */
public class UserListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    UserRepository userRepo;
    UserService userService;
    public UserListController() {
        userRepo = new UserRepository();
        userService = new UserService(userRepo);
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			listUser(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/admin/user-admin.jsp");
		dispatcher.forward(request, response);
		
	}

	private void listUser(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		
		List<User> users = new ArrayList<>();
		
		users = userService.getAll();
		
		request.setAttribute("USER_LIST", users);
		
	}

}
