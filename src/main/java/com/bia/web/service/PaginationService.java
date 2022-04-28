package com.bia.web.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bia.web.dto.ShopDTO;
import com.bia.web.model.Page;
import com.bia.web.repository.ProductRepository;

public class PaginationService implements IPaginationService{
	
	ProductRepository productRepository = new ProductRepository();
		
	public List<Page> pagination(ShopDTO shopDto, int productPerPage) throws SQLException {
		
		List<Page> pageList = new ArrayList<>();
		int productTotal = productRepository.getTotalProduct(shopDto);
		int pageTotal = productTotal/productPerPage;
		int remainder = productTotal % productPerPage;
		
		if(remainder > 0) {
			pageTotal = pageTotal + 1;
		}		
		
		for(int i = 1; i <= pageTotal; i++ ) {
			Page page = new Page(i);
			pageList.add(page);
		}
		
		return pageList;
	}
	
	
	
	
	
}
