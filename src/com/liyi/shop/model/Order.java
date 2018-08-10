package com.liyi.shop.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class Order {
	private int orderID;
	private Customer customer;
	private String status;
	private LocalDate date = LocalDate.now();
	private ArrayList<OrderItem> orderitems = new ArrayList<>();

	
	public Order(Customer customer, String status) {
		Random rand = new Random();
		this.customer = customer;
		this.status = status;
		for (CartItem item: customer.getCart().getCartitems()) {
			orderitems.add(new OrderItem(item.getProduct(), item.getQuantity()));
			int newStock = item.getProduct().getStock() - item.getQuantity();
			item.getProduct().setStock(newStock);
		}
		customer.getCart().getCartitems().clear();
		orderID = rand.nextInt(1000000000) + 1;
	}
	
	public ArrayList<OrderItem> getAllOrderItem(){
		return orderitems;
	}
	
	public int getOrderID() {
		return orderID;
	}
	
	public Customer getCustomer() {
		return customer;
	}
	
	public String getStatus() {
		return status;
	}
	
	public LocalDate getDate() {
		return date;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	public double getTotal() {
		double total = 0;
		for(OrderItem orderitem: orderitems) {
			total += orderitem.getSubtotal();
		}
		return total;
	}
	
	public double getTotalShippingFee() {
		double fee = 0;
		for(OrderItem orderitem : orderitems) {
			fee += orderitem.getSubShippingFee();
		}
		return fee;
		
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
