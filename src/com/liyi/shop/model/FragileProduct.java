package com.liyi.shop.model;

public class FragileProduct extends Product{

	public FragileProduct(String name, String photo, double price, String description, double weight, int stock) {
		super(name, photo, price, description, weight, stock);
		// TODO Auto-generated constructor stub
	}
	@Override
	public int getType() {
		return FRAGILE;
	}
	
	public double calShippingFee() {
		double fee = weight * FRAGILE_SHIPPING_FEE ;
		return fee;
		
		
	}
}
