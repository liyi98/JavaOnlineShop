package com.liyi.shop.model;

import java.util.ArrayList;

public class Product {
	private String id;
	private String name;
	private String photo;
	private Double price;
	private String description;
	private static int i = 1;
	
	public Product(String name, String photo, double price, String description){
		this.name = name;
		this.photo = photo;
		this.price = price;
		this.description = description;
		id = "I"+ i++ ;
	}
	
	public String getId(){
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getPhoto() {
		return photo;
	}
	
	public Double getPrice() {
		return price;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	

	
}
