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


public class SignupController extends HttpServlet {
	private static final long serialVersionUID = 1L;
		UserRepository userRepo;
		UserService userService;
	   
    public SignupController() {
    	userRepo = new UserRepository();
        userService = new UserService(userRepo);
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/shop/signup.jsp");
		requestDispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String rePassword = request.getParameter("retypePassword");
		
		if(!password.equals(rePassword)) {
			int signUpFail = 0;
			request.setAttribute("sign_up_mess", signUpFail );
			request.getRequestDispatcher("WEB-INF/shop/signup.jsp").forward(request, response);
		} else {		
			try {
				User user = userService.getUserByEmail(email);
				if(user == null) {
					User signUpUser = new User(name, email, password);
					userService.add(signUpUser);
					response.sendRedirect(request.getContextPath()+"/Signin");
				} else {
					int emailExist = 0;
					request.setAttribute("emailExist", emailExist);
					request.getRequestDispatcher("WEB-INF/shop/signup.jsp").forward(request, response);
				}			
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
