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
import com.liyi.shop.activities.Template2;

public abstract class Staff implements Serializable {

	private static final long serialVersionUID = 1L;
	public static final int ROLE_MANAGER = 1;
	public static final int ROLE_ADMIN = 2;
	private String id;
	private String name;
	private String email;
	private String password;
	private String address1;
	private String address2;
	private String phone;
	public static ArrayList<Staff> staffs =  new ArrayList<>();

	public Staff(String name, String email, String password, String address1, String address2, String phone){
		this.name = name;
		this.email = email;
		this.password = password;
		this.address1 = address1;
		this.address2 = address2;
		this.phone = phone;
		id = "M"+ ++Main.storageID.staffID ;
		Main.storageID.setStaffID(Main.storageID.staffID);
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
	public static Staff loginS(String email, String password) {
		for(Staff s : staffs) {
			if(s.getEmail().equals(email) && s.getPassword().equals(password)){
				Template2.staff = s;
				return s;
			}
		}
		return null;
	}
	public static void deleteStaff(Staff staff) {
		staffs.remove(staff);
		setSave();
	}
	
	public static void addStaff(Staff staff) {
		staffs.add(staff);
		setSave();
	}
	
	public static ArrayList<Staff> searchStaff(String query){
		ArrayList<Staff> tmp = new ArrayList<>();
		for(Staff staff: staffs) {
			if(staff.getName().contains(query) || staff.getId().contains(query) ) {
				tmp.add(staff);
			}
				
		}
		return tmp;
	}
	public static void setSave(){
		try {
			File f = new File("staff.tmp");
			FileOutputStream savefile = new FileOutputStream(f);
			ObjectOutputStream output = new ObjectOutputStream(savefile);
			output.writeObject(staffs);
			output.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void setLoad(){
		try {
			FileInputStream loadfile = new FileInputStream("staff.tmp");
			ObjectInputStream input = new ObjectInputStream(loadfile);
			staffs = (ArrayList<Staff>) input.readObject();
	
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public int getRole() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

	
}
