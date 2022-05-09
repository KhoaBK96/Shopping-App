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
import javax.servlet.http.HttpSession;

import com.bia.web.dto.ShopDTO;
import com.bia.web.model.Bill;
import com.bia.web.model.Category;
import com.bia.web.model.Page;
import com.bia.web.model.Product;
import com.bia.web.model.User;
import com.bia.web.repository.BillRepository;
import com.bia.web.repository.CategoryRepository;
import com.bia.web.repository.ProductRepository;
import com.bia.web.repository.UserRepository;
import com.bia.web.service.BillService;
import com.bia.web.service.CategoryService;
import com.bia.web.service.PaginationService;
import com.bia.web.service.ProductService;
import com.bia.web.service.UserService;
import com.bia.web.utils.NumberTools;

/**
 * Servlet implementation class ShopController
 */
public class ShopController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	CategoryRepository categoryRepo;
	CategoryService categoryService; 
	ProductRepository productRepo;
	ProductService productService;
	PaginationService paginationService;
	UserRepository userRepo;
	UserService userService;
	BillRepository billRepo;
	BillService billService;
    public ShopController() {
    	categoryRepo = new CategoryRepository();
        categoryService = new CategoryService(categoryRepo);
    	productRepo = new ProductRepository();
    	productService = new ProductService(productRepo);
    	paginationService = new PaginationService();
    	userRepo = new UserRepository();
        userService = new UserService(userRepo);
        billRepo = new BillRepository();
        billService = new BillService(billRepo);
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		try {
			listCategory(request, response);
			showProduct(request, response);
			showTotal(request, response);
	
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/shop/shop.jsp");
		dispatcher.forward(request, response);
	}

	private void showTotal(HttpServletRequest request, HttpServletResponse response) throws SQLException {
			HttpSession session = request.getSession(true);
			String email = (String) session.getAttribute("EMAIL");
			
			if(email != null) {
				User user = userService.getUserByEmail(email);
				
				Bill bill = billService.getCurrentBill(user);
				
				int billId = bill.getId();
				
				double total = billService.getTotal(billId);
				
				request.setAttribute("TOTAL", total);	
			}		
		}
		

	private void listCategory(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		List<Category> categories= new ArrayList<>();
		
		categories = categoryService.getAll();
		
		request.setAttribute("CATEGORY_LIST", categories);
	}

	private void showProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		
		int categoryId = NumberTools.parseIntWithFallback(request.getParameter("categoryID"));		
		String productSearch = request.getParameter("productSearch");		
		String orderBy = request.getParameter("orderby");
		int page = NumberTools.parseIntWithFallback(request.getParameter("page"));
			
		ShopDTO shopDTO = new ShopDTO();
		
		shopDTO.setCategoryId(categoryId);
		
		shopDTO.setProductSearch(productSearch);
		
		
		if(orderBy != null && orderBy.equals("asc")) {
			shopDTO.setSortType(true);
		} else {
			shopDTO.setSortType(false);
		}
		
		shopDTO.setPage(page);
		
		List<Page> pageTotal = new ArrayList<>();
		
		pageTotal = paginationService.pagination(shopDTO, 9);
		
		List<Product> products = new ArrayList<>();
		
		products = productService.showProduct(shopDTO);
		
		
		
		request.setAttribute("PRODUCT_LIST", products);
		
		request.setAttribute("SHOPDTO", shopDTO);
		
		request.setAttribute("PAGE_LIST", pageTotal);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
