package com.bia.web.model;

public class BillDetail {
	
	private Bill bill;
	private Product product;
	private int productQuantity;
	private double price;
	
	
	
	public BillDetail(Bill bill, Product product, int productQuantity, double price) {
		super();
		this.bill = bill;
		this.product = product;
		this.productQuantity = productQuantity;
		this.price = price;
	}

	public BillDetail(Product product, int productQuantity, double price) {
		super();
		this.product = product;
		this.productQuantity = productQuantity;
		this.price = price;
	}
	
	
	public BillDetail(Bill bill, Product product, int productQuantity) {
		super();
		this.bill = bill;
		this.product = product;
		this.productQuantity = productQuantity;
	}
	
	

	public BillDetail() {
		super();
	}

	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}


	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "BillDetail [product=" + product + ", productQuantity=" + productQuantity + ", price=" + price + "]";
	}
	
	
}
