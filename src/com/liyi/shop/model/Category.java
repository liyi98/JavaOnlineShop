package com.liyi.shop.model;

import java.io.Serializable;
import java.util.ArrayList;

import com.liyi.shop.Main;

public class Category implements Serializable {

	private static final long serialVersionUID = 1L;
	private String name;
	private ArrayList<Product> items = new ArrayList<>();
	
	public Category(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	
	public void addItem(Product item) {
		items.add(item);
		Main.setSave();
		
	}

	public ArrayList<Product> getAllItems() {
		return items;
	}
	
	public void delProduct(Product product) {
		items.remove(product);
		Main.setSave();
	}
	
	public ArrayList<Product> searchProducts(Category category, String query){
		ArrayList<Product> tmp = new ArrayList<>();
		for (Product product : category.getAllItems()) {
			if(product.getName().toLowerCase().contains(query.toLowerCase())) {
				tmp.add(product);
			}
		}
		return tmp;		
	}
}
