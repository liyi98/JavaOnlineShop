package com.liyi.shop.model;

public class Manager extends Staff {
	
	
	public Manager(String name, String email, String password, String address1, String address2, String phone) {
		super(name, email, password, address1, address2, phone);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getRole() {
		// TODO Auto-generated method stub
		return ROLE_MANAGER;
	}

	
	
}
