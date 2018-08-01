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
		Staff.staffs.add(new Admin("s", "s" , "s", "", "",""));
		Staff.staffs.add(new Manager("12", "12" , "12", "", "",""));
		women = new Category("women");
	    men = new Category("men");
	    women.addItem(new NonFragileProduct("Summer Cozy Women" ,"C:\\Users\\addme\\Documents\\PhotoOnlineShop\\2013-new-hot-summer-fashion-cozy-women-clothes.jpg", 75.99, "Another interesting use of offscreen images is an automaticdouble buffering. This feature allows to avoid flicker in animated images by drawing an image to a back buffer and then copying that buffer onto the screen instead of drawing directly to the screen.", 0.5, 11));
		men.addItem(new NonFragileProduct("cfff" ,"C:\\Users\\addme\\Desktop\\Untitled-12.png", 5.99, "",1.1, 50));
		women.addItem(new NonFragileProduct("Summer -039s" ,"C:\\Users\\addme\\Documents\\PhotoOnlineShop\\2017-new-summer-women-039-s-clothing-high.jpg", 83.99, "", 0.5, 11));
		men.addItem(new NonFragileProduct("burgesr" , "C:\\Users\\addme\\Desktop\\Untitled-12.png",5.99, "", 0.8, 50));
		men.addItem(new NonFragileProduct("burgesr" , "C:\\Users\\addme\\Desktop\\Untitled-12.png",5.99, "", 0.8, 60));
		men.addItem(new NonFragileProduct("burgesr" , "C:\\Users\\addme\\Desktop\\Untitled-12.png",5.99, "", 0.8, 55));
		men.addItem(new NonFragileProduct("burgesr" , "C:\\Users\\addme\\Desktop\\Untitled-12.png",5.99, "",0.8, 50));
		men.addItem(new NonFragileProduct("burgesr" , "C:\\Users\\addme\\Desktop\\Untitled-12.png",5.99, "", 1.0, 40));
		//women.addItem(new Item("Navy Dress Tie" ,"C:\\Users\\addme\\Documents\\PhotoOnlineShop\\navy-dress-with-side-tie-120117-347-09-800x534.jpg", 99.99, "", "women"));
		//women.addItem(new Item("Fashion Tops Ruffles" ,"C:\\Users\\addme\\Documents\\PhotoOnlineShop\\new-2014-women-summer-fashion-tops-ruffles.jpg", 49.00, "", "women"));
		women.addItem(new NonFragileProduct("Outfit Navy Blues" ,"C:\\Users\\addme\\Documents\\PhotoOnlineShop\\womens-outfit-navy-blue-120117-344-03-800x534.jpg", 129.99, "", 0.5, 44));
		women.addItem(new NonFragileProduct("Women Trench Coat" ,"C:\\Users\\addme\\Documents\\PhotoOnlineShop\\womens-trench-coat-120117-345-05-800x535.jpg", 88.99, "", 0.5, 44));
		Customer.addCustomer("Hwi Li Yi", "liyi98","1","Female","1", "1", "hi", "hh", "loveyou");
		Customer.addCustomer("Chow Khai Bin", "khaibin","1", "1", "1", "hi","hi", "hh", "ss");
		Customer.addCustomer("k", "1","j", "1","1", "hi", "hi", "hh", "ss");
		Customer.addCustomer("k", "1","j", "1","1", "hi", "hi", "hh", "11");
		Customer.addCustomer("Hwi Li Yi", "liyi98","1","Female","1", "1", "hi", "hh", "loveyou");
		Customer.addCustomer("Chow Khai Bin", "khaibin","1", "1", "1", "hi","hi", "hh", "ss");
		Customer.addCustomer("k", "1","j", "1","1", "hi", "hi", "hh", "ss");
		Customer.addCustomer("k", "1","j", "1","1", "hi", "hi", "hh", "11");
		Customer.addCustomer("Hwi Li Yi", "liyi98","1","Female","1", "1", "hi", "hh", "loveyou");
		Customer.addCustomer("Chow Khai Bin", "khaibin","1", "1", "1", "hi","hi", "hh", "ss");
		Customer.addCustomer("k", "1","j", "1","1", "hi", "hi", "hh", "ss");
		Customer.addCustomer("k", "1","j", "1","1", "hi", "hi", "hh", "11");
		Customer.addCustomer("Hwi Li Yi", "liyi98","1","Female","1", "1", "hi", "hh", "loveyou");
		Customer.addCustomer("Chow Khai Bin", "khaibin","1", "1", "1", "hi","hi", "hh", "ss");
		Customer.addCustomer("k", "1","j", "1","1", "hi", "hi", "hh", "ss");
		Customer.addCustomer("k", "1","j", "1","1", "hi", "hi", "hh", "11");
	
		new ActivityHomePage();
		//for(int u = 0; u<Item.searchItemByName("b").size(); u++){
			//System.out.println(item.searchItemByName("b").get(u).getName());
		//}
	


	}

}
