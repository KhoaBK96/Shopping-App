package com.bia.web.service;

import java.sql.SQLException;
import java.util.List;

import com.bia.web.model.User;
import com.bia.web.repository.UserRepository;

public class UserService implements IUserService {
	
	UserRepository userRepository;
	
	
	public UserService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public void add(User object) throws SQLException {
		userRepository.add(object);
		
	}

	@Override
	public List<User> getAll() throws SQLException {
		return userRepository.getAll();
	}

	@Override
	public User getById(int id) throws SQLException {
		return userRepository.getById(id);
	}

	@Override
	public void update(User object) throws SQLException {
		userRepository.update(object);
		
	}

	@Override
	public void delete(int id) throws SQLException {
		userRepository.delete(id);		
	}
	
}
