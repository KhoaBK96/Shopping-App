package com.bia.web.repository;

import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import com.bia.web.model.Bill;

public interface IRepository<E> {
	
	public void add(E object) throws SQLException;
	
	public Collection<E> getAll() throws SQLException;
	
	public E getById(int id) throws SQLException;
	
	public void update(E object) throws SQLException;
	
	public void delete(int id) throws SQLException;
}
