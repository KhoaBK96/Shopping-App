package com.bia.web.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bia.web.model.User;

public class UserRepository implements IUserRepository {
	
	
	
	
	public void add(User object) throws SQLException {
		
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			connection = DbConnectProvide.getConnection();
			String sql = "Insert into user "
					+ "(name, email, password, deleted)"
					+ "values(?, ?, ?, 0)";
			statement = connection.prepareStatement(sql);
			statement.setString(1, object.getName());
			statement.setString(2, object.getEmail());
			statement.setString(3, object.getPassword());
			statement.execute();
		}finally {
			close(connection, statement, null);
		}
		
	}

	public List<User> getAll() throws SQLException {
		
		List<User> users = new ArrayList<>();
		Connection connection = null;
		Statement statement = null;
		ResultSet result = null;
		
		try {
			connection = DbConnectProvide.getConnection();
			String sql ="Select id, name, email from user where deleted=0";
			statement = connection.createStatement();
			result = statement.executeQuery(sql);
			while(result.next()) {
				int id = result.getInt("id");
				String name = result.getString("name");
				String email = result.getString("email");
				
				
				User user = new User(id, name, email);
				
				users.add(user);
			}
		}finally {
			close(connection, statement, result);
		}
		return users;
	}

	

	public User getById(int id) throws SQLException  {
		
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		User user = null;
		try {
			connection = DbConnectProvide.getConnection();
			String sql = "Select name, email, password from user where id=? and deleted=0";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			result = statement.executeQuery();
			if(result.next()) {
			String name = result.getString("name");
			String email = result.getString("email");
			String password = result.getString("password");
			
			user = new User(id, name, email, password);
			
			}
			
		}finally {
			close(connection, statement, result);
		}return user;
	}

	public void update(User object) throws SQLException {
		
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			connection = DbConnectProvide.getConnection();
			String sql = "Update user "
					+ "set name=?, email=?, password=? "
					+ "where id=? ";
			statement = connection.prepareStatement(sql);
			statement.setString(1, object.getName());
			statement.setString(2, object.getEmail());
			statement.setString(3, object.getPassword());
			statement.setInt(4, object.getId());
			statement.execute();
		}finally {
			close(connection, statement, null);
		}
		
	}

	public void delete(int id) throws SQLException {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = DbConnectProvide.getConnection();
			String sql = "Update user set deleted=1 where id=?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			statement.execute();
		}finally {
			close(connection, statement, null);
		}
		
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
