package com.liyi.shop.model;

import java.util.ArrayList;

public class Category {
	private String name;
	private ArrayList<Product> items = new ArrayList<>();
	
	public Category(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void addItem(Product item) {
		items.add(item);
	}

	public ArrayList<Product> getAllItems() {
		return items;
	}

}
