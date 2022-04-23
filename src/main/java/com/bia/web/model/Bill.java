package com.bia.web.model;

import java.sql.Date;
import java.util.ArrayList;

import java.util.List;

public class Bill {
	
	private int id;
	private User user;
	private Date date;
	private List<BillDetail> billDetails = new ArrayList<>();
	
	public Bill(int id, User user, Date date, List<BillDetail> billDetails) {
		super();
		this.id = id;
		this.user = user;
		this.date = date;
		this.billDetails = billDetails;
	}
	
	
	public Bill(int id, User user, Date date) {
		this(id, user, date, new ArrayList<BillDetail>());
	}
	
	
	public Bill(int id) {
		super();
		this.id = id;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	
	public List<BillDetail> getBillDetails() {
		return billDetails;
	}

	public void setBillDetails(List<BillDetail> billDetails) {
		this.billDetails = billDetails;
	}
	
	public void addBillDetail(BillDetail billDetail) {
		if (this.billDetails == null) {
			this.billDetails = new ArrayList<BillDetail>();
		}
		this.billDetails.add(billDetail);
	}

	@Override
	public String toString() {
		return "Bill [id=" + id + ", date=" + date + "]";
	}

	
	
	
}
