package com.liyi.shop.model;

import java.util.ArrayList;

public abstract class Product {
	protected static final int FRAGILE = 1;
	protected static final int NON_FRAGILE = 2;
	protected static final double FRAGILE_SHIPPING_FEE = 10.00;
	protected static final double NON_FRAGILE_SHIPPING_FEE = 8.00;
	private String id;
	private String name;
	private String photo;
	private double price;
	private String description;
	protected double weight;
	private int stock;
	private static int i = 1;
	private ArrayList<Rate> rates = new ArrayList<>();
	
	
	public Product(String name, String photo, double price, String description, double weight, int stock){
		this.name = name;
		this.photo = photo;
		this.price = price;
		this.description = description;
		this.weight = weight;
		this.stock = stock;
		id = "P"+ i++ ;
		rates.add(new Rate(0, null));
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
	
	public double getPrice() {
		return price;
	}
	
	public ArrayList<Rate> getRates() {
		return rates;
	}
	public double getAverageRate() {
		int i = 0;
		for(Rate rate : rates) {
			i += rate.getRate();
		}
		System.out.println(i);
		double averageRate = i / rates.size();
		System.out.println(averageRate);
		return averageRate;
	}
	public String getDescription() {
		return description;
	}
	
	public double getWeight() {
		return weight;
	}
	
	public int getStock() {
		return stock;
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
	
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	public void addRate(Rate rate) {
		rates.add(rate);
	}
	
	public double calShippingFee() {
		return 0.00;
	
	}
	
	public int getType() {
		return 0;
	}
}
