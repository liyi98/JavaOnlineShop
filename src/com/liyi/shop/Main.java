package com.liyi.shop;
import javax.swing.JFrame;

import com.liyi.shop.activities.*;
import com.liyi.shop.model.*;

public class Main {
		public static Category women;
		public static Category men;
		private static Staff staff;

	public static void main(String[] args) {
		//new ActivityCustomerLogin();
		Customer c = new Customer();
		Admin a = new Admin();
		Staff.staffs.add(new Admin("s", "s" , "s", "", "",""));
		new ActivityAdminCustomer();
		System.out.println(staff.loginS("s", "s"));
		women = new Category("women");
	    men = new Category("men");
	    women.addItem(new Product("Summer Cozy Women" ,"C:\\Users\\addme\\Documents\\PhotoOnlineShop\\2013-new-hot-summer-fashion-cozy-women-clothes.jpg", 75.99, ""));
		men.addItem(new Product("cfff" ,"C:\\Users\\addme\\Desktop\\Untitled-12.png", 5.99, ""));
		women.addItem(new Product("Summer -039s" ,"C:\\Users\\addme\\Documents\\PhotoOnlineShop\\2017-new-summer-women-039-s-clothing-high.jpg", 83.99, ""));
		men.addItem(new Product("burgesr" , "C:\\Users\\addme\\Desktop\\Untitled-12.png",5.99, ""));
		men.addItem(new Product("burgesr" , "C:\\Users\\addme\\Desktop\\Untitled-12.png",5.99, ""));
		men.addItem(new Product("burgesr" , "C:\\Users\\addme\\Desktop\\Untitled-12.png",5.99, ""));
		men.addItem(new Product("burgesr" , "C:\\Users\\addme\\Desktop\\Untitled-12.png",5.99, ""));
		men.addItem(new Product("burgesr" , "C:\\Users\\addme\\Desktop\\Untitled-12.png",5.99, ""));
		//women.addItem(new Item("Navy Dress Tie" ,"C:\\Users\\addme\\Documents\\PhotoOnlineShop\\navy-dress-with-side-tie-120117-347-09-800x534.jpg", 99.99, "", "women"));
		//women.addItem(new Item("Fashion Tops Ruffles" ,"C:\\Users\\addme\\Documents\\PhotoOnlineShop\\new-2014-women-summer-fashion-tops-ruffles.jpg", 49.00, "", "women"));
		women.addItem(new Product("Outfit Navy Blues" ,"C:\\Users\\addme\\Documents\\PhotoOnlineShop\\womens-outfit-navy-blue-120117-344-03-800x534.jpg", 129.99, ""));
		women.addItem(new Product("Women Trench Coat" ,"C:\\Users\\addme\\Documents\\PhotoOnlineShop\\womens-trench-coat-120117-345-05-800x535.jpg", 88.99, ""));
		Customer.addCustomer("Hwi Li Yi", "liyi98","1","1","1", "1", "hi", "hh", "loveyou");
		Customer.addCustomer("Chow Khai Bin", "khaibin","1", "1", "1", "hi","hi", "hh", "ss");
		Customer.addCustomer("k", "1","j", "1","1", "hi", "hi", "hh", "ss");
		Customer.addCustomer("k", "1","j", "1","1", "hi", "hi", "hh", "11");
	
		System.out.println(women.getAllItems().size());
		new ActivityHomePage();
		System.out.println(Cart.carts.size());

		//for(int u = 0; u<Item.searchItemByName("b").size(); u++){
			//System.out.println(item.searchItemByName("b").get(u).getName());
		//}
	


	}

}
