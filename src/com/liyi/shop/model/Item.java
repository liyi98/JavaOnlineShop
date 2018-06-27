package com.liyi.shop.model;

import java.util.ArrayList;

public class Item {
	private String id;
	private String name;
	private String photo;
	private Double price;
	private String description;
	private String type;
	private static int i = 1;
	public static ArrayList<Item> items = new ArrayList<>();
	
	public Item(){}
	public Item(String name, String photo, double price, String description, String type){
		this.name = name;
		this.photo = photo;
		this.price = price;
		this.description = description;
		this.type = type;
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
	
	public String getType() {
		return type;
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
	
	public void setType(String type) {
		this.type = type;
	}
	
	public static Item addItem(String name, String photo, Double price, String description, String type){
		Item i = new Item(name, photo, price, description, type);
		items.add(i);
		return i;
	}
	
	public Item delItem(int i){
		return items.remove(i);
	}
	
	
	public static ArrayList<Item> searchItemByName(String name){
		ArrayList<Item> itemss = new ArrayList<>();
		for(int i = 0; i<items.size();i++){		
			if(items.get(i).getName().matches(".*"+ name + ".*")){
				itemss.add(items.get(i));
			}
		}
		
		return itemss;
	}
}
