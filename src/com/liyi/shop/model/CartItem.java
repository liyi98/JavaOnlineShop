package com.liyi.shop.model;

import java.io.Serializable;


public class CartItem implements Serializable {

	private static final long serialVersionUID = 1L;
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
		Customer.setSave();
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
		Customer.setSave();
	}
	
	public double subTotal() {
		return quantity * product.getPrice() ;
	}
	
	public double subShipping() {
		return quantity * product.calShippingFee();
	}

}
