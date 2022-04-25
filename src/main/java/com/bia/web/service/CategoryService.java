package com.bia.web.service;

import java.sql.SQLException;
import java.util.List;

import com.bia.web.model.Category;
import com.bia.web.repository.CategoryRepository;

public class CategoryService implements ICategoryService {
	
	CategoryRepository categoryRepository;
	
	
	public CategoryService(CategoryRepository categoryRepository) {
		super();
		this.categoryRepository = categoryRepository;
	}

	@Override
	public void add(Category object) throws SQLException {
		categoryRepository.add(object);
		
	}

	@Override
	public List<Category> getAll() throws SQLException {
		return categoryRepository.getAll();
	}

	@Override
	public Category getById(int id) throws SQLException {
		return categoryRepository.getById(id);
	}

	@Override
	public void update(Category object) throws SQLException {
		categoryRepository.update(object);
		
	}

	@Override
	public void delete(int id) throws SQLException {
		categoryRepository.delete(id);
		
	}
	
	
}
