package com.liyi.shop.model;

import java.util.ArrayList;



public class Cart {
	private Product item;
	private Customer customer;
	private String quantity ;
	public static ArrayList<Cart> carts = new ArrayList<>();
	public Cart() {};
	public Cart(Product item, Customer customer, String quantity) {
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
	
	public String getQuantity() {
		return quantity;
	}
	
	public void setItem(Product item) {
		this.item = item;
	}
	
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public void setQuantity(String quantity) {
		this.quantity = quantity;
		
	}
	
	public void addCart(Product item, Customer customer, String quantity) {
		System.out.println(item);
		for(Cart cart: carts) {
			
		if(item.equals(cart.item)) {
				quantity+= cart.quantity;
			}
		}
		Cart cart = new Cart(item, customer, quantity);
		carts.add(cart);
	}

	public Cart delCart(int i) {
		return carts.remove(i) ;
	}
		
}
