package com.liyi.shop.model;

import java.util.ArrayList;
import java.util.Random;

public class Order {
	private int orderID;
	private Customer customer;
	private ArrayList<OrderItem> orderitems = new ArrayList<>();

	
	public Order(Customer customer) {
		Random rand = new Random();
		this.customer = customer;
		for (CartItem item: customer.getCart().getCartitems()) {
			orderitems.add(new OrderItem(item.getProduct(), item.getQuantity()));
		}
		customer.getCart().getCartitems().clear();
		orderID = rand.nextInt(1000000) + 1;
	}
	
	public ArrayList<OrderItem> getAllOrderItem(){
		return orderitems;
	}
	
	public Customer getCustomer() {
		return customer;
	}
	
	public double getTotal() {
		double total = 0;
		for(OrderItem orderitem: orderitems) {
			total = orderitem.getSubtotal() + orderitem.getSubShippingFee();
		}
		return total;
	}
	
	public double getSum() {
		double sum = 0;
		double total = 0;
		for(OrderItem orderitem: orderitems) {
			total = orderitem.getSubtotal() + orderitem.getSubShippingFee();
			sum += total;
		}
		return sum;
	}

}
