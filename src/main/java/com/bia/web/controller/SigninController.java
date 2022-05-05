package com.bia.web.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bia.web.model.User;
import com.bia.web.repository.UserRepository;
import com.bia.web.service.UserService;

/**
 * Servlet implementation class SigninController
 */
public class SigninController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	UserRepository userRepo;
	UserService userService;
	 
    public SigninController() {
    	 userRepo = new UserRepository();
         userService = new UserService(userRepo);
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/shop/signin.jsp");
		requestDispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		
		try {
			signin(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
	}


	private void signin(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		User user = userService.userSignin(email, password);
		
		if(user == null) {
			int signInFail = 0;
			request.setAttribute("sign_in_mess", signInFail);
			request.getRequestDispatcher("WEB-INF/shop/signin.jsp").forward(request, response);
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("USER", user);
			session.setAttribute("EMAIL", email);
			response.sendRedirect(request.getContextPath()+"/Shop");
		}
	}

}
