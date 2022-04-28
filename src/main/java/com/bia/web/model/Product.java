package com.bia.web.model;

public class Product {
	
	private int id;
	private String name;
	private double price;
	private String image;
	private Category category;
	
	public Product(int id, String name, double price, String image, Category category) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.image = image;
		this.category = category;
	}

	public Product(int id) {
		super();
		this.id = id;
	}

	public Product(String name, double price, String image, Category category) {
		super();

		this.name = name;
		this.price = price;
		this.image = image;
		this.category = category;
	}

	public Product(int id, String name, double price, String image) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.image = image;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}


	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", image=" + image
				+ "]";
	}

	
	
	
}
