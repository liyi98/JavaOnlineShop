package com.liyi.shop.model;

import java.util.ArrayList;

import com.liyi.shop.activities.Template1;
import com.liyi.shop.activities.Template2;

public abstract class Staff {
	public static final int ROLE_MANAGER = 1;
	public static final int ROLE_ADMIN = 2;
	private String id;
	private String name;
	private String email;
	private String password;
	private String address1;
	private String address2;
	private String phone;
	private static int i = 1;
	public static ArrayList<Staff> staffs =  new ArrayList<>();
	public Staff() {};
	public Staff(String name, String email, String password, String address1, String address2, String phone){
		this.name = name;
		this.email = email;
		this.password = password;
		this.address1 = address1;
		this.address2 = address2;
		this.phone = phone;
		id = "M"+ i++ ;
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
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setPassword(String password) {
		this.password = password;
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
	public boolean loginS(String email, String password) {
		for(Staff s : staffs) {
			if(s.getEmail().equals(email) && s.getPassword().equals(password)){
				System.out.println("hi");
				Template2.staff = s;
				return true;
			}
		}
		return false;
	}
	
	public int getRole() {
		// TODO Auto-generated method stub
		return 0;
	}
	

	
}
