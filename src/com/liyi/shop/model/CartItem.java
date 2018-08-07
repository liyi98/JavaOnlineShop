package com.liyi.shop.model;

import java.util.ArrayList;

public class CartItem {
	private Product product;
	private int quantity;

	public CartItem(Product product, int quantity) {
		this.product = product;
		this.quantity = quantity;	
	}

	public Product getProduct() {
		return product;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setProduct(Product product) {
		this.product = product;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public double subTotal() {
		return quantity * product.getPrice() ;
	}
	
	public double subShipping() {
		return quantity * product.calShippingFee();
	}

}
