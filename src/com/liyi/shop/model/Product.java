package com.liyi.shop.model;

import java.io.Serializable;
import java.util.ArrayList;

import com.liyi.shop.Main;

public abstract class Product implements Serializable {
	
	private static final long serialVersionUID = 1L;
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
	private ArrayList<Rate> rates = new ArrayList<>();
	
	
	public Product(String name, String photo, double price, String description, double weight, int stock){
		this.name = name;
		this.photo = photo;
		this.price = price;
		this.description = description;
		this.weight = weight;
		this.stock = stock;
		id = "P"+ ++Main.storageID.productID ;
		Main.storageID.setProductID(Main.storageID.productID);
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
		double i = 0;
		for(Rate rate : rates) {
			i += rate.getRate();
		}
		double averageRate = i / rates.size();
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
		Main.setSave();
	}
	
	public void setPhoto(String photo) {
		this.photo = photo;
		Main.setSave();
	}

	public void setPrice(Double price) {
		this.price = price;
		Main.setSave();
	}
	
	public void setDescription(String description) {
		this.description = description;
		Main.setSave();
	}
	
	public void setWeight(double weight) {
		this.weight = weight;
		Main.setSave();
	}
	
	public void setStock(int stock) {
		this.stock = stock;
		Main.setSave();
	}
	
	public void addRate(Rate rate) {
		rates.add(rate);
		Main.setSave();
	}
	
	public void delRate(Rate rate) {
		rates.remove(rate);
		Main.setSave();
	}
	
	public double calShippingFee() {
		return 0.00;
	
	}
	
	public int getType() {
		return 0;
	}
}
