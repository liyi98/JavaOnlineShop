package com.liyi.shop.model;

import java.util.ArrayList;

public class Category {
	String name;
	ArrayList<Item> items = new ArrayList<>();
	
	public Category(String name) {
		this.name = name;
	}
	

}
