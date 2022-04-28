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

import com.bia.web.model.Category;
import com.bia.web.repository.CategoryRepository;
import com.bia.web.service.CategoryService;


public class CategoryListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	CategoryRepository categoryRepo;
	CategoryService categoryService;
	
    public CategoryListController() {
        categoryRepo = new CategoryRepository();
        categoryService = new CategoryService(categoryRepo);
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			listCategory(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/admin/category-admin.jsp");
		dispatcher.forward(request, response);
	}


	private void listCategory(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		
		List<Category> categories = new ArrayList<>();
		
		categories = categoryService.getAll();
		
		request.setAttribute("CATEGORY_LIST", categories);
		
	}

}
