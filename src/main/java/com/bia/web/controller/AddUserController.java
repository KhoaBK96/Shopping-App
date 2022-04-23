package com.bia.web.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bia.web.model.User;
import com.bia.web.repository.UserRepository;
import com.bia.web.service.UserService;
import com.bia.web.utils.NumberTools;

/**
 * Servlet implementation class AddUserController
 */
public class AddUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	 UserRepository userRepo;
	    UserService userService;
	
    public AddUserController() {
    	 userRepo = new UserRepository();
         userService = new UserService(userRepo);
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			loadUser(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/add-user.jsp");
		requestDispatcher.forward(request, response);
	}

	
	
	private void loadUser(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		int id = NumberTools.parseIntWithFallback(request.getParameter("ID"));
		
		User user = new User();
		if(id > 0) {
		user = userService.getById(id);
		}
		request.setAttribute("UPDATE_USER", user);		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			addUser(request,response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	private void addUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		
		int id = NumberTools.parseIntWithFallback(request.getParameter("ID"));
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		User user = new User(id, name, email, password);
		
		if(id >0) {
			userService.update(user);
		}else {
			userService.add(user);
		}
		response.sendRedirect(request.getContextPath()+"/UserList");
		
	}

}
