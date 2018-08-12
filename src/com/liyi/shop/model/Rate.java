package com.liyi.shop.model;

import java.io.Serializable;

import com.liyi.shop.Main;

public class Rate implements Serializable{

	private static final long serialVersionUID = 1L;
	private double rate;
	private Customer customer;
	private Product product;
	
	public Rate(double rate, Customer customer, Product product) {
		this.rate = rate;
		this.customer = customer;
		this.product = product;
	}
	
	public double getRate() {
		return rate;
	}
	public Product getProduct() {
		return product;
	}
	
	public Customer getCustomer() {
		return customer;
	}
	
	public void setRate(double rate) {
		this.rate = rate;
		Main.setSave();
	}
	
	public void setCustomer(Customer customer) {
		this.customer = customer;
		Main.setSave();
	}
}
