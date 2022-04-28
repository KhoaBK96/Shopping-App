package com.bia.web.service;

import java.sql.SQLException;
import java.util.List;

import com.bia.web.dto.ShopDTO;
import com.bia.web.model.Product;
import com.bia.web.repository.ProductRepository;

public class ProductService implements IProductService {

	ProductRepository productRepository;
	
	

	public ProductService(ProductRepository productRepository) {
		super();
		this.productRepository = productRepository;
	}

	@Override
	public void add(Product object) throws SQLException {
		productRepository.add(object);
	}

	@Override
	public List<Product> getAll() throws SQLException {
		
		return productRepository.getAll();
	}

	@Override
	public Product getById(int id) throws SQLException {
		
		return productRepository.getById(id);
	}

	@Override
	public void update(Product object) throws SQLException {
		productRepository.update(object);
		
	}

	@Override
	public void delete(int id) throws SQLException {
		productRepository.delete(id);
	}
	
	public List<Product> showProduct(ShopDTO shopDTO) throws SQLException {
		return productRepository.showProduct(shopDTO);
	}
	
	
}
