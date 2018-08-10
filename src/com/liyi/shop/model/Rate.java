package com.liyi.shop.model;

public class Rate {
	private int rate;
	private Customer customer;
	
	public Rate(int rate, Customer customer) {
		this.rate = rate;
		this.customer = customer;
	}
	
	public int getRate() {
		return rate;
	}
	
	public Customer getCustomer() {
		return customer;
	}
	
	public void setRate(int rate) {
		this.rate = rate;
	}
	
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}
