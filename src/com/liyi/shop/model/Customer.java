package com.liyi.shop.model;

import java.util.ArrayList;

import com.liyi.shop.activities.ActivityHomePage;
import com.liyi.shop.activities.Template1;

public class Customer {
	private String id;
	private String name;
	private String email;
	private String password;
	private String gender;
	private String bod;
	private String address1;
	private String address2;
	private String phone;
	private String safeword;
	private static int i = 1;
	public static ArrayList<Customer> customers = new ArrayList<>();
	
	public Customer(){}
	
	public Customer(String name, String email, String password, String gender, String bod,String address1, String address2, String phone, String safeword){
		this.name = name;
		this.email = email;
		this.password = password;
		this.gender = gender;
		this.bod = bod;
		this.address1 = address1;
		this.address2 = address2;
		this.phone = phone;
		this.safeword = safeword;
		id = "C"+ i++ + "VIP";
	   
	}
	
	public String getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getAddress1() {
		return address1;
	}
	
	public String getAddress2() {
		return address2;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public String getSafeword() {
		return safeword;
	}
	
	public String getGender() {
		return gender;
	}
	
	public String getBod() {
		return bod;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public void setBod(String bod) {
		this.bod = bod;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public void setSafeword(String safeword) {
		this.safeword = safeword;
	}
	
	public static Customer addCustomer(String name, String email, String password, String gender, String bod, String address1, String address2, String phone, String safeword){
		Customer c = new Customer(name, email, password, gender, bod, address1, address2, phone, safeword);
		customers.add(c);
		return c;
	}

	public static void delCustomer(int i){
		customers.remove(i);
	}
	
	public static boolean loginC(String email, String password) {
		for(Customer c : customers) {
			if(c.getEmail().equals(email) && c.getPassword().equals(password)){
				System.out.println("hi");
				Template1.c = c;
				return true;
			}
		}
		return false;
	}
	
	public String findPassword(String email, String safeword) {
		for(Customer c : customers) {
			if(c.getEmail().equals(email) && c.getSafeword().equals(safeword)){
				return c.getPassword();
			}
		}
		return null;
		
	}
	
	public static ArrayList<Customer> searchCustomer(String query) {
		ArrayList<Customer> tmp = new ArrayList<>();
		for (Customer customer : customers) {
			if (customer.name.contains(query) || customer.email.contains(query)) {
				tmp.add(customer);
			}
		}
		return tmp;
	}
	
}
