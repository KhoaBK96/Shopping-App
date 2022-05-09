package com.bia.web.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SignoutController
 */
public class SignoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public SignoutController() {
 
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.removeAttribute("USER");
		session.removeAttribute("EMAIL");
		response.sendRedirect(request.getContextPath()+"/Home");
	}

	
	
}
