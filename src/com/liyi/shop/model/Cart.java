package com.liyi.shop.model;

import java.util.ArrayList;

public class Cart {
	private Item item;
	private Customer customer;
	private int quantity = 0;
	public static ArrayList<Cart> carts = new ArrayList<>();
	
	public Cart(Item item, Customer customer, int quantity) {
		this.item = item;
		this.customer = customer;
		this.quantity = quantity;
	}
	
	public Item getItem() {
		return item;
	}
	
	public Customer getCustomer() {
		return customer;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setItem(Item item) {
		this.item = item;
	}
	
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public Cart addCart(Item item, Customer customer, int quantity) {
		Cart cart = new Cart(item, customer, quantity);
		carts.add(cart);
		return cart;
	}
	
	public Cart delCart(int i) {
		return carts.remove(i) ;
	}
		
}
