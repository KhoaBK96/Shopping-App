package com.bia.web.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bia.web.model.Category;
import com.bia.web.repository.CategoryRepository;
import com.bia.web.service.CategoryService;
import com.bia.web.utils.NumberTools;

/**
 * Servlet implementation class AddCategoryController
 */
public class AddCategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	CategoryRepository categoryRepo;
	CategoryService categoryService;
	
	
    public AddCategoryController() {
        categoryRepo = new CategoryRepository();
        categoryService = new CategoryService(categoryRepo);
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			loadCategory(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/add-category.jsp");
		requestDispatcher.forward(request, response);
	}


	private void loadCategory(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		
		int id = NumberTools.parseIntWithFallback(request.getParameter("ID"));
		
		Category category = categoryService.getById(id);
		
		request.setAttribute("UPDATE_CATEGORY", category);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			addCategory(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	private void addCategory(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		
		int id = NumberTools.parseIntWithFallback(request.getParameter("ID"));
		String name = request.getParameter("name");
		Category category = new Category(id, name);
		
		if(id >0) {
			categoryService.update(category);
		}else{
			categoryService.add(category);	
		}
		response.sendRedirect(request.getContextPath()+"/CategoryList");
	}

}
