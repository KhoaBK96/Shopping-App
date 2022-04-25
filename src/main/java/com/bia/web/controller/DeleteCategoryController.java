package com.bia.web.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bia.web.repository.CategoryRepository;
import com.bia.web.service.CategoryService;
import com.bia.web.utils.NumberTools;

/**
 * Servlet implementation class DeleteCategoryController
 */
public class DeleteCategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
		CategoryRepository categoryRepo;
		CategoryService categoryService;
    public DeleteCategoryController() {
    	categoryRepo = new CategoryRepository();
        categoryService = new CategoryService(categoryRepo);
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			deleteCategory(request, response);
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
	}


	private void deleteCategory(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
		int id = NumberTools.parseIntWithFallback(request.getParameter("ID"));
		
		categoryService.delete(id);
		
		response.sendRedirect(request.getContextPath()+"/CategoryList");
		
	}

	

}
