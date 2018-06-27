package com.liyi.shop;
import com.liyi.shop.activities.*;
import com.liyi.shop.model.*;

public class Main {

	public static void main(String[] args) {
		//new ActivityCustomerLogin();
		// TODO Auto-generated method stub
		Customer c = new Customer();
		//Category women = new Category("Women");
		//women.addItem(new Item());

		Item.addItem("Summer Cozy Women" ,"C:\\Users\\addme\\Documents\\PhotoOnlineShop\\2013-new-hot-summer-fashion-cozy-women-clothes.jpg", 75.99, "", "women");
		Item.addItem("cfff" ,"C:\\Users\\addme\\Desktop\\Untitled-12.png", 5.99, "", "");
		Item.addItem("Summer -039s" ,"C:\\Users\\addme\\Documents\\PhotoOnlineShop\\2017-new-summer-women-039-s-clothing-high.jpg", 83.99, "", "women");
		Item.addItem("burgesr" , "C:\\Users\\addme\\Desktop\\Untitled-12.png",5.99, "", "");
		Item.addItem("cfffs" ,"C:\\Users\\addme\\Desktop\\Untitled-12.png", 5.99, "", "");
		Item.addItem("Navy Dress Tie" ,"C:\\Users\\addme\\Documents\\PhotoOnlineShop\\navy-dress-with-side-tie-120117-347-09-800x534.jpg", 99.99, "", "women");
		Item.addItem("burger" , "C:\\Users\\addme\\Desktop\\Untitled-12.png",5.99, "", "");
		Item.addItem("Fashion Tops Ruffles" ,"C:\\Users\\addme\\Documents\\PhotoOnlineShop\\new-2014-women-summer-fashion-tops-ruffles.jpg", 49.00, "", "women");
		Item.addItem("Outfit Navy Blues" ,"C:\\Users\\addme\\Documents\\PhotoOnlineShop\\womens-outfit-navy-blue-120117-344-03-800x534.jpg", 129.99, "", "women");
		Item.addItem("burger" , "C:\\Users\\addme\\Desktop\\Untitled-12.png",5.99, "", "");
		Item.addItem("Women Trench Coat" ,"C:\\Users\\addme\\Documents\\PhotoOnlineShop\\womens-trench-coat-120117-345-05-800x535.jpg", 88.99, "", "women");
		Customer.addCustomer("Hwi Li Yi", "liyi98","1","1","1", "1", "hi", "hh", "loveyou");
		Customer.addCustomer("Chow Khai Bin", "khaibin","1", "1", "1", "hi","hi", "hh", "ss");
		Customer.addCustomer("k", "1","j", "1","1", "hi", "hi", "hh", "ss");
		Customer.addCustomer("k", "1","j", "1","1", "hi", "hi", "hh", "11");
		new ActivityHomePage(null);
		for(int i = 0; i<Customer.customers.size();i++)
		{
			//System.out.println(Customer.customers.get(i).getName());
			//System.out.println(Customer.customers.get(i).getId());
		}
	
		for(int u = 0; u<Item.searchItemByName("b").size(); u++){
			//System.out.println(item.searchItemByName("b").get(u).getName());
		}



	}

}
