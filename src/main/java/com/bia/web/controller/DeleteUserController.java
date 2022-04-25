package com.bia.web.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bia.web.repository.UserRepository;
import com.bia.web.service.UserService;
import com.bia.web.utils.NumberTools;

/**
 * Servlet implementation class DeleteUserController
 */
public class DeleteUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
		UserRepository userRepo;
		UserService userService;
   
    public DeleteUserController() {
    	userRepo = new UserRepository();
        userService = new UserService(userRepo);
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			deleteUser(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	



	private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = NumberTools.parseIntWithFallback(request.getParameter("ID"));
		
		userService.delete(id);
		
		response.sendRedirect(request.getContextPath()+"/UserList");
		
	}

}
