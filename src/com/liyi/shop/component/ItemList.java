package com.liyi.shop.component;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import com.liyi.shop.Main;
import com.liyi.shop.model.Product;

import java.util.ArrayList;
import javax.swing.BoxLayout;
import java.awt.Color;

public class ItemList extends JPanel {
	
	public ItemList(int i, ArrayList<Product> item) {
		System.out.println(i);
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		setSize(620,250);
		for (int a = 0; a < 3; i++, a++) {
			if (i < item.size()) {
			add(new ItemSingle(item.get(i)));
			} else {
				add(new ItemSingleBlank("C:\\Users\\addme\\Documents\\PhotoOnlineShop\\2013-new-hot-summer-fashion-cozy-women-clothes.jpg","",11.0));
			}
		}

		setVisible(true);
	}

}
