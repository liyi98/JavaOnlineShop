package com.liyi.shop.model;

public class OrderItem {
	private Product product;
	private int quantity;
	
	
	public OrderItem(Product product, int quantity) {
		this.product = product;
		this.quantity = quantity;
		
	}
	
	public Product getProduct() {
		return product;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	
	public double getSubtotal() {
		return quantity * product.getPrice();
	}
	
	public double getSubShippingFee() {
		return product.calShippingFee() * quantity;
	}
	

}
