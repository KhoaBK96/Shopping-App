package com.bia.web.repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import com.bia.web.dto.BillTotalDTO;
import com.bia.web.model.Bill;
import com.bia.web.model.BillDetail;
import com.bia.web.model.Product;
import com.bia.web.model.User;

public class BillRepository implements IBillRepository {
	
	
	@Override
	public void add(Bill object) throws SQLException {
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			connection = DbConnectProvide.getConnection();
			String sql = "Insert into bill (userId, date) values(?, ?)";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, object.getUser().getId());
			statement.setDate(2, object.getDate());
			statement.execute();
		}finally {
			close(connection, statement, null);
		}
		
	}

	@Override
	public Collection<Bill> getAll() throws SQLException {
		Collection<Bill> bills = new ArrayList<>();
		Connection connection = null;
		Statement statement = null;
		ResultSet result = null;
		
		try {
			connection = DbConnectProvide.getConnection();
			String sql ="select b.id, b.userId, b.date, u.name, u.email, bd.productId, bd.productQuantity, bd.price from bill b "
					+ "inner join user u "
					+ "on b.userId = u.id "
					+ "left join billdetail bd "
					+ "on b.id = bd.billId "
					+ "where b.deleted=0";
			statement = connection.createStatement();
			result = statement.executeQuery(sql);
			HashMap<Integer, Bill> billMap = new HashMap<>(); // {}
			
			while(result.next()) {
				
				int id = result.getInt("id");
				Bill bill = null; 
				if(billMap.containsKey(id)) {
					bill = billMap.get(id);
				} else {
					bill = new Bill(id);
					Date date = result.getDate("date");
					bill.setDate(date);
					int userId = result.getInt("userId");
					String userName = result.getString("name");
					String userEmail = result.getString("email");
					
					User user = new User(userId, userName, userEmail);
					
					bill.setUser(user);
					
					billMap.put(id, bill);
				}
				
				
				int productId = result.getInt("productId");
				int productQuantity = result.getInt("productQuantity");
				double price = result.getDouble("price");
				
				
				if(productId != 0) {
				Product product = new Product(productId);
				
				
				BillDetail billDetail = new BillDetail(product, productQuantity, price);
				
				bill.addBillDetail(billDetail);
							
				}
				
			}
			bills.addAll(billMap.values());
		}finally {
			close(connection, statement, result);
		}
	
		return bills;
	}

	@Override
	public Bill getById(int id) throws SQLException {

		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		Bill bill = null;
		try {
			connection = DbConnectProvide.getConnection();
			String sql = "select b.id, b.userId, b.date, u.name, u.email, bd.productId, bd.productQuantity, bd.price from bill b\r\n"
					+ "inner join user u \r\n"
					+ "on b.userId = u.id\r\n"
					+ "left join billdetail bd\r\n"
					+ "on b.id = bd.billId\r\n "
					+ "where b.id=? and b.deleted=0";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			result = statement.executeQuery();
			
			while(result.next()) {
				if(bill == null) {
					Date date = result.getDate("date");
					
					int userId = result.getInt("userId");
					String name = result.getString("name");
					String email = result.getString("email");
					
					User user = new User(userId, name, email);
					
					bill = new Bill(id, user, date);
				}
				
				int productId = result.getInt("productId");
				if (productId != 0) {					
					int productQuantity = result.getInt("productQuantity");
					double price = result.getDouble("price");
					
					
					Product product = new Product(productId);
					
					BillDetail billDetail = new BillDetail(product, productQuantity, price);
					
					bill.addBillDetail(billDetail);
				}
			}
		}finally {
			close(connection, statement, result);
		}
		return bill;
	}

	@Override
	public void update(Bill object) throws SQLException {				
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			connection = DbConnectProvide.getConnection();
			String sql = "Update bill set userId=?, date=? where id=?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, object.getUser().getId());
			statement.setDate(2, object.getDate());
			statement.setInt(3, object.getId());
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
			String sql = "Update bill set deleted=1 where id=?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			statement.execute();
		}finally {
			close(connection, statement, null);
		}
	}
	
	public void addBillDetail(BillDetail billDetail) throws SQLException {
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			connection = DbConnectProvide.getConnection();
			String sql = "Insert into billdetail "
					+ "(billId, productId, productQuantity, price) "
					+ "values(?, ?, ?, ?)";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, billDetail.getBill().getId());
			statement.setInt(2, billDetail.getProduct().getId());
			statement.setInt(3, billDetail.getProductQuantity());
			statement.setDouble(4, billDetail.getPrice());
			statement.execute();
			
			Bill bill = billDetail.getBill();
			
			bill.addBillDetail(billDetail);
			
		}finally { 
			close(connection, statement, null);
		}
	}
	public void updateBillDetail(BillDetail billDetail) throws SQLException {
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			connection = DbConnectProvide.getConnection();
			String sql = "Update billdetail set productQuantity=? where billId=? and productId=?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, billDetail.getProductQuantity());
			statement.setInt(2, billDetail.getBill().getId());
			statement.setInt(3, billDetail.getProduct().getId());
			statement.execute();						
		}finally {
			close(connection, statement, null);
		}
	}
	public List<BillTotalDTO> getAllTotal() throws SQLException{
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		List<BillTotalDTO> billTotals = new ArrayList<>();
		try {
			connection = DbConnectProvide.getConnection();
			String sql = "select b.id, "
					+ "sum(bd.productQuantity*bd.price) AS total "
					+ "from bill b "
					+ "left join billdetail bd "
					+ "on b.id = bd.billId "
					+ "where b.deleted=0 "
					+ "group by b.id";
			statement = connection.prepareStatement(sql);
			result = statement.executeQuery();
			while(result.next()) {
				double total = result.getInt("total");
				int billId = result.getInt("id");
				
				Bill bill = getById(billId);
				
				BillTotalDTO billTotal = new BillTotalDTO(total, bill);
				
				billTotals.add(billTotal);			
			}
		}finally {
			close(connection, statement, null);
		}
		return billTotals;
		
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
