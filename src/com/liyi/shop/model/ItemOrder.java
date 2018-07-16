package com.liyi.shop.model;

import java.util.ArrayList;

public class ItemOrder {
	private Product item;
	private Customer customer;
	private int quantity = 0;
	public static ArrayList<ItemOrder> itemorders = new ArrayList<>();
	
	public ItemOrder(Product item, Customer customer, int quantity) {
		this.item = item;
		this.customer = customer;
		this.quantity = quantity;
	}
	
	public Product getItem() {
		return item;
	}
	
	public Customer getCustomer() {
		return customer;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setItem(Product item) {
		this.item = item;
	}
	
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public ItemOrder addItemOrder(Product item, Customer customer, int quantity) {
		ItemOrder i = new ItemOrder(item, customer, quantity);
		itemorders.add(i);
		return i;
	}
	
	public ItemOrder delItemOrder(int i) {
		return itemorders.remove(i) ;
	}

}
