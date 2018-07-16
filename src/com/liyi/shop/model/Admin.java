package com.liyi.shop.model;

public class Admin extends Staff {

	public Admin(String name, String email, String password, String address1, String address2, String phone) {
		super(name, email, password, address1, address2, phone);
		// TODO Auto-generated constructor stub
	}



	public Admin() {
		// TODO Auto-generated constructor stub
	}

	public static void addManager(String name, String email, String password, String address1, String address2, String phone) {
		Manager m  = new Manager(name, email, password, address1, address2, phone);
		staffs.add(m);
	}

	public void delManager(int i){
		staffs.remove(i);
	}
	
	@Override
	public int getRole() {
		// TODO Auto-generated method stub
		return ROLE_ADMIN;
	}


	
	
}
