package com.liyi.shop.model;

import java.util.ArrayList;



public class Cart {
	private  ArrayList<CartItem> cartitems = new ArrayList<CartItem>() {

		private static final long serialVersionUID = 1L;

		@Override
		public boolean add(CartItem item) {
			for(CartItem cartitem : this) {
				if(cartitem.getProduct().equals(item.getProduct())) {
						cartitem.setQuantity(item.getQuantity() + cartitem.getQuantity());
							return true;
				}
			}	
			return super.add(item);
		}
	};
	
	public Cart() {

	}

	public ArrayList<CartItem> getCartitems() {
		return cartitems;
	}
	
	public double getTotal() {
		double total = 0;
		for(CartItem cartitem : cartitems) {
			total += cartitem.subTotal();
		}
		return total;
		
	}
	
	public double getTotalShippingFee() {
		double fee = 0;
		for(CartItem cartitem : cartitems) {
			fee += cartitem.subShipping();
		}
		return fee;
		
	}
	public double getSum() {
		double total = 0;
		double fee = 0;
		for(CartItem cartitem : cartitems) {
			total += cartitem.subTotal();
			fee += cartitem.subShipping();
		}
		return total + fee;
		
	}

}
