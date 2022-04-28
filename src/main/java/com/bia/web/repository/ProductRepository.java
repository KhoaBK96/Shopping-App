package com.bia.web.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bia.web.dto.ShopDTO;
import com.bia.web.model.Category;
import com.bia.web.model.Product;

public class ProductRepository implements IProductRepository {

	@Override
	public void add(Product object) throws SQLException {
		
		Connection connection = null;
		PreparedStatement statement = null;
		Product product = null;
		try {
			connection = DbConnectProvide.getConnection();
			String sql = "Insert into product "
					+ "( name, price, image, categoryId) "
					+ "values( ?, ?, ?, ?)";
			statement = connection.prepareStatement(sql);

			statement.setString(1, object.getName());
			statement.setDouble(2, object.getPrice());
			statement.setString(3, object.getImage());
			statement.setInt(4, object.getCategory().getId());
			statement.execute();
			
		}finally {
			
		}
	}

	@Override
	public List<Product> getAll() throws SQLException {
		List<Product> products = new ArrayList<>();
		Connection connection = null;
		Statement statement = null;
		ResultSet result = null;
		
		try {
			connection = DbConnectProvide.getConnection();
			String sql ="Select pr.id, pr.name, pr.price, pr.image, pr.categoryId, ct.name as categoryName "
					+ "from product pr "
					+ "inner join category ct "
					+ "on pr.categoryId = ct.id "
					+ "where pr.deleted=0";
			statement = connection.createStatement();
			result = statement.executeQuery(sql);
			while(result.next()) {
				int id = result.getInt("id");

				String name = result.getString("name");
				double price = result.getDouble("price");
				String image = result.getString("image");
				int categoryId = result.getInt("categoryId");
				String categoryName = result.getString("categoryName");
				
				Category category = new Category(categoryId, categoryName);
				
				Product product = new Product(id, name, price, image, category);
				
				products.add(product);
			}
		}finally {
			close(connection, statement, result);
		}
		return products;
	}

	@Override
	public Product getById(int id) throws SQLException {
		
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		Product product = null;
		try {
			connection = DbConnectProvide.getConnection();
			String sql = "Select name, price, image, categoryId from product where id=? and deleted=0";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			result = statement.executeQuery();
			
			if(result.next()) {

				String name = result.getString("name");
				double price = result.getDouble("price");
				String image = result.getString("image");
				int categoryId = result.getInt("categoryId");
				
				Category category = new Category(categoryId);
				
				product = new Product(id, name, price, image, category);
			}
		}finally {
			close(connection, statement, result);
		}
		return product;
	}

	@Override
	public void update(Product object) throws SQLException {
		
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			connection = DbConnectProvide.getConnection();
			String sql = "Update product "
					+ "set name=?, price=?, image=?, categoryId=? "
					+ "where id=?";
			statement = connection.prepareStatement(sql);

			statement.setString(1, object.getName());
			statement.setDouble(2, object.getPrice());
			statement.setString(3, object.getImage());
			statement.setInt(4, object.getCategory().getId());
			statement.setInt(5, object.getId());
			statement.execute();
					
		}finally {
			close(connection, statement, null);
		}
	}

	@Override
	public void delete(int id) throws SQLException {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = DbConnectProvide.getConnection();
			String sql = "Update product set deleted=1 where id=?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			statement.execute();
		}finally {
			close(connection, statement, null);
		}
		
	}
	
	public List<Product> showProduct(ShopDTO shopDTO) throws SQLException{
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		List<Product> products = new ArrayList<>();
		try {
			
			connection = DbConnectProvide.getConnection();
			String sql = "select p.id, p.name, p.price, p.image, p.categoryId, c.name as categoryName from product p join category c on p.categoryId = c.id "
					+ "[WHERE_CLAUSE] "
					+ "[ORDER_BY_CLAUSE] "
					+ "[LIMIT_CLAUSE]";
			List<String> whereConditions = new ArrayList<>();
			int categoryId = shopDTO.getCategoryId();
			
			if(categoryId > 0) {
				whereConditions.add("c.id="+categoryId);			
			}
			
			if(shopDTO.getProductSearch() != null && shopDTO.getProductSearch().trim() != "") {
				whereConditions.add("p.name like '%" + shopDTO.getProductSearch() + "%'");
			}
					
			if(whereConditions.size() == 0) {
				sql = sql.replace("[WHERE_CLAUSE]", "");
				
			} else {
				sql = sql.replace("[WHERE_CLAUSE]"," where " + String.join(" and ", whereConditions));					
			}
			
			String orderCondition = "";
			
			if(shopDTO.isSortType() == true) {
				orderCondition = "asc";
			}else {
				orderCondition = "desc";
			}
			
			if(orderCondition == "") {
				sql = sql.replace("[ORDER_BY_CLAUSE]","");
			} else {
				sql = sql.replace("[ORDER_BY_CLAUSE]", " order by price " + orderCondition);
			}
					
			sql = sql.replace("[LIMIT_CLAUSE]", "limit " + "9" + " offset " + getOffset(shopDTO.getPage(), 9) );
					
			// lay DTO va dat if cho string
			statement = connection.prepareStatement(sql);
			result = statement.executeQuery();
			
			while(result.next()) {
				
				int id = result.getInt("id");
				String name = result.getString("name");
				double price = result.getDouble("price");
				String image = result.getString("image");
				int categoryID = result.getInt("categoryId");
				
				Category category = new Category(categoryID);
						
				Product product = new Product(id, name, price , image);
				
				products.add(product);
			}
			
					
		}finally {
			close(connection, statement, result);
		}
				
		return products;
		
	}
	
	public int getTotalProduct(ShopDTO shopDTO) throws SQLException{
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		List<Product> products = new ArrayList<>();
		try {
			
			connection = DbConnectProvide.getConnection();
			String sql = "select count(p.id) as size  from product p join category c on p.categoryId = c.id "
					+ "[WHERE_CLAUSE] ";
			
			List<String> whereConditions = new ArrayList<>();
			int categoryId = shopDTO.getCategoryId();
			
			if(categoryId > 0) {
				whereConditions.add("c.id="+categoryId);			
			}
			
			if(shopDTO.getProductSearch() != null && shopDTO.getProductSearch().trim() != "") {
				whereConditions.add("p.name like '%" + shopDTO.getProductSearch() + "%'");
			}
					
			if(whereConditions.size() == 0) {
				sql = sql.replace("[WHERE_CLAUSE]", "");
				
			} else {
				sql = sql.replace("[WHERE_CLAUSE]"," where " + String.join(" and ", whereConditions));					
			}
			
			// lay DTO va dat if cho string
			statement = connection.prepareStatement(sql);
			result = statement.executeQuery();
			while(result.next()) {
				return result.getInt("size");
				
			}
							
		}finally {
			close(connection, statement, result);
		}
				
		return 0;
		
	}
	
	private int getOffset(int page, int itemPerPage) {
		if (page < 1) {
			page = 1;
		}		
		return itemPerPage * (page - 1);		
	}
	
	private void close(Connection connection, Statement statement, ResultSet result) throws SQLException {
		if(connection != null) {
			connection.close();
		}
		if(statement != null) {
			statement.close();
		}
		if(result != null) {
			result.close();
		}	
	}
	
	

}
