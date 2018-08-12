package com.liyi.shop.model;

public class NonFragileProduct extends Product {

	private static final long serialVersionUID = 1L;

	public NonFragileProduct(String name, String photo, double price, String description, double weight, int stock) {
		super(name, photo, price, description, weight, stock);
		// TODO Auto-generated constructor stub
	}
	@Override
	public int getType() {
		return NON_FRAGILE;
	}
	
	public double calShippingFee() {
		double fee = weight * NON_FRAGILE_SHIPPING_FEE ;
		return fee;
		
		
	}
}
