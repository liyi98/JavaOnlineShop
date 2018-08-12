package com.liyi.shop;

import java.io.Serializable;

public class StorageId implements Serializable {

	private static final long serialVersionUID = 1L;
	public int customerID = 0;
	public int productID = 0;
	public int staffID = 0;
	
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
		Main.setSaveID();
	}
	public void setProductID(int productID) {
		this.productID = productID;
		Main.setSaveID();
	}
	public void setStaffID(int staffID) {
		this.staffID = staffID;
		Main.setSaveID();
	}
	
	
}
