package com.bia.web.dto;

import com.bia.web.model.Bill;

public class BillTotalDTO {
	
	private double total;
	
	private Bill bill;

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}
	
	
}
