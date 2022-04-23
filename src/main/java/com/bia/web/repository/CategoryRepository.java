package com.bia.web.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bia.web.model.Category;

public class CategoryRepository implements ICategoryRepository {

	@Override
	public void add(Category object) throws SQLException {
		
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			connection = DbConnectProvide.getConnection();
			String sql = "Insert into category "
					+ "(name) "
					+ "values(?)";
			statement = connection.prepareStatement(sql);
			statement.setString(1, object.getName());
			statement.execute();
			
		}finally {
			close(connection, statement, null);
		}
		
	}

	@Override
	public List<Category> getAll() throws SQLException {
		List<Category> categories = new ArrayList<>();
		Connection connection = null;
		Statement statement = null;
		ResultSet result = null;
		
		try {
			connection = DbConnectProvide.getConnection();
			String sql ="Select id, name from category";
			statement = connection.createStatement();
			result = statement.executeQuery(sql);
			while(result.next()) {
				int id = result.getInt("id");
				String name = result.getString("name");
				
				
				Category category = new Category(id, name);
				
				categories.add(category);
			}
		}finally {
			close(connection, statement, result);
		}
		return categories;
	}

	@Override
	public Category getById(int id) throws SQLException{
		
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		Category category = null;
		try {
			connection = DbConnectProvide.getConnection();
			String sql = "Select name from category where id=?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			result = statement.executeQuery();
			if(result.next()) {
				String name = result.getString("name");
				
				category = new Category(id,name);
			}
		}finally {
			close(connection, statement, result);
		}
		return category;
	}

	@Override
	public void update(Category object) throws SQLException {
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			connection = DbConnectProvide.getConnection();
			String sql = "Update category "
					+ "set name=? "
					+ "where id=?";
			statement = connection.prepareStatement(sql);
			statement.setString(1, object.getName());
			statement.setInt(2, object.getId());
			statement.execute();
					
		}finally {
			close(connection, statement, null);
		}
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
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
