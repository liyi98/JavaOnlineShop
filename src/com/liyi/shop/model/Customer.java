package com.liyi.shop.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import com.liyi.shop.Main;
import com.liyi.shop.activities.Template1;

public class Customer implements Serializable{

	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	private String email;
	private String password;
	private String gender;
	private String dob;
	private String address1;
	private String address2;
	private String phone;
	private String safeword;
	public static ArrayList<Customer> customers = new ArrayList<>();
	private ArrayList<Order> orders = new ArrayList<>();
	private Cart cart = new Cart();
	
	public Customer(){}
	
	public Customer(String name, String email, String password, String gender, String dob,String address1, String address2, String phone, String safeword){
		this.name = name;
		this.email = email;
		this.password = password;
		this.gender = gender;
		this.dob = dob;
		this.address1 = address1;
		this.address2 = address2;
		this.phone = phone;
		this.safeword = safeword;
		id = "C"+ ++Main.storageID.customerID + "VIP";
		Main.storageID.setCustomerID(Main.storageID.customerID);
		
	}
	
	public String getId() {
		return id;
	}
	
	public String getName() {
		return name; 
		
	}
	
	public Cart getCart() {
		return cart;
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
	
	public String getDob() {
		return dob;
	}
	
	public ArrayList<Order> getAllOrder(){
		return orders;
	}
	
	public Order addOrder(Order order) {
		orders.add(order);
		return order;

	}
	
	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public void setName(String name) {
		this.name = name;
		setSave();
	}
	
	public void setEmail(String email) {
		this.email = email;
		setSave();
	}
	
	public void setPassword(String password) {
		this.password = password;
		setSave();
	}
	
	public void setGender(String gender) {
		this.gender = gender;
		setSave();
	}
	
	public void setDob(String dob) {
		this.dob = dob;
		setSave();
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
		setSave();
	}
	
	public void setAddress2(String address2) {
		this.address2 = address2;
		setSave();
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
		setSave();
	}
	
	public void setSafeword(String safeword) {
		this.safeword = safeword;
		setSave();
	}

	public static void addCustomer(String name, String email, String password, String gender, String dob, String address1, String address2, String phone, String safeword){
		Customer c = new Customer(name, email, password, gender, dob, address1, address2, phone, safeword);
		customers.add(c);
		setSave();
		
	}

	public static void delCustomer(Customer customer){
		customers.remove(customer);
		setSave();
	}
	
	public void delOrder(Order order) {
		orders.remove(order);
	}
	
	public static boolean loginC(String email, String password) {
		for(Customer c : customers) {
			if(c.getEmail().equals(email) && c.getPassword().equals(password)){
				Template1.c = c;
				return true;
			}
		}
		return false;
	}
	
	public static String findPassword(String email, String safeword) {
		for(Customer c : customers) {
			if(c.getEmail().equals(email) && c.getSafeword().equals(safeword)){
				return c.getPassword();
			}
		}
		return null;
		
	}
	public static void setSave(){
		try {
			File f = new File("customer.tmp");
			FileOutputStream savefile = new FileOutputStream(f);
			ObjectOutputStream output = new ObjectOutputStream(savefile);
			output.writeObject(customers);
			output.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void setLoad(){
		try {
			FileInputStream loadfile = new FileInputStream("customer.tmp");
			ObjectInputStream input = new ObjectInputStream(loadfile);
			customers = (ArrayList<Customer>) input.readObject();
	
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
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
