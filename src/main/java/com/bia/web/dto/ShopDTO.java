package com.bia.web.dto;

import com.bia.web.model.Category;
import com.bia.web.model.Product;

public class ShopDTO {
	
	int  categoryId;
	
	private String productSearch;
	
	private boolean sortType;
	
	private int page;

	public ShopDTO() {
		super();
	}

	public ShopDTO(int categoryId, String productSearch) {
		super();
		this.categoryId = categoryId;
		this.productSearch = productSearch;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	
	public String getProductSearch() {
		return productSearch;
	}

	public void setProductSearch(String productSearch) {
		this.productSearch = productSearch;
	}

	public boolean isSortType() {
		return sortType;
	}

	public void setSortType(boolean sortType) {
		this.sortType = sortType;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}
	
	
}
