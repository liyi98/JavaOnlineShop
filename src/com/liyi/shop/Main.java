package com.liyi.shop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.liyi.shop.activities.ActivityHomePage;
import com.liyi.shop.model.Admin;
import com.liyi.shop.model.Category;
import com.liyi.shop.model.Customer;
import com.liyi.shop.model.NonFragileProduct;
import com.liyi.shop.model.Staff;

public class Main {
		public static Category women = new Category("women");
		public static Category men = new Category("men");
		public static StorageId storageID = new StorageId();

	public static void main(String[] args) {
		Customer.setLoad();
		Staff.setLoad();
	    setLoad();
		setSaveID();
	    
	/*	women.addItem(new NonFragileProduct("Summer Cozy Women" ,"C:\\Users\\addme\\Documents\\PhotoOnlineShop\\2013-new-hot-summer-fashion-cozy-women-clothes.jpg", 75.99, "Another interesting use of offscreen images is an automaticdouble buffering. This feature allows to avoid flicker in animated images by drawing an image to a back buffer and then copying that buffer onto the screen instead of drawing directly to the screen.", 0.5, 11));
		women.addItem(new NonFragileProduct("Summer -039s" ,"C:\\Users\\addme\\Documents\\PhotoOnlineShop\\2017-new-summer-women-039-s-clothing-high.jpg", 83.99, "", 0.5, 11));
		//women.addItem(new Item("Navy Dress Tie" ,"C:\\Users\\addme\\Documents\\PhotoOnlineShop\\navy-dress-with-side-tie-120117-347-09-800x534.jpg", 99.99, "", "women"));
		//women.addItem(new Item("Fashion Tops Ruffles" ,"C:\\Users\\addme\\Documents\\PhotoOnlineShop\\new-2014-women-summer-fashion-tops-ruffles.jpg", 49.00, "", "women"));
		women.addItem(new NonFragileProduct("Outfit Navy Blues" ,"C:\\Users\\addme\\Documents\\PhotoOnlineShop\\womens-outfit-navy-blue-120117-344-03-800x534.jpg", 129.99, "", 0.5, 44));
		women.addItem(new NonFragileProduct("Women Trench Coat" ,"C:\\Users\\addme\\Documents\\PhotoOnlineShop\\womens-trench-coat-120117-345-05-800x535.jpg", 88.99, "", 0.5, 44));
		Staff.addStaff(new Admin("12", "12", "12", "12","12", "12"));

	*/
		new ActivityHomePage();

	}
	
	
	public static void setSave(){
		try {
			File f = new File("women.tmp");
			FileOutputStream savefile = new FileOutputStream(f);
			ObjectOutputStream output = new ObjectOutputStream(savefile);
			output.writeObject(women);
			output.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			File f = new File("men.tmp");
			FileOutputStream savefile = new FileOutputStream(f);
			ObjectOutputStream output = new ObjectOutputStream(savefile);
			output.writeObject(men);
			output.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static void setSaveID() {	
		try {
			File f = new File("storageid.tmp");
			FileOutputStream savefile = new FileOutputStream(f);
			ObjectOutputStream output = new ObjectOutputStream(savefile);
			output.writeObject(storageID);
			output.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public static void setLoad(){
		try {
			FileInputStream loadfile = new FileInputStream("women.tmp");
			ObjectInputStream input = new ObjectInputStream(loadfile);
			women = (Category) input.readObject();
	
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			FileInputStream loadfile = new FileInputStream("men.tmp");
			ObjectInputStream input = new ObjectInputStream(loadfile);
			men = (Category) input.readObject();
	
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			FileInputStream loadfile = new FileInputStream("storageid.tmp");
			ObjectInputStream input = new ObjectInputStream(loadfile);
			storageID = (StorageId) input.readObject();
	
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	

}
