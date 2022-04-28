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
import com.bia.web.model.Product;
import com.bia.web.repository.CategoryRepository;
import com.bia.web.repository.ProductRepository;
import com.bia.web.service.CategoryService;
import com.bia.web.service.ProductService;
import com.bia.web.utils.NumberTools;

/**
 * Servlet implementation class AddProductController
 */
public class AddProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    ProductRepository productRepo;
    ProductService productService;
	CategoryRepository categoryRepo;
	CategoryService categoryService;
    
    public AddProductController() {
        productRepo = new ProductRepository();
        productService = new ProductService(productRepo); 
        categoryRepo = new CategoryRepository();
        categoryService = new CategoryService(categoryRepo);
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			loadProduct(request, response);
			loadCategory(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/admin/add-product.jsp");
		requestDispatcher.forward(request, response);
	}

	
	private void loadProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		
		int id = NumberTools.parseIntWithFallback(request.getParameter("ID"));
		
		Product product = productService.getById(id);
		
		request.setAttribute("UPDATE_PRODUCT", product);
		
	}


	private void loadCategory(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		
		List<Category> categories = new ArrayList<>();
		
		categories = categoryService.getAll();
		
		request.setAttribute("CATEGORY_LIST", categories);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			addProduct(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	private void addProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		
		int id = NumberTools.parseIntWithFallback(request.getParameter("ID"));
		String name = request.getParameter("name");
		double price = Double.parseDouble(request.getParameter("price"));
		String image = request.getParameter("image");
		int categoryId = NumberTools.parseIntWithFallback(request.getParameter("categoryId"));
		
		Category category = categoryService.getById(categoryId);
		
		Product product = new Product(id, name, price, image, category);
		
		if(id>0) {
			productService.update(product);
		}else {
			productService.add(product);
		}
		
		response.sendRedirect(request.getContextPath()+"/ProductList");
	}

}
